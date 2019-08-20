package com.mursitaffandi.myjetpack.ui.favorite.favoritestvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FavoritesTvshowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private ShowRepository showRepository = mock(ShowRepository.class);
    private FavoritesTvshowViewModel viewModel;
    
    @Before
    public void setUp() {
        viewModel = new FavoritesTvshowViewModel(showRepository);
    }
    
    @Test
    public void getBookmark() {
        
        MutableLiveData<Resource<PagedList<TvshowEntity>>> favoritetvshowsPaged = new MutableLiveData<>();
        PagedList<TvshowEntity> pagedList = mock(PagedList.class);
        favoritetvshowsPaged.setValue(Resource.success(pagedList));
        
        when(showRepository.getAllBookmarkedTvShowsPaged()).thenReturn(favoritetvshowsPaged);
        
        Observer<Resource<PagedList<TvshowEntity>>> observer = mock(Observer.class);
        
        viewModel.getBookmarksPaged().observeForever(observer);
        
        verify(showRepository).getAllBookmarkedTvShowsPaged();
    
        verify(observer).onChanged(favoritetvshowsPaged.getValue());
    
        Assert.assertEquals(favoritetvshowsPaged.getValue() , viewModel.getBookmarksPaged().getValue());
    
    
    }
}