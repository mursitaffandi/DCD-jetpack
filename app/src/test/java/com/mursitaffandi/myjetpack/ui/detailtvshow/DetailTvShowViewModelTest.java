package com.mursitaffandi.myjetpack.ui.detailtvshow;

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

import static org.mockito.Mockito.*;

public class DetailTvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailTvShowViewModel viewModel;
    private final ShowRepository showRepository = mock(ShowRepository.class);
    private final TvshowEntity dummyTvshow = FakeDataDummy.generateDummyTvShowEntity().get(0);
    private final int dummyTvshowId = dummyTvshow.getId();

    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(showRepository);
        viewModel.setTvshowId(dummyTvshowId);
    }
    
    @Test
    public void getTvShow() {
        MutableLiveData<TvshowEntity> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyTvshow);

        when(showRepository.getTvShow(dummyTvshowId)).thenReturn(courseEntities);

        Observer<TvshowEntity> observer = mock(Observer.class);
        viewModel.getTvShow().observeForever(observer);

        verify(showRepository).getTvShow(dummyTvshowId);
    }
}