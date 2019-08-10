package com.mursitaffandi.myjetpack.ui.listtvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class TvShowlistViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private ShowRepository showRepository = mock(ShowRepository.class);
    private TvShowlistViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvShowlistViewModel(showRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getTvshows() {
        MutableLiveData<List<TvshowEntity>> courses = new MutableLiveData<>();
        courses.setValue(FakeDataDummy.generateDummyTvShowEntity());

        when(showRepository.getAllTvShows()).thenReturn(courses);

        Observer<List<TvshowEntity>> observer = mock(Observer.class);

        viewModel.getTvShows().observeForever(observer);

        verify(showRepository).getAllTvShows();
    }
}