package com.mursitaffandi.myjetpack.ui.tvshow;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.TvShowEntity;
import com.mursitaffandi.myjetpack.ui.detail.DetailShowActivity;
import com.mursitaffandi.myjetpack.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TvShowlistAdapter extends RecyclerView.Adapter<TvShowlistAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<TvShowEntity> mTvShow = new ArrayList<>();

    TvShowlistAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowEntity> getListTvShow() {
        return mTvShow;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tvshows, parent, false);
        return new MovieViewHolder(view);
    }

    void setListShows(List<TvShowEntity> shows) {
        if (shows == null) return;
        this.mTvShow.clear();
        this.mTvShow.addAll(shows);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.tvItemTitle.setText(getListTvShow().get(position).getmTitle());
        holder.tvItemTvshowDate.setText(getListTvShow().get(position).getmReleaseDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailShowActivity.class);
            intent.putExtra(DetailShowActivity.EXTRA_SHOW_ID, getListTvShow().get(position).getmId());
            intent.putExtra(DetailShowActivity.EXTRA_SHOW_TYPE, "tv_show");

            activity.startActivity(intent);
        });
        GlideApp.with(holder.itemView.getContext())
                .load(getListTvShow().get(position).getmLogo())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imgTvshow);
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgTvshow;
        private TextView tvItemTitle;
        private TextView tvItemTvshowDate;

        MovieViewHolder(View itemView) {
            super(itemView);

            imgTvshow = itemView.findViewById(R.id.img_tvshow);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            tvItemTvshowDate = itemView.findViewById(R.id.tv_item_tvshow_date);
        }
    }
}

