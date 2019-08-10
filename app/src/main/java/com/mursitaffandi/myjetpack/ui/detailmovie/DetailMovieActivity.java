package com.mursitaffandi.myjetpack.ui.detailmovie;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.utils.Cons;
import com.mursitaffandi.myjetpack.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW_ID = "extra_show";
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;
    private ProgressBar progressBar;
    private DetailMovieViewModel viewModel;

    @NonNull
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
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
            int movieId = extras.getInt(EXTRA_SHOW_ID, 0);
            progressBar.setVisibility(View.VISIBLE);
            viewModel.setMovieId(movieId);
        }
        viewModel.getMovie().observe(this,movieEntity -> {
            progressBar.setVisibility(View.GONE);
            setupComponent(movieEntity);
        });
    }

    private void setupComponent(MovieEntity movie){
        Glide.with(getApplicationContext())
                .load(Cons.BASE_URL_IMAGE + movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(movie.getOriginalTitle());
        textDate.setText(movie.getReleaseDate());
        textDescription.setText(movie.getOverview());
    }
}
