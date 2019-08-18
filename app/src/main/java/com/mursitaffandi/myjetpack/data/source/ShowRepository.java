package com.mursitaffandi.myjetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.mursitaffandi.myjetpack.data.source.local.LocalRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.ApiResponse;
import com.mursitaffandi.myjetpack.data.source.remote.RemoteRepository;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;
import com.mursitaffandi.myjetpack.utils.AppExecutors;
import com.mursitaffandi.myjetpack.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class ShowRepository implements ShowDataSource {

    private volatile static ShowRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;
    
    
    private ShowRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static ShowRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (ShowRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ShowRepository(localRepository, remoteData, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getAllMovies() {
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            @Override
            public LiveData<List<MovieEntity>> loadFromDB() {
                return localRepository.getAllMovies();
            }
        
            @Override
            public Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }
        
            @Override
            public LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.getAllMovieAsLiveData();
            }
        
            @Override
            public void saveCallResult(List<MovieResponse> courseResponses) {
                List<MovieEntity> courseEntities = new ArrayList<>();
            
                for (MovieResponse response : courseResponses) {
                
                    courseEntities.add(
                            new MovieEntity(
                                    response.getOverview(),
                                    response.getOriginalLanguage(),
                                    response.getOriginalTitle(),
                                    response.isVideo(),
                                    response.getTitle(),
                                    response.getPosterPath(),
                                    response.getBackdropPath(),
                                    response.getReleaseDate(),
                                    response.getVoteAverage(),
                                    response.getPopularity(),
                                    response.getId(),
                                    response.isAdult(),
                                    response.getVoteCount(),
                                    false
                            )
                    );
                }
            
                localRepository.insertMovies(courseEntities);
            }
        }.asLiveData();
    }
    
    @Override
    public LiveData<Resource<List<TvshowEntity>>> getAllTvShows() {
        return new NetworkBoundResource<List<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
            @Override
            public LiveData<List<TvshowEntity>> loadFromDB() {
                return localRepository.getAllTvshows();
            }
        
            @Override
            public Boolean shouldFetch(List<TvshowEntity> data) {
                return (data == null) || (data.size() == 0);
            }
        
            @Override
            public LiveData<ApiResponse<List<TvshowResponse>>> createCall() {
                return remoteRepository.getAllTvshowAsLiveData();
            }
        
            @Override
            public void saveCallResult(List<TvshowResponse> courseResponses) {
                List<TvshowEntity> courseEntities = new ArrayList<>();
            
                for (TvshowResponse response : courseResponses) {
                
                    courseEntities.add(
                            new TvshowEntity(
                                    response.getFirstAirDate(),
                                    response.getBackdropPath(),
                                    response.getOverview(),
                                    response.getOriginalLanguage(),
                                    response.getOriginalName(),
                                    response.getPopularity(),
                                    response.getVoteAverage(),
                                    response.getName(),
                                    response.getId(),
                                    response.getVoteCount(),
                                    response.getPosterPath(),
                                    false
                            )
                    );
                }
            
                localRepository.insertTvshows(courseEntities);
            }
        }.asLiveData();
    }
    
    
    
    
    
    
    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getAllBookmarkedMoviesPaged() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getBookmarkedMoviesPaged(), /* page size */ 20).build();
            }
    
            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
            }
    
            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }
    
            @Override
            protected void saveCallResult(List<MovieResponse> data) {
        
            }
        }.asLiveData();
    }
    
    @Override
    public LiveData<Resource<PagedList<TvshowEntity>>> getAllBookmarkedTvShowsPaged() {
        return new NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<TvshowEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getBookmarkedTvshowsPaged(), /* page size */ 20).build();
            }
    
            @Override
            protected Boolean shouldFetch(PagedList<TvshowEntity> data) {
                return false;
            }
    
            @Override
            protected LiveData<ApiResponse<List<TvshowResponse>>> createCall() {
                return null;
            }
    
            @Override
            protected void saveCallResult(List<TvshowResponse> data) {
        
            }
        }.asLiveData();
    }
    
    
    
    
    
    
    @Override
    public LiveData<Resource<MovieEntity>> getMovie(int movieId) {
        return new NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors){
            @Override
            protected LiveData<MovieEntity> loadFromDB() {
                return localRepository.getMovieById(movieId);
            }
    
            @Override
            protected Boolean shouldFetch(MovieEntity data) {
                return (data==null);
            }
    
            @Override
            protected LiveData<ApiResponse<MovieResponse>> createCall() {
                return remoteRepository.getMovieByIdAsLiveData(movieId);
            }
    
            @Override
            protected void saveCallResult(MovieResponse data) {
                List<MovieEntity> movieEntities = new ArrayList<>();
                
                movieEntities.add(new MovieEntity(
                        data.getOverview(),
                        data.getOriginalLanguage(),
                        data.getOriginalTitle(),
                        data.isVideo(),
                        data.getTitle(),
                        data.getPosterPath(),
                        data.getBackdropPath(),
                        data.getReleaseDate(),
                        data.getVoteAverage(),
                        data.getPopularity(),
                        data.getId(),
                        data.isAdult(),
                        data.getVoteCount(),
                        false
                ));
    
                localRepository.insertMovies(movieEntities);
            }
        }.asLiveData();
    }
    
    @Override
    public LiveData<Resource<TvshowEntity>> getTvShow(int tvshowId) {
        return new NetworkBoundResource<TvshowEntity, TvshowResponse>(appExecutors){
            @Override
            protected LiveData<TvshowEntity> loadFromDB() {
                return localRepository.getTvshowById(tvshowId);
            }
        
            @Override
            protected Boolean shouldFetch(TvshowEntity data) {
                return (data==null);
            }
        
            @Override
            protected LiveData<ApiResponse<TvshowResponse>> createCall() {
                return remoteRepository.getTvshowByIdAsLiveData(tvshowId);
            }
        
            @Override
            protected void saveCallResult(TvshowResponse data) {
                List<TvshowEntity> movieEntities = new ArrayList<>();
            
                movieEntities.add(new TvshowEntity(
                        data.getFirstAirDate(),
                        data.getBackdropPath(),
                        data.getOverview(),
                        data.getOriginalLanguage(),
                        data.getOriginalName(),
                        data.getPopularity(),
                        data.getVoteAverage(),
                        data.getName(),
                        data.getId(),
                        data.getVoteCount(),
                        data.getPosterPath(),
                        false
                ));
            
                localRepository.insertTvshows(movieEntities);
            }
        }.asLiveData();
    }
    
    
    
    
    
    
    @Override
    public void setMovieBookmark(MovieEntity movieEntity, boolean state) {
        Runnable runnable = () -> localRepository.setMovieBookmark(movieEntity, state);
    
        appExecutors.diskIO().execute(runnable);
    }
    
    @Override
    public void setTvshowBookmark(TvshowEntity tvshowEntity, boolean state) {
        Runnable runnable = () -> localRepository.setTvshowBookmark(tvshowEntity, state);
    
        appExecutors.diskIO().execute(runnable);
    }
    
}

