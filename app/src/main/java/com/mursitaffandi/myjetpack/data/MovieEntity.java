package com.mursitaffandi.myjetpack.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity extends ShowsVideo {

    public MovieEntity(int mId, String mTitle, String mReleaseDate, String mOverview, int mPoster, int mLogo) {
        super(mId,mTitle, mReleaseDate, mOverview, mPoster, mLogo);
    }

    protected MovieEntity(Parcel in) {
        super(in);
    }
}
