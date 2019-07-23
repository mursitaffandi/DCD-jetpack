package com.mursitaffandi.myjetpack.ui.showlist;

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
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.ui.detail.DetailShowActivity;
import com.mursitaffandi.myjetpack.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class ShowlistAdapter extends RecyclerView.Adapter<ShowlistAdapter.AcademyViewHolder> {
    private final Activity activity;
    private List<ShowsVideo> mCourses = new ArrayList<>();

    ShowlistAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<ShowsVideo> getListCourses() {
        return mCourses;
    }

    void setListCourses(List<ShowsVideo> listCourses) {
        if (listCourses == null) return;
        this.mCourses.clear();
        this.mCourses.addAll(listCourses);
    }

    @NonNull
    @Override
    public AcademyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_shows, parent, false);
        return new AcademyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AcademyViewHolder holder, int position) {
        holder.tvTitle.setText(getListCourses().get(position).getmTitle());
        holder.tvDate.setText(getListCourses().get(position).getmReleaseDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailShowActivity.class);
            intent.putExtra(DetailShowActivity.EXTRA_SHOW, getListCourses().get(position).getmId());
            activity.startActivity(intent);
        });
        GlideApp.with(holder.itemView.getContext())
                .load(getListCourses().get(position).getmLogo())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return getListCourses().size();
    }

    class AcademyViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDate;
        final ImageView imgPoster;

        AcademyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_show);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }
    }
}

