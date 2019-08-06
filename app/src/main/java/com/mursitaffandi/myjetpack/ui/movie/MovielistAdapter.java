package com.mursitaffandi.myjetpack.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.ui.detailmovie.DetailMovieActivity;
import com.mursitaffandi.myjetpack.utils.Cons;
import com.mursitaffandi.myjetpack.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class MovielistAdapter extends RecyclerView.Adapter<MovielistAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<MovieEntity> mMovie = new ArrayList<>();

    MovielistAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieEntity> getListMovie() {
        return mMovie;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_shows, parent, false);
        return new MovieViewHolder(view);
    }

    void setListShows(List<MovieEntity> shows) {
        if (shows == null) return;
        this.mMovie.clear();
        this.mMovie.addAll(shows);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovie().get(position).getTitle());
        holder.tvDate.setText(getListMovie().get(position).getReleaseDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_SHOW_ID, getListMovie().get(position).getId());
            activity.startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(Cons.BASE_URL_IMAGE + getListMovie().get(position).getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDate;
        final ImageView imgPoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_show);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }
    }
}

