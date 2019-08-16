package com.mursitaffandi.myjetpack.ui.favorite.favoritestvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

public class FavoritesTvshowViewModel extends ViewModel {
    private final ShowRepository showRepository;
    
    public FavoritesTvshowViewModel(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
    
    LiveData<Resource<PagedList<TvshowEntity>>> getBookmarksPaged() {
        return showRepository.getAllBookmarkedTvShows();
    }
    
    void setBookmark(TvshowEntity movieEntity) {
        // Kode di bawah menggunakan tanda seru (!),
        // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
        final boolean newState = !movieEntity.isBookmarked();
        showRepository.setTvshowBookmark(movieEntity, newState);
    }
}
