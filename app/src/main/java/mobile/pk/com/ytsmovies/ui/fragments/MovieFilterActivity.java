package mobile.pk.com.ytsmovies.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mobile.pk.com.ytsmovies.R;
import mobile.pk.com.ytsmovies.ui.activity.BaseActivity;

/**
 * Created by hello on 8/2/2015.
 */
public class MovieFilterActivity extends BaseActivity {

    public static final String FILTER_MAP = "FILTER_MAP";

    HashMap<String,String> filter;

    @InjectView(R.id.btn_720p)
    RadioButton btn720p;


    @InjectView(R.id.btn_1080p)
    RadioButton btn1080p;


    @InjectView(R.id.btn_3d)
    RadioButton btn3d;

    @InjectView(R.id.btn_all)
    RadioButton btnAll;

    @InjectView(R.id.rating)
    SeekBar rating;

    @InjectView(R.id.quality)
    RadioGroup quality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_filter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filter = (HashMap<String, String>) getIntent().getSerializableExtra(FILTER_MAP);
        if(filter == null)
            filter = new HashMap<>();

        ButterKnife.inject(this);
        initControls();
    }

    protected void initControls() {

        String quality = filter.get("quality");
        if(quality == null)
        {
            btnAll.setChecked(true);
        }
        else if(quality.equals("720p"))
        {
            btn720p.setChecked(true);
        }
        else if(quality.equals("1080p"))
        {
            btn1080p.setChecked(true);
        }else if(quality.equals("3D"))
        {
            btn3d.setChecked(true);
        }

        String minimumRating = filter.get("minimum_rating");
        if(minimumRating == null)
        {
            rating.setProgress(0);
        }
        else
        {
            rating.setProgress(Integer.valueOf(minimumRating)+1);
        }

    }

    @OnClick(R.id.btn_cancel)
    public void onCancel()
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    @OnClick(R.id.btn_apply)
    public void onApply()
    {
        int checkedButtonId = quality.getCheckedRadioButtonId();
        switch(checkedButtonId)
        {
            case R.id.btn_720p:
                filter.put("quality", "720p");
                break;
            case R.id.btn_1080p:
                filter.put("quality", "1080p");
                break;
            case R.id.btn_3d:
                filter.put("quality", "3D");
                break;
            case R.id.btn_all:
                filter.remove("quality");
                break;
        }

        filter.put("minimum_rating", String.valueOf(rating.getProgress()-1));

        Intent data = new Intent();
        data.putExtra(FILTER_MAP, filter);
        setResult(RESULT_OK, data);
        finish();
    }

}
