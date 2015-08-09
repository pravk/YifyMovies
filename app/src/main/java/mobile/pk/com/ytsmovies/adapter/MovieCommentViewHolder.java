package mobile.pk.com.ytsmovies.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mobile.pk.com.ytsmovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieCommentViewHolder extends MovieDetailViewHolder {

    TextView userName;
    ImageView avatar;
    TextView likeCount;
    TextView commentText;
    TextView dateAdded;

    public MovieCommentViewHolder(View itemView) {
        super(itemView);
        userName = (TextView) itemView.findViewById(R.id.user_name);
        likeCount = (TextView) itemView.findViewById(R.id.like_count);
        commentText = (TextView) itemView.findViewById(R.id.comment_text);
        dateAdded = (TextView) itemView.findViewById(R.id.date_added);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);

    }

}
