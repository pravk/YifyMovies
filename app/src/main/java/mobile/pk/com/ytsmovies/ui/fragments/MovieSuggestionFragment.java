package mobile.pk.com.ytsmovies.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import mobile.pk.com.ytsmovies.service.MovieListService;
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
public class MovieSuggestionFragment extends MoviesFragment {

    public static MovieSuggestionFragment newInstance(String movieId) {
        MovieSuggestionFragment fragment = new MovieSuggestionFragment();
        Bundle args = new Bundle();
        args.putString("movieId", movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void getMovieList(Map<String,String> filters, final Callback<MovieListService.MovieListResponse> callback){
        Bundle args = getArguments();
        movieListService.getMovieSuggestionList(args.getString("movieId"), new Callback<MovieListService.MovieListResponse>() {
            @Override
            public void success(MovieListService.MovieListResponse movieListResponse, Response response) {
                movieListResponse.getData().setMovies(movieListResponse.getData().getMovieSuggestions());
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
