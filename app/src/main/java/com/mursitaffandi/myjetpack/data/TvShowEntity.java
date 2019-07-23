package com.mursitaffandi.myjetpack.data;

import android.os.Parcel;

public class TvShowEntity extends ShowsVideo {


    public TvShowEntity(int mId, String mTitle, String mOverview, String mReleaseDate, int mPoster, int mLogo) {
        super(mId,mTitle, mOverview, mReleaseDate, mPoster, mLogo);
    }

    protected TvShowEntity(Parcel in) {
        super(in);
    }
}