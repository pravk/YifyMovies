package mobile.pk.com.yifymovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.util.List;

import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.service.MovieDetailService;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailViewHolder> {

    private final Context mContext;
    private MovieDetailService.MovieDetailResponse movieDetailResponse;

    RVItemClickListener rvItemClickListener;

    public MovieDetailAdapter(Context context, MovieDetailService.MovieDetailResponse movieDetailResponse) {
        this.mContext = context;
        this.setMovieDetailResponse(movieDetailResponse);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public MovieDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        if(type==0)
            return getScreenshotViewHolder(viewGroup);
        if(type==1)
            return getMovieInfoViewHolder(viewGroup);
        if(type==2)
            return getMovieDirectorViewHolder(viewGroup);
        if(type>2 && type<getMovieDetailResponse().getData().getTorrents().size()+3)
            return getTorrentViewHolder(viewGroup);
        return null;
    }

    private MovieDetailViewHolder getMovieDirectorViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_cast,  viewGroup, false);

        return new MovieDirectorViewHolder(view);
    }

    protected MovieDetailViewHolder getScreenshotViewHolder(ViewGroup viewGroup)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_screenshot,  viewGroup, false);

       return new MovieScreenshotViewHolder(view);
    }

    protected MovieTorrentInfoViewHolder getTorrentViewHolder(ViewGroup viewGroup)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_torrent,  viewGroup, false);

        return new MovieTorrentInfoViewHolder(view);
    }

    protected MovieViewHolder getMovieInfoViewHolder(ViewGroup viewGroup)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_movie_item,  viewGroup, false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieDetailViewHolder movieDetailViewHolder, int i) {
        if(movieDetailViewHolder instanceof  MovieViewHolder)
        {
            MovieViewHolder movieViewHolder = ((MovieViewHolder) movieDetailViewHolder);

            Picasso.with(mContext).load(getMovieDetailResponse().getData().getImages().getMediumCoverImage())
                    .into(movieViewHolder.coverImage);

            //Setting text view title
            movieViewHolder.title.setText(getMovieDetailResponse().getData().getTitle());
            movieViewHolder.year.setText("Year: " + getMovieDetailResponse().getData().getYear().toString());
            movieViewHolder.genre.setText("Genres: " + TextUtils.join(", ", getMovieDetailResponse().getData().getGenres()));
            movieViewHolder.rating.setText("Rating: " + getMovieDetailResponse().getData().getRating().toString());
            movieViewHolder.language.setText("Language: " + getMovieDetailResponse().getData().getLanguage());
            movieViewHolder.mpaRating.setText("MPA : " + getMovieDetailResponse().getData().getMpaRating());
            movieViewHolder.runtime.setText("Runtime: " + getMovieDetailResponse().getData().getRuntime());
            movieViewHolder.quality.setText("");
        }
        else if (movieDetailViewHolder instanceof  MovieScreenshotViewHolder)
        {
            MovieScreenshotViewHolder viewHolder1 = (MovieScreenshotViewHolder) movieDetailViewHolder;
            TextSliderView sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage1())
                    .description("Screenshot 1")
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            viewHolder1.sliderShow.addSlider(sliderView);
            sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage2())
                    .description("Screenshot 2")
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            viewHolder1.sliderShow.addSlider(sliderView);
            sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage3())
                    .description("Screenshot 3")
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            viewHolder1.sliderShow.addSlider(sliderView);
        }
        else if(movieDetailViewHolder instanceof  MovieTorrentInfoViewHolder)
        {
            MovieTorrentInfoViewHolder viewHolder = (MovieTorrentInfoViewHolder) movieDetailViewHolder;
            MovieDetailService.Torrent torrent = getMovieDetailResponse().getData().getTorrents().get(i-3);
            viewHolder.peers.setText("Peers: " + torrent.getPeers().toString());
            viewHolder.quality.setText("Quality: " +torrent.getQuality());
            viewHolder.resolution.setText("Resolution: " +torrent.getResolution());
            viewHolder.seeds.setText("Seeds: " +torrent.getSeeds().toString());
            viewHolder.size.setText("Size: " +torrent.getSize());
        }
        else if(movieDetailViewHolder instanceof  MovieDirectorViewHolder)
        {
            MovieDirectorViewHolder viewHolder = (MovieDirectorViewHolder) movieDetailViewHolder;
            List<MovieDetailService.Director> directorList= getMovieDetailResponse().getData().getDirectors();
            for(MovieDetailService.Director director : directorList)
            {
                View personView = LayoutInflater.from(mContext).inflate(R.layout.view_person, null);
                TextView tv = (TextView) personView.findViewById(R.id.text);
                ImageView iv = (ImageView) personView.findViewById(R.id.image);
                tv.setText(director.getName());

                Picasso.with(mContext).load(director.getMediumImage())
                        .into(iv);

                viewHolder.directors.addView(personView);
            }
            List<MovieDetailService.Actor> actorList= getMovieDetailResponse().getData().getActors();
            for(MovieDetailService.Actor actor : actorList)
            {
                View personView = LayoutInflater.from(mContext).inflate(R.layout.view_person, null);
                TextView tv = (TextView) personView.findViewById(R.id.text);
                ImageView iv = (ImageView) personView.findViewById(R.id.image);
                //tv.setText(actor.getName());
                tv.setText("");
                iv.setContentDescription(actor.getName());
                Picasso.with(mContext).load(actor.getMediumImage())
                        .into(iv);

                viewHolder.actors.addView(personView);
            }
        }

    }

    @Override
    public int getItemCount() {
        if(movieDetailResponse== null)
            return 0;
        return 3 + movieDetailResponse.getData().getTorrents().size();
    }

    public MovieDetailService.MovieDetailResponse getMovieDetailResponse() {
        return movieDetailResponse;
    }

    public void setMovieDetailResponse(MovieDetailService.MovieDetailResponse movieDetailResponse) {
        this.movieDetailResponse = movieDetailResponse;
        notifyDataSetChanged();
    }
}
