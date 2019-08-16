package com.mursitaffandi.myjetpack.ui.favorite.favoritestvshow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.ui.detailtvshow.DetailTvShowActivity;
import com.mursitaffandi.myjetpack.utils.Cons;

public class FavoritesTvshowPagedAdapter extends PagedListAdapter<TvshowEntity, FavoritesTvshowPagedAdapter.BookmarkViewHolder> {
    
    private static final DiffUtil.ItemCallback<TvshowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvshowEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvshowEntity oldItem, @NonNull TvshowEntity newItem) {
                    return oldItem.getId()==newItem.getId();
                }
                
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvshowEntity oldItem, @NonNull TvshowEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };
    private final Activity activity;
    
    FavoritesTvshowPagedAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }
    
    @Override
    public void onBindViewHolder(@NonNull final BookmarkViewHolder holder, int position) {
        final TvshowEntity bookmark = getItem(position);
        if (bookmark != null) {
            holder.tvTitle.setText(bookmark.getOriginalName());
            holder.tvDate.setText(bookmark.getFirstAirDate());
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_SHOW_ID, bookmark.getId());
                activity.startActivity(intent);
            });
            
            Glide.with(holder.itemView.getContext())
                    .load(Cons.BASE_URL_IMAGE + bookmark.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(holder.imgPoster);
        }
    }
    
    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_show, parent, false);
        return new BookmarkViewHolder(view);
    }
    
    TvshowEntity getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }
    
    class BookmarkViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDate;
        final ImageView imgPoster;
    
        BookmarkViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.item_iv_show);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }
    }
}