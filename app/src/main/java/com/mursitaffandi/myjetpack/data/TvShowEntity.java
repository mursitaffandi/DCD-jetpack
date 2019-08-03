package com.mursitaffandi.myjetpack.data;

import java.util.List;

public class TvShowEntity {


    private String originalName;
    private String name;
    private Integer voteCount;
    private String firstAirDate;
    private String backdropPath;
    private String originalLanguage;
    private Integer id;
    private String overview;
    private String posterPath;

    /**
     * No args constructor for use in model
     *
     */
    public TvShowEntity() {
    }

    public String getOriginalName() {
        return originalName;
    }

    /**
     *
     * @param originalName
     * @param originalLanguage
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param overview
     * @param posterPath
     * @param name
     * @param firstAirDate
     */
    public TvShowEntity(String originalName, String name, Integer voteCount, String firstAirDate, String backdropPath, String originalLanguage, Integer id, String overview, String posterPath) {
        super();
        this.originalName = originalName;
        this.name = name;
        this.voteCount = voteCount;
        this.firstAirDate = firstAirDate;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.id = id;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

}