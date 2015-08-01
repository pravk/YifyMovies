package mobile.pk.com.yifymovies.adapter;

import android.view.View;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;

import mobile.pk.com.yifymovies.R;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieScreenshotViewHolder extends MovieDetailViewHolder {

    SliderLayout sliderShow;

    public MovieScreenshotViewHolder(View itemView) {
        super(itemView);
        sliderShow = (SliderLayout) itemView.findViewById(R.id.slider);
        sliderShow.setCustomIndicator((PagerIndicator) itemView.findViewById(R.id.custom_indicator));
    }

    protected void onStop() {
        sliderShow.stopAutoCycle();
    }
}
