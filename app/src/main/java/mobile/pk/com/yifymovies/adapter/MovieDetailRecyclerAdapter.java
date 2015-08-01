package mobile.pk.com.yifymovies.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import mobile.pk.com.yifymovies.R;
import mobile.pk.com.yifymovies.businessobjects.MovieFilter;
import mobile.pk.com.yifymovies.service.MovieDetailService;
import mobile.pk.com.yifymovies.ui.activity.BaseActivity;
import mobile.pk.com.yifymovies.ui.activity.MovieSearchActivity;
import mobile.pk.com.yifymovies.utils.TorrentUtils;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieDetailRecyclerAdapter extends RecyclerView.Adapter<MovieDetailViewHolder> {

    private final Context mContext;
    private MovieDetailService.MovieDetailResponse movieDetailResponse;

    RVItemClickListener rvItemClickListener;

    public MovieDetailRecyclerAdapter(Context context, MovieDetailService.MovieDetailResponse movieDetailResponse) {
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

            /*movieViewHolder.description.setText(getMovieDetailResponse().getData().getDescriptionFull());
            movieViewHolder.descriptionLayout.setVisibility(View.VISIBLE);*/

        }
        else if (movieDetailViewHolder instanceof  MovieScreenshotViewHolder)
        {
            MovieScreenshotViewHolder viewHolder1 = (MovieScreenshotViewHolder) movieDetailViewHolder;
            viewHolder1.sliderShow.removeAllSliders();
            TextSliderView sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage1())
                    .description(getMovieDetailResponse().getData().getDescriptionIntro())
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            viewHolder1.sliderShow.addSlider(sliderView);
            sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage2())
                    .description(getMovieDetailResponse().getData().getDescriptionIntro())
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            viewHolder1.sliderShow.addSlider(sliderView);
            sliderView = new TextSliderView(mContext);
            sliderView.image(getMovieDetailResponse().getData().getImages().getLargeScreenshotImage3())
                    .description(getMovieDetailResponse().getData().getDescriptionIntro())
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
            viewHolder.size.setText("Size: " + torrent.getSize());
            viewHolder.magnetLink.setTag(torrent.getHash() + "," + getMovieDetailResponse().getData().getTitle());
            viewHolder.magnetLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String torrent = (String) v.getTag();
                    if (torrent != null) {
                        String[] strings = torrent.split(",");
                        try {
                            String magnetLink = TorrentUtils.getTorrentLink(strings[0], strings[1]);
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(magnetLink));
                            if(TorrentUtils.canHandleIntent(mContext, i)) {
                                ((Activity) mContext).startActivity(i);
                            }
                            else
                            {
                                TorrentUtils.addMagnetToClipboard(mContext,magnetLink);
                                Toast.makeText(mContext,"Magnet link added to clipboard", Toast.LENGTH_SHORT).show();
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            viewHolder.torrentDownload.setTag(torrent.getUrl());
            viewHolder.torrentDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String torrent = (String) v.getTag();
                    if (torrent != null) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(torrent));
                            ((Activity) mContext).startActivity(i);

                    }
                }
            });
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
                iv.setTag(director);
                Picasso.with(mContext).load(director.getMediumImage())
                        .into(iv);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieDetailService.Director director1 = (MovieDetailService.Director) v.getTag();
                        if(director1!=null)
                        {
                            Intent intent = new Intent(mContext, MovieSearchActivity.class);
                            ArrayList<MovieFilter> options = new ArrayList<MovieFilter>();
                            options.add(new MovieFilter("query_term", director1.getImdbCode(), director1.getName()));
                            intent.putExtra(MovieSearchActivity.OPTIONS, options);
                            ((Activity)mContext).startActivityForResult(intent, BaseActivity.MOVIE_SEARCH_REQUEST);
                        }
                    }
                });
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

                iv.setTag(actor);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MovieDetailService.Actor actor1 = (MovieDetailService.Actor) v.getTag();
                        if (actor1 != null) {
                            Intent intent = new Intent(mContext, MovieSearchActivity.class);
                            ArrayList<MovieFilter> options = new ArrayList<MovieFilter>();
                            options.add(new MovieFilter("query_term", actor1.getImdbCode(), actor1.getName()));
                            intent.putExtra(MovieSearchActivity.OPTIONS, options);
                            ((Activity) mContext).startActivityForResult(intent, BaseActivity.MOVIE_SEARCH_REQUEST);
                        }
                    }
                });
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
