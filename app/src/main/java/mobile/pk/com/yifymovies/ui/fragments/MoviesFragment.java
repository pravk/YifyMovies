package mobile.pk.com.yifymovies.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import mobile.pk.com.yifymovies.Application;
import mobile.pk.com.yifymovies.adapter.MovieListAdapter;
import mobile.pk.com.yifymovies.adapter.RVItemClickListener;
import mobile.pk.com.yifymovies.service.MovieListService;
import mobile.pk.com.yifymovies.ui.activity.BaseActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieDetailActivity;
import mobile.pk.com.yifymovies.ui.utils.EndlessRecyclerOnScrollListener;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    public Map<String, String> getFilters() {
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
        View view = inflater.inflate(mobile.pk.com.yifymovies.R.layout.fragment_movie_list, container, false);

        final RecyclerView recyclerView =   (RecyclerView) view.findViewById(mobile.pk.com.yifymovies.R.id.movie_list);
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

        getMovieList(getFilters(), new Callback<MovieListService.MovieListResponse>() {
            @Override
            public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                movieListAdapter.addMovies(movieListResponse.getData().getMovies());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), mobile.pk.com.yifymovies.R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                getMovieList(getFilters(),String.valueOf(current_page) , new Callback<MovieListService.MovieListResponse>() {
                    @Override
                    public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                        if(movieListResponse != null)
                            movieListAdapter.addMovies(movieListResponse.getData().getMovies());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), mobile.pk.com.yifymovies.R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }

    protected void getMovieList(Map<String,String> filters, Callback<MovieListService.MovieListResponse> callback){
        movieListService.getMovieList(getFilters(), callback);
    }

    protected void getMovieList(Map<String,String> filters, String page ,Callback<MovieListService.MovieListResponse> callback){
        Map<String,String> options = new HashMap<String, String>();
        if(getFilters() != null)
            options.putAll(getFilters());
        options.put("page", String.valueOf(page));
        getMovieList(options, callback);
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
