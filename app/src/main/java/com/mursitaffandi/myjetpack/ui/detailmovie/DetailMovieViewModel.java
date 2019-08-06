package com.mursitaffandi.myjetpack.ui.detailmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;

public class DetailMovieViewModel extends ViewModel {
    private MovieEntity mTvshow;
    private ShowRepository movieRepository;
    private int movieId;

    public DetailMovieViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    LiveData<MovieEntity> getMovie() {
        return movieRepository.getMovie(movieId);
    }
}
