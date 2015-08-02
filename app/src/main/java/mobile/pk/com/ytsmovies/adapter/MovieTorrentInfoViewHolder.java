package mobile.pk.com.ytsmovies.adapter;

import android.view.View;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import mobile.pk.com.ytsmovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieTorrentInfoViewHolder extends MovieDetailViewHolder {

    TextView quality;
    TextView seeds;
    TextView peers;
    TextView resolution;
    TextView size;
    BootstrapButton magnetLink;
    BootstrapButton torrentDownload;

    public MovieTorrentInfoViewHolder(View itemView) {
        super(itemView);
        quality = (TextView) itemView.findViewById(R.id.quality);
        seeds = (TextView) itemView.findViewById(R.id.seeds);
        peers = (TextView) itemView.findViewById(R.id.peers);
        resolution = (TextView) itemView.findViewById(R.id.resolution);
        size = (TextView) itemView.findViewById(R.id.size);
        magnetLink = (BootstrapButton) itemView.findViewById(R.id.magnet_download);
        torrentDownload = (BootstrapButton) itemView.findViewById(R.id.torrent_download);
    }

}
