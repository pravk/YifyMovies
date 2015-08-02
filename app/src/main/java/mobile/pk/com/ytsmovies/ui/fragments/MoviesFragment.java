package mobile.pk.com.ytsmovies.ui.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import mobile.pk.com.ytsmovies.Application;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.adapter.MovieListAdapter;
import mobile.pk.com.ytsmovies.adapter.RVItemClickListener;
import mobile.pk.com.ytsmovies.service.MovieListService;
import mobile.pk.com.ytsmovies.ui.activity.BaseActivity;
import mobile.pk.com.ytsmovies.ui.activity.MovieDetailActivity;
import mobile.pk.com.ytsmovies.ui.utils.EndlessRecyclerOnScrollListener;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A fragment representing a list of Items.
 * <p>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class MoviesFragment extends Fragment {



    MovieListService movieListService;
    MovieListAdapter movieListAdapter;
    BootstrapButton btnFilter;
    BootstrapButton btnSort;

    public Map<String, String> getFilters() {
        if(filters == null)
            filters = new HashMap<>();
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    Map<String,String> filters;

    public static MoviesFragment newInstance(HashMap<String,String> filters) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putSerializable("filters", filters);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MoviesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieListService = ((Application) getActivity().getApplication()).getRestClient().getMovieListService();
        Bundle args = getArguments();
        if(args!= null && args.getSerializable("filters") != null)
        {
            filters = (Map<String, String>) args.getSerializable("filters");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(mobile.pk.com.ytsmovies.R.layout.fragment_movie_list, container, false);

        final RecyclerView recyclerView =   (RecyclerView) view.findViewById(mobile.pk.com.ytsmovies.R.id.movie_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        movieListAdapter = new MovieListAdapter(getActivity(), new RVItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String movieId = movieListAdapter.getMovieId(position);
                String movieTitle = movieListAdapter.getMovieTitle(position);
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE_ID, movieId);
                intent.putExtra(MovieDetailActivity.MOVIE_TITLE, movieTitle);
                getActivity().startActivityForResult(intent, BaseActivity.MOVIE_DETAIL_REQUEST);
            }
        });

        recyclerView.setAdapter(movieListAdapter);

        resetData();
        ViewGroup filter = (ViewGroup) view.findViewById(R.id.vg_filters);
        resetFilterVisibility(filter);

        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                getMovieList(getFilters(), String.valueOf(current_page), new Callback<MovieListService.MovieListResponse>() {
                    @Override
                    public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                        if (movieListResponse != null)
                            movieListAdapter.addMovies(movieListResponse.getData().getMovies());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), mobile.pk.com.ytsmovies.R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnSort = (BootstrapButton) view.findViewById(R.id.btn_sort);

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String [] items = getResources().getStringArray(R.array.sort_by);
                String sortBy = getSortBy();
                int selectedIndex = items.length-1;
                for(int index = 0; index< items.length; index ++)
                {
                    String item = items[index];
                    if(item.equals(sortBy))
                    {
                        selectedIndex = index;
                        break;
                    }
                }
                new AlertDialog.Builder(getActivity())
                        .setSingleChoiceItems(R.array.sort_by, selectedIndex, null)
                        .setPositiveButton(R.string.ok_button_label, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                                int selectedPosition = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
                                applySort(items[selectedPosition], 0);
                                resetData();
                            }
                        })
                        .show();
            }
        });

        btnFilter = (BootstrapButton) view.findViewById(R.id.btn_filter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MovieFilterActivity.class);
                intent.putExtra(MovieFilterActivity.FILTER_MAP, (HashMap<String,String>) getFilters());
                startActivityForResult(intent, BaseActivity.MOVIE_LIST_FILTER_REQUEST);
            }
        });

        return view;
    }

    protected void resetFilterVisibility(ViewGroup filter) {
        filter.setVisibility(View.VISIBLE);
    }

    protected String getSortBy()
    {
        if(filters != null)
        {
            return filters.get("sort_by");
        }
        return null;
    }
    protected void applySort(String field, int direction)
    {
        if(filters == null)
            filters = new HashMap<>();

        filters.put("sort_by", field);
    }

    private void resetData() {
        movieListAdapter.clearMovies();
        getMovieList(getFilters(), new Callback<MovieListService.MovieListResponse>() {
            @Override
            public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                movieListAdapter.addMovies(movieListResponse.getData().getMovies());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), mobile.pk.com.ytsmovies.R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void getMovieList(Map<String,String> filters, Callback<MovieListService.MovieListResponse> callback){
        movieListService.getMovieList(filters, callback);
    }

    protected void getMovieList(Map<String,String> filters, String page ,Callback<MovieListService.MovieListResponse> callback){
        Map<String,String> options = new HashMap<String, String>();
        if(getFilters() != null)
            options.putAll(getFilters());
        options.put("page", String.valueOf(page));
        getMovieList(options, callback);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == BaseActivity.MOVIE_LIST_FILTER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                HashMap<String,String> result = (HashMap<String, String>) data.getSerializableExtra(MovieFilterActivity.FILTER_MAP);
                String quality = result.get("quality");
                if(quality == null)
                    getFilters().remove("quality");
                else
                    getFilters().put("quality", quality);

                String rating = result.get("minimum_rating");
                if(rating == null)
                    getFilters().remove("minimum_rating");
                else
                    getFilters().put("minimum_rating", rating);

                resetData();
            }
        }
    }

}
