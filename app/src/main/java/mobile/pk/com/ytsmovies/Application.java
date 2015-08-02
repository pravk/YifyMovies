package mobile.pk.com.ytsmovies;

import mobile.pk.com.ytsmovies.service.RestClient;

/**
 * Created by hello on 8/1/2015.
 */
public class Application extends android.app.Application {

    private RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        // SharedObjects.context = this;

        restClient = new RestClient(this);


    }

    public RestClient getRestClient() {
        return restClient;
    }
}
