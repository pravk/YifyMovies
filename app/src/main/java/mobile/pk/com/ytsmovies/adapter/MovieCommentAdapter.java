package mobile.pk.com.ytsmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.service.MovieCommentService;
import mobile.pk.com.ytsmovies.service.MovieReviewService;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieCommentAdapter extends RecyclerView.Adapter<MovieCommentViewHolder> {

    private final Context mContext;
    private MovieCommentService.MovieCommentResponse movieCommentResponse;


    public MovieCommentAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public MovieCommentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_comment_item,  viewGroup, false);

        MovieCommentViewHolder viewHolder = new MovieCommentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieCommentViewHolder movieViewHolder, int i) {
        MovieCommentService.Comment movieComment = getMovieCommentResponse().getData().getComments().get(i);

        if(movieComment != null) {
            movieViewHolder.commentText.setText(movieComment.getCommentText());
            movieViewHolder.likeCount.setText(movieComment.getLikeCount().toString());
            movieViewHolder.dateAdded.setText(movieComment.getDateAdded());
            movieViewHolder.userName.setText(movieComment.getUsername());
            Picasso.with(mContext).load(movieComment.getMediumUserAvatarImage()).into(movieViewHolder.avatar);
        }
    }

    @Override
    public int getItemCount() {
        if(getMovieCommentResponse() == null)
            return 0;
        return getMovieCommentResponse().getData().getCommentCount();
    }

    public MovieCommentService.MovieCommentResponse getMovieCommentResponse() {
        return movieCommentResponse;
    }

    public void setMovieCommentResponse(MovieCommentService.MovieCommentResponse movieCommentResponse) {
        this.movieCommentResponse = movieCommentResponse;
        notifyDataSetChanged();
    }
}
