package com.mursitaffandi.myjetpack.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowEntity extends ShowsVideo {


    public TvShowEntity(int mId, String mTitle, String mReleaseDate, String mOverview, int mPoster, int mLogo) {
        super(mId, mTitle, mReleaseDate, mOverview, mPoster, mLogo);
    }

    protected TvShowEntity(Parcel in) {
        super(in);
    }
}