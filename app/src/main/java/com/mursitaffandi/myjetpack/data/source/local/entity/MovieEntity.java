package com.mursitaffandi.myjetpack.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_movies")
public class MovieEntity{
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	private int id;
	@ColumnInfo(name = "title")
	private String title;
	@ColumnInfo(name = "overview")
	private String overview;
	@ColumnInfo(name = "posterPath")
	private String posterPath;
	@ColumnInfo(name = "releaseDate")
	private String releaseDate;
	
	@ColumnInfo(name = "originalLanguage")
	private String originalLanguage;
	@ColumnInfo(name = "video")
	private boolean video;
	@ColumnInfo(name = "originalTitle")
	private String originalTitle;
	@ColumnInfo(name = "backdropPath")
	private String backdropPath;
	@ColumnInfo(name = "voteAverage")
	private double voteAverage;
	@ColumnInfo(name = "popularity")
	private double popularity;
	@ColumnInfo(name = "adult")
	private boolean adult;
	@ColumnInfo(name = "voteCount")
	private int voteCount;
	
	public boolean isBookmarked() {
		return bookmarked;
	}
	
	public void setBookmarked(Boolean bookmarked) {
		this.bookmarked = bookmarked;
	}
	
	@ColumnInfo(name = "bookmarked")
	private Boolean bookmarked = false;
	
	public MovieEntity(
			String overview,
			String originalLanguage,
			String originalTitle,
			boolean video,
			String title,
			String posterPath,
			String backdropPath,
			String releaseDate,
			double voteAverage,
			double popularity,
			@NonNull int id,
			boolean adult,
			int voteCount,
			Boolean bookmarked
	) {
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.video = video;
		this.title = title;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.releaseDate = releaseDate;
		this.voteAverage = voteAverage;
		this.popularity = popularity;
		this.id = id;
		this.adult = adult;
		this.voteCount = voteCount;
			this.bookmarked = bookmarked;
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

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}
	
	@NonNull
	public void setId(int id){
		this.id = id;
	}
	
	@NonNull
	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}
}
