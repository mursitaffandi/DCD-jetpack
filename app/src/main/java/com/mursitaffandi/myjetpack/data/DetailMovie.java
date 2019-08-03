package com.mursitaffandi.myjetpack.data;

import java.util.List;

public class DetailMovie {

    private Boolean adult;
    private Integer budget;
    private Integer id;
    private Integer voteCount;
    private Integer revenue;
    private Integer runtime;
    private String backdropPath;
    private String homepage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String releaseDate;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double popularity;
    private Double voteAverage;
    private Object belongsToCollection;
    private List<Genre> genres = null;
    private List<ProductionCompany> productionCompanies = null;
    private List<ProductionCountry> productionCountries = null;
    private List<SpokenLanguage> spokenLanguages = null;

    /**
     * No args constructor for use in serialization
     */
    public DetailMovie() {
    }

    /**
     * @param budget
     * @param genres
     * @param spokenLanguages
     * @param runtime
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param title
     * @param releaseDate
     * @param posterPath
     * @param originalTitle
     * @param voteAverage
     * @param video
     * @param popularity
     * @param revenue
     * @param productionCountries
     * @param status
     * @param originalLanguage
     * @param adult
     * @param imdbId
     * @param homepage
     * @param overview
     * @param belongsToCollection
     * @param productionCompanies
     * @param tagline
     */
    public DetailMovie(Boolean adult, String backdropPath, Object belongsToCollection, Integer budget, List<Genre> genres, String homepage, Integer id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, String releaseDate, Integer revenue, Integer runtime, List<SpokenLanguage> spokenLanguages, String status, String tagline, String title, Boolean video, Double voteAverage, Integer voteCount) {
        super();
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


    public class Genre {

        private Integer id;
        private String name;

        /**
         * No args constructor for use in serialization
         */
        public Genre() {
        }

        /**
         * @param id
         * @param name
         */
        public Genre(Integer id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public class ProductionCompany {

        private Integer id;
        private String logoPath;
        private String name;
        private String originCountry;

        /**
         * No args constructor for use in serialization
         */
        public ProductionCompany() {
        }

        /**
         * @param id
         * @param originCountry
         * @param name
         * @param logoPath
         */
        public ProductionCompany(Integer id, String logoPath, String name, String originCountry) {
            super();
            this.id = id;
            this.logoPath = logoPath;
            this.name = name;
            this.originCountry = originCountry;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }


    public class ProductionCountry {

        private String iso31661;
        private String name;

        /**
         * No args constructor for use in serialization
         */
        public ProductionCountry() {
        }

        /**
         * @param iso31661
         * @param name
         */
        public ProductionCountry(String iso31661, String name) {
            super();
            this.iso31661 = iso31661;
            this.name = name;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public class SpokenLanguage {

        private String iso6391;
        private String name;

        /**
         * No args constructor for use in serialization
         */
        public SpokenLanguage() {
        }

        /**
         * @param iso6391
         * @param name
         */
        public SpokenLanguage(String iso6391, String name) {
            super();
            this.iso6391 = iso6391;
            this.name = name;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}