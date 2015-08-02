package mobile.pk.com.ytsmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.service.MovieReviewService;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewViewHolder> {

    private final Context mContext;
    private MovieReviewService.MovieReviewResponse movieReviewResponse;


    public MovieReviewAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public MovieReviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_review_item,  viewGroup, false);

        MovieReviewViewHolder viewHolder = new MovieReviewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieReviewViewHolder movieViewHolder, int i) {
        MovieReviewService.Review movieReview = getMovieReviewResponse().getData().getReviews().get(i);

        movieViewHolder.text.setText(movieReview.getReviewText());
        movieViewHolder.summary.setText(movieReview.getReviewSummary());
        movieViewHolder.user.setText(movieReview.getUsername());
    }

    @Override
    public int getItemCount() {
        if(getMovieReviewResponse() == null)
            return 0;
        return getMovieReviewResponse().getData().getReviews().size();
    }

    public MovieReviewService.MovieReviewResponse getMovieReviewResponse() {
        return movieReviewResponse;
    }

    public void setMovieReviewResponse(MovieReviewService.MovieReviewResponse movieReviewResponse) {
        this.movieReviewResponse = movieReviewResponse;
        notifyDataSetChanged();
    }
}
