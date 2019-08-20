package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.vo.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FavoritesMovieViewModelTest {
    
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    
    private ShowRepository showRepository = mock(ShowRepository.class);
    private FavoritesMovieViewModel viewModel;
    
    @Before
    public void setUp() {
        viewModel = new FavoritesMovieViewModel(showRepository);
    }
    
    @Test
    public void getBookmark() {
        
        MutableLiveData<Resource<PagedList<MovieEntity>>> favoritemoviesPaged = new MutableLiveData<>();
        PagedList<MovieEntity> pagedList = mock(PagedList.class);
        favoritemoviesPaged.setValue(Resource.success(pagedList));
        
        when(showRepository.getAllBookmarkedMoviesPaged()).thenReturn(favoritemoviesPaged);
        
        Observer<Resource<PagedList<MovieEntity>>> observer = mock(Observer.class);
        
        viewModel.getBookmarksPaged().observeForever(observer);
        
        verify(showRepository).getAllBookmarkedMoviesPaged();
    
        verify(observer).onChanged(favoritemoviesPaged.getValue());
    
        Assert.assertEquals(favoritemoviesPaged.getValue() , viewModel.getBookmarksPaged().getValue());
        
    }
}