package com.mursitaffandi.myjetpack.ui.detail;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.GlideApp;

public class DetailShowActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW_ID = "extra_show";
    public static final String EXTRA_SHOW_TYPE = "type";
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;
    private DetailMovieViewModel viewModel;
    private ShowsVideo movie;


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

        imagePoster = (ImageView) findViewById(R.id.image_poster);
        textTitle = (TextView) findViewById(R.id.text_title);
        textDate = (TextView) findViewById(R.id.text_date);
        textDescription = (TextView) findViewById(R.id.text_description);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int movieId = extras.getInt(EXTRA_SHOW_ID, 0);
            String movieType = extras.getString(EXTRA_SHOW_TYPE);
            if (movieId != 0 && !movieType.equals(null)) {
                viewModel.setMovieId(movieId, movieType);
                movie = viewModel.getMovie();
                setupComponent(movie);
            }
        }
    }

    private void setupComponent(ShowsVideo movie){
        GlideApp.with(getApplicationContext())
                .load(movie.getmPoster())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(movie.getmTitle());
        textDate.setText(movie.getmReleaseDate());
        textDescription.setText(movie.getmOverview());
    }
}
