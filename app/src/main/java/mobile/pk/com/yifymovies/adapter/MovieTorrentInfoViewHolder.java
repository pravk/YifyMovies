package mobile.pk.com.yifymovies.adapter;

import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;

import mobile.pk.com.yifymovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieTorrentInfoViewHolder extends MovieDetailViewHolder {

    TextView quality;
    TextView seeds;
    TextView peers;
    TextView resolution;
    TextView size;


    public MovieTorrentInfoViewHolder(View itemView) {
        super(itemView);
        quality = (TextView) itemView.findViewById(R.id.quality);
        seeds = (TextView) itemView.findViewById(R.id.seeds);
        peers = (TextView) itemView.findViewById(R.id.peers);
        resolution = (TextView) itemView.findViewById(R.id.resolution);
        size = (TextView) itemView.findViewById(R.id.size);
    }

}