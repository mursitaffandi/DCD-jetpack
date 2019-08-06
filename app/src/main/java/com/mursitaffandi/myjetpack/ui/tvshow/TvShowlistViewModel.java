package com.mursitaffandi.myjetpack.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.utils.DataDummy;

import java.util.List;

public class TvShowlistViewModel extends ViewModel {

    private ShowRepository movieRepository;

    public TvShowlistViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    LiveData<List<TvshowEntity>> getTvShows() {
        return movieRepository.getAllTvShows();
    }
}

