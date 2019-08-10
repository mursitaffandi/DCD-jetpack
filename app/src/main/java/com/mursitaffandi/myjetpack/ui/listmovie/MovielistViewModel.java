package com.mursitaffandi.myjetpack.ui.listmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;

import java.util.List;

public class MovielistViewModel extends ViewModel {
    private ShowRepository movieRepository;

    public MovielistViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    LiveData<List<MovieEntity>> getMovies() {
        return movieRepository.getAllMovies();
    }
}

