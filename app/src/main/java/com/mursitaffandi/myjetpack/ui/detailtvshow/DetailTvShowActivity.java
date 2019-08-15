package com.mursitaffandi.myjetpack.ui.detailtvshow;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.utils.Cons;
import com.mursitaffandi.myjetpack.viewmodel.ViewModelFactory;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_SHOW_ID = "extra_show";
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;
    private ProgressBar progressBar;
    private DetailTvShowViewModel viewModel;
    private Menu menu;
    
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
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
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
            if (movieId != 0) {
                viewModel.setTvshowId(movieId);
            }
        }
    
        viewModel.tvshowItem.observe(this, movieItem -> {
            if (movieItem != null) {
            
                switch (movieItem.status) {
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (movieItem.data != null) {
                            progressBar.setVisibility(View.GONE);
                            setupComponent(movieItem.data);
                        }
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        viewModel.tvshowItem.observe(this, courseWithModule -> {
            if (courseWithModule != null) {
                switch (courseWithModule.status) {
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (courseWithModule.data != null) {
                            progressBar.setVisibility(View.GONE);
                            boolean state = courseWithModule.data.isBookmarked();
                            setBookmarkState(state);
                        }
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            viewModel.setBookmark();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void setBookmarkState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp));
        }
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
