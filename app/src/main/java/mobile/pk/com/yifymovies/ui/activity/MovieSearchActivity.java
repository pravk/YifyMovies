package mobile.pk.com.yifymovies.ui.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.adapter.MainFragmentAdapter;
import mobile.pk.com.yifymovies.businessobjects.MovieFilter;
import mobile.pk.com.yifymovies.ui.fragments.MoviesFragment;


public class MovieSearchActivity extends BaseActivity {

    private static final String TAG = MovieSearchActivity.class.getSimpleName();
    public static final String OPTIONS = "Options";
    ArrayList<MovieFilter> options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(!handleIntent(getIntent())) {

            options = (ArrayList<MovieFilter>) getIntent().getSerializableExtra(OPTIONS);
            if (options == null || options.size() == 0)
                finish();
            else {
                HashMap<String, String> filters = new HashMap<>();
                for (MovieFilter movieFilter : options) {
                    filters.put(movieFilter.getName(), movieFilter.getValue());
                }
                MoviesFragment movieListFragment = MoviesFragment.newInstance(filters);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, movieListFragment, "movieListFragment").commit();
                if (options.size() == 1) {
                    setTitle(options.get(0).getDisplay());
                } else {
                    setTitle("Search Results");
                }
            }
        }

    }

    private boolean handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            HashMap<String,String> filters = new HashMap<>();
            filters.put("query_term", query);
            MoviesFragment movieListFragment = MoviesFragment.newInstance(filters);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, movieListFragment, "movieListFragment").commit();
            setTitle("Results for: " + query);
            return true;
        }
        return false;
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
