package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

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
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.ui.detailmovie.DetailMovieActivity;
import com.mursitaffandi.myjetpack.utils.Cons;

public class FavoritesMoviePagedAdapter extends PagedListAdapter<MovieEntity, FavoritesMoviePagedAdapter.BookmarkViewHolder> {
    
    private static final DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getId()==newItem.getId();
                }
                
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };
    private final Activity activity;
    
    FavoritesMoviePagedAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }
    
    @Override
    public void onBindViewHolder(@NonNull final BookmarkViewHolder holder, int position) {
        final MovieEntity bookmark = getItem(position);
        if (bookmark != null) {
            holder.tvTitle.setText(bookmark.getTitle());
            holder.tvDate.setText(bookmark.getReleaseDate());
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_SHOW_ID, bookmark.getId());
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
    
    MovieEntity getItemById(int swipedPosition) {
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