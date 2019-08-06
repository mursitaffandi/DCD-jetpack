package com.mursitaffandi.myjetpack.ui.detailtvshow;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.ui.tvshow.TvShowlistAdapter;
import com.mursitaffandi.myjetpack.ui.tvshow.TvShowlistViewModel;
import com.mursitaffandi.myjetpack.utils.Cons;
import com.mursitaffandi.myjetpack.utils.GlideApp;
import com.mursitaffandi.myjetpack.viewmodel.ViewModelFactory;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW_ID = "extra_show";
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;
    private ProgressBar progressBar;
    private DetailTvShowViewModel viewModel;

    @NonNull
    private static DetailTvShowViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailTvShowViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        viewModel = obtainViewModel(this);

        imagePoster =  findViewById(R.id.image_poster);
        textTitle =  findViewById(R.id.text_title);
        textDate =  findViewById(R.id.text_date);
        textDescription =  findViewById(R.id.text_description);
        progressBar = findViewById(R.id.progress_bar_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int tvshowId = extras.getInt(EXTRA_SHOW_ID,0);
            progressBar.setVisibility(View.VISIBLE);
            viewModel.setTvshowId(tvshowId);
        }

        viewModel.getTvShow().observe(this, tvshowEntity -> {
            progressBar.setVisibility(View.GONE);
            setupComponent(tvshowEntity);
        });

    }

    private void setupComponent(TvshowEntity tvshowEntity){
        Glide.with(getApplicationContext())
                .load(Cons.BASE_URL_IMAGE + tvshowEntity.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(tvshowEntity.getOriginalName());
        textDate.setText(tvshowEntity.getFirstAirDate());
        textDescription.setText(tvshowEntity.getOverview());
    }
}
