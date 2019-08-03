package com.mursitaffandi.myjetpack.ui.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.DetailMovieG;
import com.mursitaffandi.myjetpack.utils.Cons;
import com.mursitaffandi.myjetpack.utils.GlideApp;

public class DetailShowActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW_ID = "extra_show";
    public static final String EXTRA_SHOW_TYPE = "type";
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;
    private ProgressBar progressBar;
    private DetailMovieViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);
        viewModel.getMovies().observe(this, getmovies);

        imagePoster = findViewById(R.id.image_poster);
        textTitle = findViewById(R.id.text_title);
        textDate = findViewById(R.id.text_date);
        textDescription = findViewById(R.id.text_description);
        progressBar = findViewById(R.id.progress_bar_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = Integer.toString(extras.getInt(EXTRA_SHOW_ID, 0));
            String movieType = extras.getString(EXTRA_SHOW_TYPE);

            viewModel.setMovies(movieId);
            showLoading(true);

        }
    }

    private void setupComponent(DetailMovieG movie) {
        GlideApp.with(getApplicationContext())
                .load(Cons.BASE_URL_IMAGE_LOGO + movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(movie.getOriginalTitle());
        textDate.setText(movie.getReleaseDate());
        textDescription.setText(movie.getOverview());
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private Observer<DetailMovieG> getmovies = detailMovieG -> {
        setupComponent(detailMovieG);
    };
}
