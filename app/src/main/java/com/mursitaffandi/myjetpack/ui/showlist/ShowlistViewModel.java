package com.mursitaffandi.myjetpack.ui.showlist;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.DataDummy;

import java.util.List;

public class ShowlistViewModel extends ViewModel {

    public List<ShowsVideo> getMovies() {
        return DataDummy.generateDummyMovie();
    }

    public List<ShowsVideo> getTvShows() {
        return DataDummy.generateDummyTvShow();
    }
}

