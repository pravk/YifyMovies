package mobile.pk.com.ytsmovies.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.pk.com.ytsmovies.Application;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.adapter.MovieCommentAdapter;
import mobile.pk.com.ytsmovies.adapter.MovieReviewAdapter;
import mobile.pk.com.ytsmovies.service.MovieCommentService;
import mobile.pk.com.ytsmovies.service.MovieReviewService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieCommentFragment extends Fragment {



    MovieCommentService movieCommentService;
    MovieCommentAdapter movieCommentAdapter;
    String movieId;

    public static MovieCommentFragment newInstance(String movieId) {
        MovieCommentFragment fragment = new MovieCommentFragment();
        Bundle args = new Bundle();
        args.putString("movieId", movieId);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieCommentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieCommentService = ((Application) getActivity().getApplication()).getRestClient().getMovieCommentService();
        Bundle args = getArguments();
        movieId = args.getString("movieId");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_comment, container, false);

        final RecyclerView recyclerView =   (RecyclerView) view.findViewById(R.id.movie_comment_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        movieCommentAdapter = new MovieCommentAdapter(getActivity());
        recyclerView.setAdapter(movieCommentAdapter);

        movieCommentService.getMovieComments(movieId, new Callback<MovieCommentService.MovieCommentResponse>() {
            @Override
            public void success(MovieCommentService.MovieCommentResponse movieReviewResponse, Response response) {
                movieCommentAdapter.setMovieCommentResponse(movieReviewResponse);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return view;
    }

}
