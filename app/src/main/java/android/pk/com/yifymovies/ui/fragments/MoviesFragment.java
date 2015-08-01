package android.pk.com.yifymovies.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.pk.com.yifymovies.Application;
import android.pk.com.yifymovies.R;
import android.pk.com.yifymovies.adapter.MovieListAdapter;
import android.pk.com.yifymovies.service.MovieListService;
import android.pk.com.yifymovies.ui.utils.EndlessRecyclerOnScrollListener;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
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
    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private RecyclerView.Adapter mAdapter;

    // TODO: Rename and change types of parameters
    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        final RecyclerView recyclerView =   (RecyclerView) view.findViewById(R.id.movie_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final MovieListAdapter movieListAdapter = new MovieListAdapter(getActivity());

        movieListService.getMovieList(null, new Callback<MovieListService.MovieListResponse>() {
            @Override
            public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                movieListAdapter.addMovies(movieListResponse.getData().getMovies());
                recyclerView.setAdapter(movieListAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                Map<String,String> options = new HashMap<String, String>();
                options.put("page", String.valueOf(current_page));
                movieListService.getMovieList(options, new Callback<MovieListService.MovieListResponse>() {
                    @Override
                    public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                        movieListAdapter.addMovies(movieListResponse.getData().getMovies());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), R.string.failed_to_load_movies, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }


    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
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
