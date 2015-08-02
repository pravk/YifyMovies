package mobile.pk.com.ytsmovies.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import mobile.pk.com.ytsmovies.service.MovieListService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieUpcomingFragment extends MoviesFragment {

    public static MovieUpcomingFragment newInstance(String movieId) {
        MovieUpcomingFragment fragment = new MovieUpcomingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void getMovieList(Map<String,String> filters, final Callback<MovieListService.MovieListResponse> callback){
        Bundle args = getArguments();
        movieListService.getMovieUpcomingList(new Callback<MovieListService.MovieListResponse>() {
            @Override
            public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                movieListResponse.getData().setMovies(movieListResponse.getData().getMovieUpcoming());
                callback.success(movieListResponse, response);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    protected void getMovieList(Map<String,String> filters, String page ,Callback<MovieListService.MovieListResponse> callback){
        callback.success(null, null);
    }


    @Override
    protected void resetFilterVisibility(ViewGroup filter) {
        filter.setVisibility(View.GONE);
    }
}
