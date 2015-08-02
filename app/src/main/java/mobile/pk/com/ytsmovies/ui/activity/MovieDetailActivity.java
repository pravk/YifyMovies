package mobile.pk.com.ytsmovies.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import butterknife.ButterKnife;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.adapter.MovieDetailFragmentAdapter;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDetailActivity extends BaseActivity {

    public static final String MOVIE_ID = "MOVIE_ID";
    public static final String MOVIE_TITLE = "MOVIE_TITLE";
    private static final String TAG = MovieDetailActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String movieTitle = getIntent().getStringExtra(MOVIE_TITLE);
        setTitle(movieTitle);

        ButterKnife.inject(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        String movieId = getIntent().getStringExtra(MOVIE_ID);
        if(TextUtils.isEmpty(movieId))
            finish();
        else {
            viewPager.setAdapter(new MovieDetailFragmentAdapter(getSupportFragmentManager(), movieId));
            tabLayout.setupWithViewPager(viewPager);
        }
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
