package mobile.pk.com.ytsmovies.adapter;

import mobile.pk.com.ytsmovies.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieViewHolder extends MovieDetailViewHolder implements View.OnClickListener{

    ImageView coverImage;
    TextView title;
    TextView year;
    TextView rating;
    TextView genre;
    TextView language;
    TextView mpaRating;
    TextView runtime;
    TextView quality;
    TextView description;
    ViewGroup descriptionLayout;

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
        description = (TextView) itemView.findViewById(R.id.description);
        descriptionLayout = (ViewGroup) itemView.findViewById(R.id.description_layout);
    }

    @Override
    public void onClick(View v) {

    }
}
