package com.mursitaffandi.myjetpack.ui.tvshow;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.data.TvShowEntity;
import com.mursitaffandi.myjetpack.utils.DataDummy;

import java.util.List;

public class TvShowlistViewModel extends ViewModel {

    public List<TvShowEntity> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }
}

