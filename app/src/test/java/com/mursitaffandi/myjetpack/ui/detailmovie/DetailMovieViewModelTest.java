package com.mursitaffandi.myjetpack.ui.detailmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DetailMovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private DetailMovieViewModel viewModel;
    private ShowRepository showRepository = mock(ShowRepository.class);
    private MovieEntity dummyCourse = FakeDataDummy.generateDummyMovieEntity().get(0);
    private int movieId = dummyCourse.getId();
    
    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(showRepository);
        viewModel.setMovieId(movieId);
        viewModel.setBookmark();
    }
    
    @Test
    public void getMovieDetail() {
        MutableLiveData<Resource<MovieEntity>> movie = new MutableLiveData<>();
        movie.setValue(Resource.success(FakeDataDummy.getMovie(movieId)));
        
        when(showRepository.getMovie(movieId)).thenReturn(movie);
        
        Observer<Resource<MovieEntity>> observer = mock(Observer.class);
        viewModel.movieItem.observeForever(observer);
        
        verify(showRepository).getMovie(movieId);
    }
}