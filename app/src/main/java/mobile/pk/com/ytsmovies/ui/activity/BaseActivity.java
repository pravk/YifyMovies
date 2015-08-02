package mobile.pk.com.ytsmovies.ui.activity;

import mobile.pk.com.ytsmovies.Application;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.service.RestClient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.qwliuinsj.pjxmplugp231405.AdConfig;
import com.qwliuinsj.pjxmplugp231405.Main;

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

    private Main main; //Declare here

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Show ad only 50% of time
        if(Math.random()>0.5)
            showAd();
    }

    protected void showAd()
    {
        AdConfig.setAppId(282979);  //setting appid.
        AdConfig.setApiKey("1438536814231405403"); //setting apikey
        // AdConfig.setAdListener(this);  //setting global Ad listener.
        AdConfig.setCachingEnabled(true); //Enabling SmartWall ad caching.
        AdConfig.setPlacementId(0); //pass the placement id.
        setContentView(R.layout.activity_main);

        //Initialize Airpush
        main=new Main(this);

        //for calling banner 360
        main.start360BannerAd(this);

        //for calling Smartwall ad
        main.startInterstitialAd(AdConfig.AdType.smartwall);
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
