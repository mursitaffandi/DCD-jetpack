package com.mursitaffandi.myjetpack.ui.detailmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

public class DetailMovieViewModel extends ViewModel {
    private ShowRepository movieRepository;

    public DetailMovieViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    private MutableLiveData<Integer> movieId = new MutableLiveData<>();
    public LiveData<Resource<MovieEntity>> movieItem =
            Transformations.switchMap(movieId,
                    mCourseId -> movieRepository.getMovie(movieId.getValue()));
    
    public Integer getMovieId() {
        if (movieId.getValue() == null) return null;
        return movieId.getValue();
    }
    
    public void setMovieId(Integer movieId) {
        this.movieId.setValue(movieId);
    }
    
    void setBookmark() {
        if (movieItem.getValue() != null) {
            MovieEntity movieItemForBookmark = movieItem.getValue().data;
            
            if (movieItemForBookmark != null) {
                
                // Kode di bawah menggunakan tanda seru (!),
                // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
                final boolean newState = !movieItemForBookmark.isBookmarked();
                movieRepository.setMovieBookmark(movieItemForBookmark, newState);
            }
        }
    }
}
