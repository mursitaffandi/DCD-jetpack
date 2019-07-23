package com.mursitaffandi.myjetpack.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ShowsVideo implements Parcelable {
    protected String mTitle, mReleaseDate, mOverview;
    protected int mId, mPoster, mLogo;

    public ShowsVideo(int mId, String mTitle, String mReleaseDate, String mOverview, int mPoster, int mLogo) {
        this.mTitle = mTitle;
        this.mReleaseDate = mReleaseDate;
        this.mOverview = mOverview;
        this.mId = mId;
        this.mPoster = mPoster;
        this.mLogo = mLogo;
    }

    protected ShowsVideo(Parcel in) {
        mTitle = in.readString();
        mReleaseDate = in.readString();
        mOverview = in.readString();
        mId = in.readInt();
        mPoster = in.readInt();
        mLogo = in.readInt();
    }

    public static final Creator<ShowsVideo> CREATOR = new Creator<ShowsVideo>() {
        @Override
        public ShowsVideo createFromParcel(Parcel in) {
            return new ShowsVideo(in);
        }

        @Override
        public ShowsVideo[] newArray(int size) {
            return new ShowsVideo[size];
        }
    };

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmPoster() {
        return mPoster;
    }

    public void setmPoster(int mPoster) {
        this.mPoster = mPoster;
    }

    public int getmLogo() {
        return mLogo;
    }

    public void setmLogo(int mLogo) {
        this.mLogo = mLogo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mReleaseDate);
        dest.writeString(mOverview);
        dest.writeInt(mId);
        dest.writeInt(mPoster);
        dest.writeInt(mLogo);
    }
}
