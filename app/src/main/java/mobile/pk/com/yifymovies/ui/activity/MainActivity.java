package mobile.pk.com.yifymovies.ui.activity;

import mobile.pk.com.yifymovies.ui.fragments.MoviesFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mobile.pk.com.yifymovies.R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(mobile.pk.com.yifymovies.R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(mobile.pk.com.yifymovies.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == mobile.pk.com.yifymovies.R.id.action_settings) {
            return true;
        }
        if(id== mobile.pk.com.yifymovies.R.id.list_movies)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MoviesFragment moviesFragment = MoviesFragment.newInstance();
            fragmentTransaction.add(mobile.pk.com.yifymovies.R.id.fragment_container, moviesFragment, "movieList");
            fragmentTransaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }
}
