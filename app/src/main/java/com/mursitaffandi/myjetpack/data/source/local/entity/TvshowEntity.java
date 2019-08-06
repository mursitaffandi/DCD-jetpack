package com.mursitaffandi.myjetpack.data.source.local.entity;

public class TvshowEntity{
	private String firstAirDate;
	private String backdropPath;
	private String overview;
	private String originalLanguage;
	private String originalName;
	private double popularity;
	private double voteAverage;
	private String name;
	private int id;
	private int voteCount;
	private String posterPath;

	public TvshowEntity() {
	}

	public TvshowEntity(
			String firstAirDate,
			String backdropPath,
			String overview,
			String originalLanguage,
			String originalName,
			double popularity,
			double voteAverage,
			String name,
			int id,
			int voteCount,
			String posterPath
	) {
		this.firstAirDate = firstAirDate;
		this.backdropPath = backdropPath;
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.originalName = originalName;
		this.popularity = popularity;
		this.voteAverage = voteAverage;
		this.name = name;
		this.id = id;
		this.voteCount = voteCount;
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
}
