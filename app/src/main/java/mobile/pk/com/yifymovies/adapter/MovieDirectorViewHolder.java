package mobile.pk.com.yifymovies.adapter;

import android.view.View;
import android.widget.TextView;

import org.apmem.tools.layouts.FlowLayout;

import mobile.pk.com.yifymovies.R;

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
