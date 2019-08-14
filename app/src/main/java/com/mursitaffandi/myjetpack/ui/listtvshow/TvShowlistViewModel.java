package com.mursitaffandi.myjetpack.ui.listtvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

import java.util.List;

public class TvShowlistViewModel extends ViewModel {
    private ShowRepository movieRepository;
    
    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    LiveData<Resource<List<TvshowEntity>>> tvshows = Transformations.switchMap(mLogin,
            data -> movieRepository.getAllTvShows());
    
    public TvShowlistViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    void setUsername(String username) {
        mLogin.setValue(username);
    }
}

