package com.mursitaffandi.myjetpack.ui.listtvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class TvShowlistViewModelTest {
    
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private TvShowlistViewModel viewModel;
    private ShowRepository academyRepository = mock(ShowRepository.class);
    
    @Before
    public void setUp() {
        viewModel = new TvShowlistViewModel(academyRepository);
    }
    
    @Test
    public void getTvshows() {
        MutableLiveData<Resource<List<TvshowEntity>>> dummyTvshowsPaged = new MutableLiveData<>();
        dummyTvshowsPaged.setValue(Resource.success(FakeDataDummy.generateDummyTvShowEntity()));
        
        when(academyRepository.getAllTvShows()).thenReturn(dummyTvshowsPaged);
        
        Observer<Resource<List<TvshowEntity>>> observer = Mockito.mock(Observer.class);
        
        viewModel.setUsername();
        
        viewModel.tvshows.observeForever(observer);
        
        verify(academyRepository).getAllTvShows();
        
        verify(observer).onChanged(dummyTvshowsPaged.getValue());
    
        Assert.assertEquals(dummyTvshowsPaged.getValue() , viewModel.tvshows.getValue());
    
    }
}