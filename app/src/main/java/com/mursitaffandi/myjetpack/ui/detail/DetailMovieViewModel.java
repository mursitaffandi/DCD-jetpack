package com.mursitaffandi.myjetpack.ui.detail;

import androidx.lifecycle.ViewModel;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.DataDummy;

public class DetailMovieViewModel extends ViewModel {
    private ShowsVideo mCourse;
    private int movieId;

    public ShowsVideo getMovie() {
        for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {
            ShowsVideo courseEntity = DataDummy.generateDummyMovie().get(i);
            if (courseEntity.getmId()==movieId) {
                mCourse = courseEntity;
            }
        }
        return mCourse;
    }

    public String getOverview() {
        if (mCourse.equals(null)) return "";
        return mCourse.getmOverview();
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
