package mobile.pk.com.ytsmovies.adapter;

import android.view.View;

import org.apmem.tools.layouts.FlowLayout;

import mobile.pk.com.ytsmovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDirectorViewHolder extends MovieDetailViewHolder {

    FlowLayout directors;
    FlowLayout actors;

    public MovieDirectorViewHolder(View itemView) {
        super(itemView);
        directors = (FlowLayout) itemView.findViewById(R.id.directors);
        actors = (FlowLayout) itemView.findViewById(R.id.actors);
    }

}
