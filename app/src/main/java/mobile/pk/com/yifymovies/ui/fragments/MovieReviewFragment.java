package mobile.pk.com.yifymovies.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
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
import mobile.pk.com.yifymovies.adapter.MovieListAdapter;
import mobile.pk.com.yifymovies.adapter.MovieReviewAdapter;
import mobile.pk.com.yifymovies.adapter.RVItemClickListener;
import mobile.pk.com.yifymovies.service.MovieListService;
import mobile.pk.com.yifymovies.service.MovieReviewService;
import mobile.pk.com.yifymovies.ui.activity.BaseActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieDetailActivity;
import mobile.pk.com.yifymovies.ui.utils.EndlessRecyclerOnScrollListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieReviewFragment extends Fragment {



    MovieReviewService movieReviewService;
    MovieReviewAdapter movieReviewAdapter;
    String movieId;

    public static MovieReviewFragment newInstance(String movieId) {
        MovieReviewFragment fragment = new MovieReviewFragment();
        Bundle args = new Bundle();
        args.putString("movieId", movieId);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieReviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieReviewService = ((Application) getActivity().getApplication()).getRestClient().getMovieReviewService();
        Bundle args = getArguments();
        movieId = args.getString("movieId");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_review, container, false);

        final RecyclerView recyclerView =   (RecyclerView) view.findViewById(R.id.movie_review_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        movieReviewAdapter = new MovieReviewAdapter(getActivity());
        recyclerView.setAdapter(movieReviewAdapter);

        movieReviewService.getMovieReviews(movieId, new Callback<MovieReviewService.MovieReviewResponse>() {
            @Override
            public void success(MovieReviewService.MovieReviewResponse movieReviewResponse, Response response) {
                movieReviewAdapter.setMovieReviewResponse(movieReviewResponse);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return view;
    }

}
