package mobile.pk.com.yifymovies.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mobile.pk.com.yifymovies.ui.fragments.GenresFragment;
import mobile.pk.com.yifymovies.ui.fragments.MovieDetailFragment;
import mobile.pk.com.yifymovies.ui.fragments.MovieSuggestionFragment;
import mobile.pk.com.yifymovies.ui.fragments.MoviesFragment;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDetailFragmentAdapter extends FragmentPagerAdapter {

    private String [] tabs = new String[] {"Details", "Suggestions"};
    private String movieId;

    public MovieDetailFragmentAdapter(FragmentManager fm, String movieId) {
        super(fm);
        this.movieId = movieId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return MovieDetailFragment.newInstance(movieId);
            case 1:
                return MovieSuggestionFragment.newInstance(movieId);

        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
