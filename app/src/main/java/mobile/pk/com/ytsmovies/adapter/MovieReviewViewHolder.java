package mobile.pk.com.ytsmovies.adapter;

import android.view.View;
import android.widget.TextView;

import mobile.pk.com.ytsmovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieReviewViewHolder extends MovieDetailViewHolder {

    TextView summary;
    TextView text;
    TextView user;

    public MovieReviewViewHolder(View itemView) {
        super(itemView);
        summary = (TextView) itemView.findViewById(R.id.review_summary);
        text = (TextView) itemView.findViewById(R.id.review_text);
        user = (TextView) itemView.findViewById(R.id.review_user);
    }

}
