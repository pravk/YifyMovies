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
import mobile.pk.com.yifymovies.adapter.MovieListAdapter;
import mobile.pk.com.yifymovies.adapter.RVItemClickListener;
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
}
