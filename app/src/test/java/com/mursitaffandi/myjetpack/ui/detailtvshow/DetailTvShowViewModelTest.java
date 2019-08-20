package com.mursitaffandi.myjetpack.ui.detailtvshow;

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

import static org.mockito.Mockito.*;

public class DetailTvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private DetailTvShowViewModel viewModel;
    private ShowRepository showRepository = mock(ShowRepository.class);
    private TvshowEntity dummyCourse = FakeDataDummy.generateDummyTvShowEntity().get(0);
    private int movieId = dummyCourse.getId();
    
    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(showRepository);
        viewModel.setTvshowId(movieId);
        viewModel.setBookmark();
    }
    
    @Test
    public void getTvShowDetail() {
        MutableLiveData<Resource<TvshowEntity>> tvshow = new MutableLiveData<>();
        tvshow.setValue(Resource.success(FakeDataDummy.getTvshow(movieId)));
        
        when(showRepository.getTvShow(movieId)).thenReturn(tvshow);
        
        Observer<Resource<TvshowEntity>> observer = mock(Observer.class);
        viewModel.tvshowItem.observeForever(observer);
        
        verify(showRepository).getTvShow(movieId);
    
        verify(observer).onChanged(tvshow.getValue());
    
        Assert.assertEquals(tvshow.getValue() , viewModel.tvshowItem.getValue());
    }
}