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

//    @WorkerThread
//    @Query("SELECT * FROM tb_movies where bookmarked = 1")
//    LiveData<List<MovieEntity>> getBookmarkedMovie();

    @Query("SELECT * FROM courseentities where bookmarked = 1")
    DataSource.Factory<Integer, CourseEntity> getBookmarkedCourseAsPaged();

    @Transaction
    @Query("SELECT * FROM courseentities WHERE courseId = :courseId")
    LiveData<CourseWithModule> getCourseWithModuleById(String courseId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertCourses(List<CourseEntity> courses);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateCourse(CourseEntity course);

    @Query("SELECT * FROM moduleentities WHERE courseId = :courseId")
    LiveData<List<ModuleEntity>> getModulesByCourseId(String courseId);

    @Query("SELECT * FROM moduleentities WHERE moduleId = :moduleId")
    LiveData<ModuleEntity> getModuleById(String moduleId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertModules(List<ModuleEntity> module);

    @Update
    int updateModule(ModuleEntity module);

    @Query("UPDATE moduleentities SET content = :content WHERE moduleId = :moduleId")
    int updateModuleByContent(String content, String moduleId);
}
