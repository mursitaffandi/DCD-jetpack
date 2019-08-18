package com.mursitaffandi.myjetpack.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.mursitaffandi.myjetpack.data.source.local.LocalRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.RemoteRepository;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.utils.InstantAppExecutors;
import com.mursitaffandi.myjetpack.utils.LiveDataTestUtil;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class ShowRepositoryTest {
    
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private final LocalRepository local = Mockito.mock(LocalRepository.class);
    private final RemoteRepository remote = Mockito.mock(RemoteRepository.class);
    private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
    private final FakeShowRepository showRepository = new FakeShowRepository(local, remote, instantAppExecutors);
    
    private final ArrayList<MovieResponse> movieResponses = FakeDataDummy.generateDummyMovieResponse();
    private final ArrayList<TvshowResponse> tvshowResponses = FakeDataDummy.generateDummyTvShowResponse();
    private int movieId = movieResponses.get(0).getId();
    private int tvshowId = tvshowResponses.get(0).getId();
    
    @Test
    public void getAllMovies() {
        MutableLiveData<List<MovieEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(FakeDataDummy.generateDummyMovieEntity());
        
        when(local.getAllMovies()).thenReturn(dummyMovies);
        
        Resource<List<MovieEntity>> result = LiveDataTestUtil.getValue(showRepository.getAllMovies());
        
        verify(local).getAllMovies();
        assertNotNull(result.data);
    }
    
    @Test
    public void getAllTvshow() {
        MutableLiveData<List<TvshowEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(FakeDataDummy.generateDummyTvShowEntity());
        
        when(local.getAllTvshows()).thenReturn(dummyMovies);
        
        Resource<List<TvshowEntity>> result = LiveDataTestUtil.getValue(showRepository.getAllTvShows());
        
        verify(local).getAllTvshows();
        assertNotNull(result.data);
    }
    
    @Test
    public void getBookmarkedMovie() {
        
        DataSource.Factory<Integer, MovieEntity> dataSourceFactory = mock(DataSource.Factory.class);
        
        when(local.getBookmarkedMoviesPaged()).thenReturn(dataSourceFactory);
        
        showRepository.getAllBookmarkedMoviesPaged();
        
        verify(local).getBookmarkedMoviesPaged();
    }
    
    @Test
    public void getBookmarkedTvshow() {
        
        DataSource.Factory<Integer, TvshowEntity> dataSourceFactory = mock(DataSource.Factory.class);
        
        when(local.getBookmarkedTvshowsPaged()).thenReturn(dataSourceFactory);
        
        showRepository.getAllBookmarkedTvShowsPaged();
        
        verify(local).getBookmarkedTvshowsPaged();
    }
    
}
