package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

public class FavoritesMovieViewModel extends ViewModel {
    private ShowRepository showRepository;
    
    public FavoritesMovieViewModel(ShowRepository mAcademyRepository) {
        this.showRepository = mAcademyRepository;
    }
    
    LiveData<Resource<PagedList<MovieEntity>>> getBookmarksPaged() {
        return showRepository.getAllBookmarkedMovies();
    }
    
    void setBookmark(MovieEntity movieEntity) {
        // Kode di bawah menggunakan tanda seru (!),
        // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
        final boolean newState = !movieEntity.isBookmarked();
        showRepository.setMovieBookmark(movieEntity, newState);
    }
}
