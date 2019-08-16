package com.mursitaffandi.myjetpack.ui.listmovie;

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

import java.util.List;

import static org.mockito.Mockito.*;

public class MovielistViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final ShowRepository showRepository = mock(ShowRepository.class);
    private MovielistViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovielistViewModel(showRepository);
    }
    
    @Test
    public void getMovies() {
        MutableLiveData<List<MovieEntity>> courses = new MutableLiveData<>();
        courses.setValue(FakeDataDummy.generateDummyMovieEntity());

        when(showRepository.getAllMovies()).thenReturn(courses);

        Observer<List<MovieEntity>> observer = mock(Observer.class);

        viewModel.getMovies().observeForever(observer);

        verify(showRepository).getAllMovies();
    }
}