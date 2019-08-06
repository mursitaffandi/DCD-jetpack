package com.mursitaffandi.myjetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.mursitaffandi.myjetpack.data.source.local.LocalRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.RemoteRepository;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;

import java.util.ArrayList;
import java.util.List;

public class ShowRepository implements ShowDataSource {

    private volatile static ShowRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;

    private ShowRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static ShowRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (ShowRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ShowRepository(localRepository, remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieEntity>> getAllMovies() {
        MutableLiveData<List<MovieEntity>> movieResults = new MutableLiveData<>();

        remoteRepository.getAllMovie(new RemoteRepository.LoadMoviesCallback() {

            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> ret = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    MovieEntity movieEntity = new MovieEntity(
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
                            response.getVoteCount()
                    );

                    ret.add(movieEntity);
                }
                movieResults.postValue(ret);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return movieResults;
    }

    @Override
    public LiveData<List<TvshowEntity>> getAllTvShows() {
        MutableLiveData<List<TvshowEntity>> tvshowsResult = new MutableLiveData<>();
        remoteRepository.getAllTvshows(new RemoteRepository.LoadTvshowsCallback() {
            @Override
            public void onAllTvshowsReceived(List<TvshowResponse> tvshowResponses) {
                ArrayList<TvshowEntity> ret = new ArrayList<>();
                for (int i = 0; i < tvshowResponses.size(); i++) {
                    TvshowResponse response = tvshowResponses.get(i);
                    TvshowEntity tvshowEntity = new TvshowEntity(
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
                            response.getPosterPath()
                    );

                    ret.add(tvshowEntity);
                }
                tvshowsResult.postValue(ret);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvshowsResult;
    }

    @Override
    public LiveData<MovieEntity> getMovie(int movieId) {
        MutableLiveData<MovieEntity> moviesResult = new MutableLiveData<>();
        remoteRepository.getAllMovie(new RemoteRepository.LoadMoviesCallback() {

            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                MovieEntity movieEntity = new MovieEntity();
                for (MovieResponse e : movieResponses)
                    if (e.getId() == movieId)
                        movieEntity = new MovieEntity(
                                e.getOverview(),
                                e.getOriginalLanguage(),
                                e.getOriginalTitle(),
                                e.isVideo(),
                                e.getTitle(),
                                e.getPosterPath(),
                                e.getBackdropPath(),
                                e.getReleaseDate(),
                                e.getVoteAverage(),
                                e.getPopularity(),
                                e.getId(),
                                e.isAdult(),
                                e.getVoteCount()
                        );

                moviesResult.postValue(movieEntity);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return moviesResult;
    }

    @Override
    public LiveData<TvshowEntity> getTvShow(int tvshowId) {
        MutableLiveData<TvshowEntity> tvshowsResult = new MutableLiveData<>();
        remoteRepository.getAllTvshows(new RemoteRepository.LoadTvshowsCallback() {

            @Override
            public void onAllTvshowsReceived(List<TvshowResponse> tvshowResponses) {
                TvshowEntity tvshowEntity = new TvshowEntity();
                for (TvshowResponse e : tvshowResponses)
                    if (e.getId() == tvshowId)
                        tvshowEntity = new TvshowEntity(
                                e.getFirstAirDate(),
                                e.getBackdropPath(),
                                e.getOverview(),
                                e.getOriginalLanguage(),
                                e.getOriginalName(),
                                e.getPopularity(),
                                e.getVoteAverage(),
                                e.getName(),
                                e.getId(),
                                e.getVoteCount(),
                                e.getPosterPath()
                        );
                tvshowsResult.postValue(tvshowEntity);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvshowsResult;
    }

}

