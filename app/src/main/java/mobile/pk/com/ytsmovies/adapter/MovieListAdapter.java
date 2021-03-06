package mobile.pk.com.ytsmovies.adapter;

import android.content.Context;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.service.MovieListService;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final Context mContext;
    List<MovieListService.Movie> movieList;

    RVItemClickListener rvItemClickListener;

    public MovieListAdapter(Context context, RVItemClickListener rvItemClickListener) {
        this.mContext = context;
        this.rvItemClickListener = rvItemClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_item,  viewGroup, false);

        final MovieViewHolder viewHolder = new MovieViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvItemClickListener.onItemClick(v,viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i) {
        MovieListService.Movie movie = movieList.get(i);

        //Download image using picasso library
        Picasso.with(mContext).load(movie.getMediumCoverImage())
                .into(movieViewHolder.coverImage);

        //Setting text view title
        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.year.setText("Year: " + movie.getYear().toString());
        if(movie.getGenres() != null && movie.getGenres().size()>0)
            movieViewHolder.genre.setText("Genres: " + TextUtils.join(", ", movie.getGenres()));
        else
            movieViewHolder.genre.setText("");
        if(movie.getRating() != null)
            movieViewHolder.rating.setText(movie.getRating().toString());
        else
            movieViewHolder.rating.setText("NA");

        if(movie.getLanguage() != null)
            movieViewHolder.language.setText("Language: " + movie.getLanguage());
        else
            movieViewHolder.language.setText("");
        if(movie.getMpaRating() != null)
            movieViewHolder.mpaRating.setText("MPA : " + movie.getMpaRating());
        else
            movieViewHolder.mpaRating.setText("");
        if(movie.getRuntime() != null)
            movieViewHolder.runtime.setText("Runtime: " + movie.getRuntime());
        else
            movieViewHolder.runtime.setText("");

        StringBuilder quality = new StringBuilder();
        for (MovieListService.Torrent torrent : movie.getTorrents())
        {
            if(quality.length()>0)
                quality.append(", ");
            quality.append(torrent.getQuality());
        }
        if(!TextUtils.isEmpty( quality.toString()))
            movieViewHolder.quality.setText("Quality: " + quality.toString());
        else
            movieViewHolder.quality.setText("");
    }

    @Override
    public int getItemCount() {
        if(movieList== null)
            return 0;
        return movieList.size();
    }

    public void addMovies(List<MovieListService.Movie> movies) {
        if(movieList == null)
            movieList = new ArrayList<>();
        movieList.addAll(movies);
        notifyDataSetChanged();
    }

    public String getMovieId(int index)
    {
        return movieList.get(index).getId();
    }

    public String getMovieTitle(int index   ) {
        return movieList.get(index).getTitle();
    }

    public void clearMovies() {
        if(movieList != null)
            movieList.clear();

    }
}
