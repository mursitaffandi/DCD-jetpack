package com.mursitaffandi.myjetpack.data.source;


import androidx.lifecycle.LiveData;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

import java.util.List;

public interface ShowDataSource {

    LiveData<Resource<List<MovieEntity>>> getAllMovies();

    LiveData<Resource<List<TvshowEntity>>> getAllTvShows();
    
    LiveData<Resource<List<MovieEntity>>> getAllBookmarkedMovies();

    LiveData<Resource<List<TvshowEntity>>> getAllBookmarkedTvShows();

    LiveData<Resource<MovieEntity>> getMovie(int movieId);

    LiveData<Resource<TvshowEntity>> getTvShow(int tvshowId);
    
    void setMovieBookmark(MovieEntity movieEntity, boolean state);
    
    void setTvshowBookmark(TvshowEntity tvshowEntity, boolean state);
}