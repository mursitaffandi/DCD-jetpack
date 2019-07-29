package com.mursitaffandi.myjetpack.ui.detail;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.ShowsVideo;

public class DetailMovieViewModel extends ViewModel {
    private ShowsVideo mCourse;
    private int movieId;
    private String movieType;

    public ShowsVideo getShow() {
        if (movieType.equals("movie"))
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
