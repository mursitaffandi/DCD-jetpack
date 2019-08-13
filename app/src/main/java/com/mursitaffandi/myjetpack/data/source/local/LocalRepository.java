package com.mursitaffandi.myjetpack.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.local.room.ShowsDao;

import java.util.List;

public class LocalRepository {
    private static LocalRepository INSTANCE;
    private final ShowsDao mShowsDao;
    
    private LocalRepository(ShowsDao mShowsDao) {
        this.mShowsDao = mShowsDao;
    }
    
    public static LocalRepository getInstance(ShowsDao academyDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(academyDao);
        }
        return INSTANCE;
    }
    
    public LiveData<List<MovieEntity>> getAllMovies() {
        return mShowsDao.getMovies();
    }
    
    public DataSource.Factory<Integer, MovieEntity> getBookmarkedMoviesPaged() {
        return mShowsDao.getBookmarkedMovieAsPaged();
    }
    
    public LiveData<MovieEntity> getMovieById(final int id) {
        return mShowsDao.getMovieById(id);
    }
    
    public void insertMovies(List<MovieEntity> movies) {
        mShowsDao.insertMovies(movies);
    }
    
    public void setMovieBookmark(MovieEntity movieEntity, boolean newState) {
        movieEntity.setBookmarked(newState);
        mShowsDao.updateMovie(movieEntity);
    }
    
    public LiveData<List<TvshowEntity>> getAllTvshows() {
        return mShowsDao.getTvshows();
    }
    
    public DataSource.Factory<Integer, TvshowEntity> getBookmarkedTvshowsPaged() {
        return mShowsDao.getBookmarkedTvshowAsPaged();
    }
    
    public LiveData<TvshowEntity> getTvshowById(final int id) {
        return mShowsDao.getTvshowById(id);
    }
    
    public void insertTvshows(List<TvshowEntity> movies) {
        mShowsDao.insertTvshows(movies);
    }
    
    public void setTvshowBookmark(TvshowEntity movieEntity, boolean newState) {
        movieEntity.setBookmarked(newState);
        mShowsDao.updateTvshow(movieEntity);
    }

}