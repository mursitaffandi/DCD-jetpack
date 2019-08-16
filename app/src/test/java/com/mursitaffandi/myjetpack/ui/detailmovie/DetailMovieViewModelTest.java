package com.mursitaffandi.myjetpack.ui.detailmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DetailMovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailMovieViewModel viewModel;
    private final ShowRepository showRepository = mock(ShowRepository.class);
    private final MovieEntity dummyMovie = FakeDataDummy.generateDummyMovieEntity().get(0);
    private final int dummyMovieId = dummyMovie.getId();

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(showRepository);
        viewModel.setMovieId(dummyMovieId);
    }
    
    @Test
    public void getMovie() {
        MutableLiveData<MovieEntity> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyMovie);

        when(showRepository.getMovie(dummyMovieId)).thenReturn(courseEntities);

        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.getMovie().observeForever(observer);

        verify(showRepository).getMovie(dummyMovieId);
    }
}