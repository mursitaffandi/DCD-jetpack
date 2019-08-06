package com.mursitaffandi.myjetpack.ui.detailtvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;

public class DetailTvShowViewModel extends ViewModel {
    private TvshowEntity mTvshow;
    private int tvshowId;
    private ShowRepository movieRepository;

    public DetailTvShowViewModel(ShowRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    LiveData<TvshowEntity> getTvShow() {
        return movieRepository.getTvShow(tvshowId);
    }

    public void setTvshowId(int tvshowId) {
        this.tvshowId = tvshowId;
    }
}
