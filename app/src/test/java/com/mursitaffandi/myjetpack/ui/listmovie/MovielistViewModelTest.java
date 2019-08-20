package com.mursitaffandi.myjetpack.ui.listmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MovielistViewModelTest {
    
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private MovielistViewModel viewModel;
    private ShowRepository academyRepository = mock(ShowRepository.class);
    
    @Before
    public void setUp() {
        viewModel = new MovielistViewModel(academyRepository);
    }
    
    @Test
    public void getMovies() {
        MutableLiveData<Resource<List<MovieEntity>>> dummyMoviesPaged = new MutableLiveData<>();
        dummyMoviesPaged.setValue(Resource.success(FakeDataDummy.generateDummyMovieEntity()));
        
        when(academyRepository.getAllMovies()).thenReturn(dummyMoviesPaged);
        
        Observer<Resource<List<MovieEntity>>> observer = Mockito.mock(Observer.class);
        
        viewModel.setUsername();
        
        viewModel.movies.observeForever(observer);
        
        verify(academyRepository).getAllMovies();
        
        verify(observer).onChanged(dummyMoviesPaged.getValue());
    
        Assert.assertEquals(dummyMoviesPaged.getValue() , viewModel.movies.getValue());
    
    
    }
}