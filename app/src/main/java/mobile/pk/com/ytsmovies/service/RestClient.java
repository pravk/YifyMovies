package mobile.pk.com.ytsmovies.service;

import android.content.Context;
import mobile.pk.com.ytsmovies.R;

import retrofit.RestAdapter;

/**
 * Created by hello on 8/1/2015.
 */
public class RestClient {

    private MovieListService movieListService;
    private MovieDetailService movieDetailService;
    private MovieReviewService movieReviewService;
    private MovieCommentService movieCommentService;

    public RestClient(Context context)
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(context.getString(R.string.server_url))
                .build();

        movieListService = restAdapter.create(MovieListService.class);
        movieDetailService = restAdapter.create(MovieDetailService.class);
        movieReviewService = restAdapter.create(MovieReviewService.class);
        movieCommentService = restAdapter.create(MovieCommentService.class);
    }

    public MovieListService getMovieListService() {
        return movieListService;
    }

    public MovieDetailService getMovieDetailService() {
        return movieDetailService;
    }

    public MovieReviewService getMovieReviewService() {
        return movieReviewService;
    }

    public MovieCommentService getMovieCommentService() {
        return movieCommentService;
    }
}
