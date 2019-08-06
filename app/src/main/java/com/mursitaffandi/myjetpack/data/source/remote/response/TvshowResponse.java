package com.mursitaffandi.myjetpack.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvshowResponse implements Parcelable {
	private String originalName;
	private String name;
	private double popularity;
	private int voteCount;
	private String firstAirDate;
	private String backdropPath;
	private String originalLanguage;
	private int id;
	private double voteAverage;
	private String overview;
	private String posterPath;

	public TvshowResponse(String originalName, String name, double popularity, int voteCount, String firstAirDate, String backdropPath, String originalLanguage, int id, double voteAverage, String overview, String posterPath) {
		this.originalName = originalName;
		this.name = name;
		this.popularity = popularity;
		this.voteCount = voteCount;
		this.firstAirDate = firstAirDate;
		this.backdropPath = backdropPath;
		this.originalLanguage = originalLanguage;
		this.id = id;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.posterPath = posterPath;
	}

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	@Override
 	public String toString(){
		return 
			"TvshowResponse{" +
			"first_air_date = '" + firstAirDate + '\'' + 
			",backdrop_path = '" + backdropPath + '\'' + 
			",overview = '" + overview + '\'' + 
			",original_language = '" + originalLanguage + '\'' + 
			",original_name = '" + originalName + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			",poster_path = '" + posterPath + '\'' + 
			"}";
		}

	public TvshowResponse() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.originalName);
		dest.writeString(this.name);
		dest.writeDouble(this.popularity);
		dest.writeInt(this.voteCount);
		dest.writeString(this.firstAirDate);
		dest.writeString(this.backdropPath);
		dest.writeString(this.originalLanguage);
		dest.writeInt(this.id);
		dest.writeDouble(this.voteAverage);
		dest.writeString(this.overview);
		dest.writeString(this.posterPath);
	}

	protected TvshowResponse(Parcel in) {
		this.originalName = in.readString();
		this.name = in.readString();
		this.popularity = in.readDouble();
		this.voteCount = in.readInt();
		this.firstAirDate = in.readString();
		this.backdropPath = in.readString();
		this.originalLanguage = in.readString();
		this.id = in.readInt();
		this.voteAverage = in.readDouble();
		this.overview = in.readString();
		this.posterPath = in.readString();
	}

	public static final Creator<TvshowResponse> CREATOR = new Creator<TvshowResponse>() {
		@Override
		public TvshowResponse createFromParcel(Parcel source) {
			return new TvshowResponse(source);
		}

		@Override
		public TvshowResponse[] newArray(int size) {
			return new TvshowResponse[size];
		}
	};
}
