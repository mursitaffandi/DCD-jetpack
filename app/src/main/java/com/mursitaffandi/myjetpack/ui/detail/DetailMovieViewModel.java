package com.mursitaffandi.myjetpack.ui.detail;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.ui.showlist.ShowListFragment;
import com.mursitaffandi.myjetpack.utils.DataDummy;

public class DetailMovieViewModel extends ViewModel {
    private ShowsVideo mCourse;
    private int movieId;
    private String movieType;

    public ShowsVideo getMovie() {
        if (movieType.equals(ShowListFragment.TYPE_MOVIE))
            for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {
                ShowsVideo showsEntity = DataDummy.generateDummyMovie().get(i);
                if (showsEntity.getmId() == movieId) {
                    mCourse = showsEntity;
                }
            }
        else
            for (int i = 0; i < DataDummy.generateDummyTvShow().size(); i++) {
                ShowsVideo showsEntity = DataDummy.generateDummyTvShow().get(i);
                if (showsEntity.getmId() == movieId) {
                    mCourse = showsEntity;
                }
            }
        return mCourse;
    }

    public void setMovieId(int movieId, String movieType) {
        this.movieId = movieId;
        this.movieType = movieType;
    }
}
