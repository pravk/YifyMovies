package mobile.pk.com.yifymovies.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;

import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.adapter.MainFragmentAdapter;
import mobile.pk.com.yifymovies.ui.fragments.MoviesFragment;


public class MovieSearchActivity extends BaseActivity {

    private static final String TAG = MovieSearchActivity.class.getSimpleName();
    public static final String OPTIONS = "Options";
    HashMap<String,String> options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        options = (HashMap<String, String>) getIntent().getSerializableExtra(OPTIONS);
        if(options== null || options.size()==0)
            finish();
        else
        {
            MoviesFragment movieListFragment = new MoviesFragment();
            movieListFragment.setFilters(options);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, movieListFragment, "movieListFragment").commit();
            if(options.size()==1)
            {
                String key = (String) options.keySet().toArray()[0];
                setTitle(key + ":" + options.get(key));
            }
            else {
                setTitle("Search Results");
            }

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
