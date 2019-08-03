package com.mursitaffandi.myjetpack.data;


import java.util.List;

public class DetailTvShow {

    private Boolean inProduction;
    private Integer voteCount;
    private Integer id;
    private String backdropPath;
    private String firstAirDate;
    private String homepage;
    private String lastAirDate;
    private String name;
    private Integer numberOfEpisodes;
    private Integer numberOfSeasons;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private String posterPath;
    private String status;
    private String type;
    private NextEpisodeToAir nextEpisodeToAir;
    private Double popularity;
    private Double voteAverage;
    private LastEpisodeToAir lastEpisodeToAir;
    private List<CreatedBy> createdBy = null;
    private List<Integer> episodeRunTime = null;
    private List<Genre> genres = null;
    private List<String> languages = null;
    private List<Network> networks = null;
    private List<String> originCountry = null;
    private List<ProductionCompany> productionCompanies = null;
    private List<Season> seasons = null;

    /**
     * No args constructor for use in serialization
     */
    public DetailTvShow() {
    }

    /**
     * @param genres
     * @param originalName
     * @param type
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param nextEpisodeToAir
     * @param numberOfEpisodes
     * @param languages
     * @param originCountry
     * @param inProduction
     * @param name
     * @param posterPath
     * @param voteAverage
     * @param popularity
     * @param networks
     * @param status
     * @param lastAirDate
     * @param lastEpisodeToAir
     * @param numberOfSeasons
     * @param originalLanguage
     * @param homepage
     * @param createdBy
     * @param overview
     * @param seasons
     * @param firstAirDate
     * @param productionCompanies
     * @param episodeRunTime
     */
    public DetailTvShow(String backdropPath, List<CreatedBy> createdBy, List<Integer> episodeRunTime, String firstAirDate, List<Genre> genres, String homepage, Integer id, Boolean inProduction, List<String> languages, String lastAirDate, LastEpisodeToAir lastEpisodeToAir, String name, NextEpisodeToAir nextEpisodeToAir, List<Network> networks, Integer numberOfEpisodes, Integer numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<Season> seasons, String status, String type, Double voteAverage, Integer voteCount) {
        super();
        this.backdropPath = backdropPath;
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.firstAirDate = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.lastEpisodeToAir = lastEpisodeToAir;
        this.name = name;
        this.nextEpisodeToAir = nextEpisodeToAir;
        this.networks = networks;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<CreatedBy> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<CreatedBy> createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
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

    public Boolean getInProduction() {
        return inProduction;
    }

    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public LastEpisodeToAir getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(LastEpisodeToAir lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NextEpisodeToAir getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(NextEpisodeToAir nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    public class CreatedBy {

        private Integer id;
        private String creditId;
        private String name;
        private Integer gender;
        private String profilePath;

        /**
         * No args constructor for use in serialization
         */
        public CreatedBy() {
        }

        /**
         * @param id
         * @param profilePath
         * @param name
         * @param gender
         * @param creditId
         */
        public CreatedBy(Integer id, String creditId, String name, Integer gender, String profilePath) {
            super();
            this.id = id;
            this.creditId = creditId;
            this.name = name;
            this.gender = gender;
            this.profilePath = profilePath;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

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


    public class LastEpisodeToAir {

        private String airDate;
        private Integer episodeNumber;
        private Integer id;
        private String name;
        private String overview;
        private String productionCode;
        private Integer seasonNumber;
        private Integer showId;
        private String stillPath;
        private Integer voteAverage;
        private Integer voteCount;

        /**
         * No args constructor for use in serialization
         */
        public LastEpisodeToAir() {
        }

        /**
         * @param stillPath
         * @param id
         * @param airDate
         * @param overview
         * @param productionCode
         * @param name
         * @param showId
         * @param voteAverage
         * @param seasonNumber
         * @param episodeNumber
         * @param voteCount
         */
        public LastEpisodeToAir(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber, Integer showId, String stillPath, Integer voteAverage, Integer voteCount) {
            super();
            this.airDate = airDate;
            this.episodeNumber = episodeNumber;
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.productionCode = productionCode;
            this.seasonNumber = seasonNumber;
            this.showId = showId;
            this.stillPath = stillPath;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public Integer getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(Integer episodeNumber) {
            this.episodeNumber = episodeNumber;
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

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getProductionCode() {
            return productionCode;
        }

        public void setProductionCode(String productionCode) {
            this.productionCode = productionCode;
        }

        public Integer getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(Integer seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public Integer getShowId() {
            return showId;
        }

        public void setShowId(Integer showId) {
            this.showId = showId;
        }

        public String getStillPath() {
            return stillPath;
        }

        public void setStillPath(String stillPath) {
            this.stillPath = stillPath;
        }

        public Integer getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Integer voteAverage) {
            this.voteAverage = voteAverage;
        }

        public Integer getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

    }


    public class Network {

        private String name;
        private Integer id;
        private String logoPath;
        private String originCountry;

        /**
         * No args constructor for use in serialization
         */
        public Network() {
        }

        /**
         * @param id
         * @param originCountry
         * @param name
         * @param logoPath
         */
        public Network(String name, Integer id, String logoPath, String originCountry) {
            super();
            this.name = name;
            this.id = id;
            this.logoPath = logoPath;
            this.originCountry = originCountry;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }


    public class NextEpisodeToAir {

        private String airDate;
        private Integer episodeNumber;
        private Integer id;
        private String name;
        private String overview;
        private String productionCode;
        private Integer seasonNumber;
        private Integer showId;
        private Object stillPath;
        private Integer voteAverage;
        private Integer voteCount;

        /**
         * No args constructor for use in serialization
         */
        public NextEpisodeToAir() {
        }

        /**
         * @param stillPath
         * @param id
         * @param airDate
         * @param overview
         * @param productionCode
         * @param name
         * @param showId
         * @param voteAverage
         * @param seasonNumber
         * @param episodeNumber
         * @param voteCount
         */
        public NextEpisodeToAir(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber, Integer showId, Object stillPath, Integer voteAverage, Integer voteCount) {
            super();
            this.airDate = airDate;
            this.episodeNumber = episodeNumber;
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.productionCode = productionCode;
            this.seasonNumber = seasonNumber;
            this.showId = showId;
            this.stillPath = stillPath;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public Integer getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(Integer episodeNumber) {
            this.episodeNumber = episodeNumber;
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

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getProductionCode() {
            return productionCode;
        }

        public void setProductionCode(String productionCode) {
            this.productionCode = productionCode;
        }

        public Integer getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(Integer seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public Integer getShowId() {
            return showId;
        }

        public void setShowId(Integer showId) {
            this.showId = showId;
        }

        public Object getStillPath() {
            return stillPath;
        }

        public void setStillPath(Object stillPath) {
            this.stillPath = stillPath;
        }

        public Integer getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Integer voteAverage) {
            this.voteAverage = voteAverage;
        }

        public Integer getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

    }


    public class ProductionCompany {

        private Integer id;
        private Object logoPath;
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
        public ProductionCompany(Integer id, Object logoPath, String name, String originCountry) {
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

        public Object getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(Object logoPath) {
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

    public class Season {

        private String airDate;
        private Integer episodeCount;
        private Integer id;
        private String name;
        private String overview;
        private Object posterPath;
        private Integer seasonNumber;

        /**
         * No args constructor for use in serialization
         */
        public Season() {
        }

        /**
         * @param id
         * @param airDate
         * @param overview
         * @param posterPath
         * @param name
         * @param episodeCount
         * @param seasonNumber
         */
        public Season(String airDate, Integer episodeCount, Integer id, String name, String overview, Object posterPath, Integer seasonNumber) {
            super();
            this.airDate = airDate;
            this.episodeCount = episodeCount;
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.posterPath = posterPath;
            this.seasonNumber = seasonNumber;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public Integer getEpisodeCount() {
            return episodeCount;
        }

        public void setEpisodeCount(Integer episodeCount) {
            this.episodeCount = episodeCount;
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

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Object getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(Object posterPath) {
            this.posterPath = posterPath;
        }

        public Integer getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(Integer seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

    }
}