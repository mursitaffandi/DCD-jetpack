package com.mursitaffandi.myjetpack.ui.listmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.vo.Resource;

import java.util.List;

public class MovielistViewModel extends ViewModel {
    private ShowRepository movieRepository;
    
    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    LiveData<Resource<List<MovieEntity>>> movies = Transformations.switchMap(mLogin,
            data -> movieRepository.getAllMovies());
    
    public MovielistViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    void setUsername(String username) {
        mLogin.setValue(username);
    }
}

