package com.mursitaffandi.myjetpack.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.*;
import com.mursitaffandi.myjetpack.data.source.local.entity.*;

import java.util.List;

@Dao
public interface ShowsDao {
    
    @WorkerThread
    @Query("SELECT * FROM tb_movies")
    LiveData<List<MovieEntity>> getMovies();
    
    @Query("SELECT * FROM tb_movies where bookmarked = 1")
    DataSource.Factory<Integer, MovieEntity> getBookmarkedMovieAsPaged();
    
    @Transaction
    @Query("SELECT * FROM tb_movies WHERE id = :id")
    LiveData<MovieEntity> getMovieById(int id);
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<MovieEntity> movies);
    
    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateMovie(MovieEntity movie);
    
    @WorkerThread
    @Query("SELECT * FROM tb_tvshows")
    LiveData<List<TvshowEntity>> getTvshows();
    
    @Query("SELECT * FROM tb_tvshows where bookmarked = 1")
    DataSource.Factory<Integer, TvshowEntity> getBookmarkedTvshowAsPaged();
    
    @Transaction
    @Query("SELECT * FROM tb_tvshows WHERE id = :id")
    LiveData<TvshowEntity> getTvshowById(int id);
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTvshows(List<TvshowEntity> tvshows);
    
    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateTvshow(TvshowEntity tvshow);
    
}
