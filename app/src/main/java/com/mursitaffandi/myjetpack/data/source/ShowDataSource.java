package com.mursitaffandi.myjetpack.data.source;


import androidx.lifecycle.LiveData;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;

import java.util.List;

public interface ShowDataSource {

    LiveData<List<MovieEntity>> getAllMovies();

    LiveData<List<TvshowEntity>> getAllTvShows();

    LiveData<MovieEntity> getMovie(int movieId);

    LiveData<TvshowEntity> getTvShow(int tvshowId);
}