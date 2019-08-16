package com.mursitaffandi.myjetpack.ui.listtvshow;

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
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.ui.detailtvshow.DetailTvShowActivity;
import com.mursitaffandi.myjetpack.utils.Cons;

import java.util.ArrayList;
import java.util.List;

public class TvShowlistAdapter extends RecyclerView.Adapter<TvShowlistAdapter.MovieViewHolder> {
    private final Activity activity;
    private final List<TvshowEntity> mTvShow = new ArrayList<>();

    TvShowlistAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvshowEntity> getListTvShow() {
        return mTvShow;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_show, parent, false);
        return new MovieViewHolder(view);
    }

    void setListShows(List<TvshowEntity> shows) {
        if (shows == null) return;
        this.mTvShow.clear();
        this.mTvShow.addAll(shows);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.tvItemTitle.setText(getListTvShow().get(position).getOriginalName());
        holder.tvItemTvshowDate.setText(getListTvShow().get(position).getFirstAirDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_SHOW_ID, getListTvShow().get(position).getId());

            activity.startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(Cons.BASE_URL_IMAGE + getListTvShow().get(position).getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imgTvshow);
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgTvshow;
        private final TextView tvItemTitle;
        private final TextView tvItemTvshowDate;

        MovieViewHolder(View itemView) {
            super(itemView);

            imgTvshow = itemView.findViewById(R.id.item_iv_show);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            tvItemTvshowDate = itemView.findViewById(R.id.tv_item_date);
        }
    }
}

