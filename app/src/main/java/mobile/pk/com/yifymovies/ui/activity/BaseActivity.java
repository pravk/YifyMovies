package mobile.pk.com.yifymovies.ui.activity;

import mobile.pk.com.yifymovies.Application;
import mobile.pk.com.yifymovies.service.RestClient;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hello on 8/1/2015.
 */
public class BaseActivity extends AppCompatActivity {

    public static final int MOVIE_DETAIL_REQUEST = 1000;
    public static final int MOVIE_SEARCH_REQUEST = 2000;

    protected Application getYifyApplication()
    {
        return (Application)getApplication();
    }

    protected RestClient getRestClient()
    {
        return getYifyApplication().getRestClient();
    }
}
