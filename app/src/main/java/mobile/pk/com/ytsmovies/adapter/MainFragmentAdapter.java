package mobile.pk.com.ytsmovies.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mobile.pk.com.ytsmovies.ui.fragments.GenresFragment;
import mobile.pk.com.ytsmovies.ui.fragments.MovieUpcomingFragment;
import mobile.pk.com.ytsmovies.ui.fragments.MoviesFragment;

/**
 * Created by hello on 8/1/2015.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    private String [] tabs = new String[] {"Home", "Categories", "Upcoming"};

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MoviesFragment();
            case 1:
                return new GenresFragment();
            case 2:
                return new MovieUpcomingFragment();

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
