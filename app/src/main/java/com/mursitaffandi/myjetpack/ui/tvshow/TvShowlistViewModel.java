package com.mursitaffandi.myjetpack.ui.tvshow;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.TvShowEntity;

import java.util.List;

public class TvShowlistViewModel extends ViewModel {

    public List<TvShowEntity> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }
}

