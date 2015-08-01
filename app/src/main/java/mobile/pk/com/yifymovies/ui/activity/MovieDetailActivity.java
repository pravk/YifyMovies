package mobile.pk.com.yifymovies.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.adapter.MovieDetailAdapter;
import mobile.pk.com.yifymovies.service.MovieDetailService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDetailActivity extends BaseActivity {

    public static final String MOVIE_ID = "MOVIE_ID";
    private static final String TAG = MovieDetailActivity.class.getSimpleName();
    MovieDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.inject(this);

        String movieId = getIntent().getStringExtra(MOVIE_ID);
        if(TextUtils.isEmpty(movieId))
            finish();
        else {
            RecyclerView recyclerView =   (RecyclerView) findViewById(R.id.movie_detail);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new MovieDetailAdapter(this, null);

            recyclerView.setAdapter(adapter);
            loadMovie(movieId);
        }
    }

    protected void loadMovie(String movieId) {
        getRestClient().getMovieDetailService().getMovieDetails(movieId, new Callback<MovieDetailService.MovieDetailResponse>() {
            @Override
            public void success(MovieDetailService.MovieDetailResponse movieDetailResponse, Response response) {
                bindData(movieDetailResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MovieDetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void bindData(MovieDetailService.MovieDetailResponse movieDetailResponse) {
        setTitle(movieDetailResponse.getData().getTitle());
        adapter.setMovieDetailResponse(movieDetailResponse);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Log.d(TAG, "action bar clicked");
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
