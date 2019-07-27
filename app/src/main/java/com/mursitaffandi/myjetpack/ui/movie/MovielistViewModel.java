package com.mursitaffandi.myjetpack.ui.movie;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.DataDummy;

import java.util.List;

public class MovielistViewModel extends ViewModel {

    public List<MovieEntity> getMovies() {
        return DataDummy.generateDummyMovie();
    }
}

