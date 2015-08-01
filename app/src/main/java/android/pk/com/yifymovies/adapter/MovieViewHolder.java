package android.pk.com.yifymovies.adapter;

import android.pk.com.yifymovies.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder{

    ImageView coverImage;
    TextView title;
    TextView year;
    TextView rating;
    TextView genre;
    TextView language;
    TextView mpaRating;
    TextView runtime;
    TextView quality;

    public MovieViewHolder(View itemView) {
        super(itemView);
        coverImage = (ImageView) itemView.findViewById(R.id.cover_image);
        title = (TextView) itemView.findViewById(R.id.title);
        year = (TextView) itemView.findViewById(R.id.year);
        rating = (TextView) itemView.findViewById(R.id.rating);
        genre = (TextView) itemView.findViewById(R.id.genres);
        language = (TextView) itemView.findViewById(R.id.language);
        mpaRating = (TextView) itemView.findViewById(R.id.mpa_rating);
        runtime = (TextView) itemView.findViewById(R.id.runtime);
        quality = (TextView) itemView.findViewById(R.id.quality);
    }

}
