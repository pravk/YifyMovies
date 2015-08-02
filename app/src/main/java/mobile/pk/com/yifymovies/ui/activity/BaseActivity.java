package mobile.pk.com.yifymovies.ui.activity;

import mobile.pk.com.yifymovies.Application;
import mobile.pk.com.yifymovies.service.RestClient;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by hello on 8/1/2015.
 */
public class BaseActivity extends AppCompatActivity {

    public static final int MOVIE_DETAIL_REQUEST = 1000;
    public static final int MOVIE_SEARCH_REQUEST = 2000;
    public static final int MOVIE_LIST_FILTER_REQUEST = 3000;
    private static final String TAG = BaseActivity.class.getSimpleName();

    protected Application getYifyApplication()
    {
        return (Application)getApplication();
    }

    protected RestClient getRestClient()
    {
        return getYifyApplication().getRestClient();
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
