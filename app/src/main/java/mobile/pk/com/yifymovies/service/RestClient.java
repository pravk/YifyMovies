package mobile.pk.com.yifymovies.service;

import android.content.Context;
import mobile.pk.com.yifymovies.R;

import retrofit.RestAdapter;

/**
 * Created by hello on 8/1/2015.
 */
public class RestClient {

    private MovieListService movieListService;
    private MovieDetailService movieDetailService;

    public RestClient(Context context)
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(context.getString(R.string.server_url))
                .build();

        movieListService = restAdapter.create(MovieListService.class);
        movieDetailService = restAdapter.create(MovieDetailService.class);
    }

    public MovieListService getMovieListService() {
        return movieListService;
    }

    public MovieDetailService getMovieDetailService() {
        return movieDetailService;
    }
}
