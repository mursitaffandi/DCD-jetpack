package com.mursitaffandi.myjetpack.data;

public class MovieEntity {
    int mId; String mTitle; String mReleaseDate; String mLogo;

    public MovieEntity(int mId, String mTitle, String mReleaseDate, String mLogo) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mReleaseDate = mReleaseDate;
        this.mLogo = mLogo;
    }

    public int getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getmLogo() {
        return mLogo;
    }
}
