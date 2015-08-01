package mobile.pk.com.yifymovies.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import mobile.pk.com.yifymovies.Application;
import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.adapter.MovieDetailRecyclerAdapter;
import mobile.pk.com.yifymovies.adapter.MovieListAdapter;
import mobile.pk.com.yifymovies.adapter.RVItemClickListener;
import mobile.pk.com.yifymovies.service.MovieDetailService;
import mobile.pk.com.yifymovies.service.MovieListService;
import mobile.pk.com.yifymovies.ui.activity.BaseActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieDetailActivity;
import mobile.pk.com.yifymovies.ui.utils.EndlessRecyclerOnScrollListener;
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
public class MovieDetailFragment extends Fragment {

    MovieDetailService movieDetailService;
    MovieDetailRecyclerAdapter adapter;

    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public static MovieDetailFragment newInstance(String movieId) {
        MovieDetailFragment f = new MovieDetailFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("movieId", movieId);
        f.setArguments(args);
        return f;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieDetailService = ((Application) getActivity().getApplication()).getRestClient().getMovieDetailService();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        RecyclerView recyclerView =   (RecyclerView) view.findViewById(R.id.movie_detail);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieDetailRecyclerAdapter(getActivity(), null);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String movieId = args.getString("movieId", "");
        loadMovie(movieId);
    }

    protected void loadMovie(String movieId) {
        movieDetailService.getMovieDetails(movieId, new Callback<MovieDetailService.MovieDetailResponse>() {
            @Override
            public void success(MovieDetailService.MovieDetailResponse movieDetailResponse, Response response) {
                bindData(movieDetailResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void bindData(MovieDetailService.MovieDetailResponse movieDetailResponse) {
        getActivity().setTitle(movieDetailResponse.getData().getTitle());
        adapter.setMovieDetailResponse(movieDetailResponse);
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
