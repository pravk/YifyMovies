package android.pk.com.yifymovies.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by hello on 8/1/2015.
 */
public interface MovieListService {

    @GET("/list_movies.json")
    public void getMovieList(@QueryMap Map<String, String> options, Callback<MovieListResponse> responseCallback);

    public static class Data {

        @SerializedName("movie_count")
        @Expose
        private Integer movieCount;
        @Expose
        private Integer limit;
        @SerializedName("page_number")
        @Expose
        private Integer pageNumber;
        @Expose
        private List<Movie> movies = new ArrayList<Movie>();

        /**
         *
         * @return
         * The movieCount
         */
        public Integer getMovieCount() {
            return movieCount;
        }

        /**
         *
         * @param movieCount
         * The movie_count
         */
        public void setMovieCount(Integer movieCount) {
            this.movieCount = movieCount;
        }

        /**
         *
         * @return
         * The limit
         */
        public Integer getLimit() {
            return limit;
        }

        /**
         *
         * @param limit
         * The limit
         */
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        /**
         *
         * @return
         * The pageNumber
         */
        public Integer getPageNumber() {
            return pageNumber;
        }

        /**
         *
         * @param pageNumber
         * The page_number
         */
        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        /**
         *
         * @return
         * The movies
         */
        public List<Movie> getMovies() {
            return movies;
        }

        /**
         *
         * @param movies
         * The movies
         */
        public void setMovies(List<Movie> movies) {
            this.movies = movies;
        }

    }

    public class Meta {

        @SerializedName("server_time")
        @Expose
        private Integer serverTime;
        @SerializedName("server_timezone")
        @Expose
        private String serverTimezone;
        @SerializedName("api_version")
        @Expose
        private Integer apiVersion;
        @SerializedName("execution_time")
        @Expose
        private String executionTime;

        /**
         *
         * @return
         * The serverTime
         */
        public Integer getServerTime() {
            return serverTime;
        }

        /**
         *
         * @param serverTime
         * The server_time
         */
        public void setServerTime(Integer serverTime) {
            this.serverTime = serverTime;
        }

        /**
         *
         * @return
         * The serverTimezone
         */
        public String getServerTimezone() {
            return serverTimezone;
        }

        /**
         *
         * @param serverTimezone
         * The server_timezone
         */
        public void setServerTimezone(String serverTimezone) {
            this.serverTimezone = serverTimezone;
        }

        /**
         *
         * @return
         * The apiVersion
         */
        public Integer getApiVersion() {
            return apiVersion;
        }

        /**
         *
         * @param apiVersion
         * The api_version
         */
        public void setApiVersion(Integer apiVersion) {
            this.apiVersion = apiVersion;
        }

        /**
         *
         * @return
         * The executionTime
         */
        public String getExecutionTime() {
            return executionTime;
        }

        /**
         *
         * @param executionTime
         * The execution_time
         */
        public void setExecutionTime(String executionTime) {
            this.executionTime = executionTime;
        }

    }

    public class Movie {

        @Expose
        private Integer id;
        @Expose
        private String url;
        @SerializedName("imdb_code")
        @Expose
        private String imdbCode;
        @Expose
        private String title;
        @SerializedName("title_long")
        @Expose
        private String titleLong;
        @Expose
        private String slug;
        @Expose
        private Integer year;
        @Expose
        private Double rating;
        @Expose
        private Integer runtime;
        @Expose
        private List<String> genres = new ArrayList<String>();
        @Expose
        private String language;
        @SerializedName("mpa_rating")
        @Expose
        private String mpaRating;
        @SerializedName("background_image")
        @Expose
        private String backgroundImage;
        @SerializedName("small_cover_image")
        @Expose
        private String smallCoverImage;
        @SerializedName("medium_cover_image")
        @Expose
        private String mediumCoverImage;
        @Expose
        private String state;
        @Expose
        private List<Torrent> torrents = new ArrayList<Torrent>();
        @SerializedName("date_uploaded")
        @Expose
        private String dateUploaded;
        @SerializedName("date_uploaded_unix")
        @Expose
        private Integer dateUploadedUnix;

        /**
         *
         * @return
         * The id
         */
        public Integer getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The imdbCode
         */
        public String getImdbCode() {
            return imdbCode;
        }

        /**
         *
         * @param imdbCode
         * The imdb_code
         */
        public void setImdbCode(String imdbCode) {
            this.imdbCode = imdbCode;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The titleLong
         */
        public String getTitleLong() {
            return titleLong;
        }

        /**
         *
         * @param titleLong
         * The title_long
         */
        public void setTitleLong(String titleLong) {
            this.titleLong = titleLong;
        }

        /**
         *
         * @return
         * The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         *
         * @param slug
         * The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         *
         * @return
         * The year
         */
        public Integer getYear() {
            return year;
        }

        /**
         *
         * @param year
         * The year
         */
        public void setYear(Integer year) {
            this.year = year;
        }

        /**
         *
         * @return
         * The rating
         */
        public Double getRating() {
            return rating;
        }

        /**
         *
         * @param rating
         * The rating
         */
        public void setRating(Double rating) {
            this.rating = rating;
        }

        /**
         *
         * @return
         * The runtime
         */
        public Integer getRuntime() {
            return runtime;
        }

        /**
         *
         * @param runtime
         * The runtime
         */
        public void setRuntime(Integer runtime) {
            this.runtime = runtime;
        }

        /**
         *
         * @return
         * The genres
         */
        public List<String> getGenres() {
            return genres;
        }

        /**
         *
         * @param genres
         * The genres
         */
        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        /**
         *
         * @return
         * The language
         */
        public String getLanguage() {
            return language;
        }

        /**
         *
         * @param language
         * The language
         */
        public void setLanguage(String language) {
            this.language = language;
        }

        /**
         *
         * @return
         * The mpaRating
         */
        public String getMpaRating() {
            return mpaRating;
        }

        /**
         *
         * @param mpaRating
         * The mpa_rating
         */
        public void setMpaRating(String mpaRating) {
            this.mpaRating = mpaRating;
        }

        /**
         *
         * @return
         * The backgroundImage
         */
        public String getBackgroundImage() {
            return backgroundImage;
        }

        /**
         *
         * @param backgroundImage
         * The background_image
         */
        public void setBackgroundImage(String backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        /**
         *
         * @return
         * The smallCoverImage
         */
        public String getSmallCoverImage() {
            return smallCoverImage;
        }

        /**
         *
         * @param smallCoverImage
         * The small_cover_image
         */
        public void setSmallCoverImage(String smallCoverImage) {
            this.smallCoverImage = smallCoverImage;
        }

        /**
         *
         * @return
         * The mediumCoverImage
         */
        public String getMediumCoverImage() {
            return mediumCoverImage;
        }

        /**
         *
         * @param mediumCoverImage
         * The medium_cover_image
         */
        public void setMediumCoverImage(String mediumCoverImage) {
            this.mediumCoverImage = mediumCoverImage;
        }

        /**
         *
         * @return
         * The state
         */
        public String getState() {
            return state;
        }

        /**
         *
         * @param state
         * The state
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         *
         * @return
         * The torrents
         */
        public List<Torrent> getTorrents() {
            return torrents;
        }

        /**
         *
         * @param torrents
         * The torrents
         */
        public void setTorrents(List<Torrent> torrents) {
            this.torrents = torrents;
        }

        /**
         *
         * @return
         * The dateUploaded
         */
        public String getDateUploaded() {
            return dateUploaded;
        }

        /**
         *
         * @param dateUploaded
         * The date_uploaded
         */
        public void setDateUploaded(String dateUploaded) {
            this.dateUploaded = dateUploaded;
        }

        /**
         *
         * @return
         * The dateUploadedUnix
         */
        public Integer getDateUploadedUnix() {
            return dateUploadedUnix;
        }

        /**
         *
         * @param dateUploadedUnix
         * The date_uploaded_unix
         */
        public void setDateUploadedUnix(Integer dateUploadedUnix) {
            this.dateUploadedUnix = dateUploadedUnix;
        }

    }


    public class MovieListResponse {

        @Expose
        private String status;
        @SerializedName("status_message")
        @Expose
        private String statusMessage;
        @Expose
        private Data data;
        @SerializedName("@meta")
        @Expose
        private Meta Meta;

        /**
         *
         * @return
         * The status
         */
        public String getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The statusMessage
         */
        public String getStatusMessage() {
            return statusMessage;
        }

        /**
         *
         * @param statusMessage
         * The status_message
         */
        public void setStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
        }

        /**
         *
         * @return
         * The data
         */
        public Data getData() {
            return data;
        }

        /**
         *
         * @param data
         * The data
         */
        public void setData(Data data) {
            this.data = data;
        }

        /**
         *
         * @return
         * The Meta
         */
        public Meta getMeta() {
            return Meta;
        }

        /**
         *
         * @param Meta
         * The @meta
         */
        public void setMeta(Meta Meta) {
            this.Meta = Meta;
        }

    }

    public class Torrent {

        @Expose
        private String url;
        @Expose
        private String hash;
        @Expose
        private String quality;
        @Expose
        private Integer seeds;
        @Expose
        private Integer peers;
        @Expose
        private String size;
        @SerializedName("size_bytes")
        @Expose
        private Long sizeBytes;
        @SerializedName("date_uploaded")
        @Expose
        private String dateUploaded;
        @SerializedName("date_uploaded_unix")
        @Expose
        private Integer dateUploadedUnix;

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The hash
         */
        public String getHash() {
            return hash;
        }

        /**
         *
         * @param hash
         * The hash
         */
        public void setHash(String hash) {
            this.hash = hash;
        }

        /**
         *
         * @return
         * The quality
         */
        public String getQuality() {
            return quality;
        }

        /**
         *
         * @param quality
         * The quality
         */
        public void setQuality(String quality) {
            this.quality = quality;
        }

        /**
         *
         * @return
         * The seeds
         */
        public Integer getSeeds() {
            return seeds;
        }

        /**
         *
         * @param seeds
         * The seeds
         */
        public void setSeeds(Integer seeds) {
            this.seeds = seeds;
        }

        /**
         *
         * @return
         * The peers
         */
        public Integer getPeers() {
            return peers;
        }

        /**
         *
         * @param peers
         * The peers
         */
        public void setPeers(Integer peers) {
            this.peers = peers;
        }

        /**
         *
         * @return
         * The size
         */
        public String getSize() {
            return size;
        }

        /**
         *
         * @param size
         * The size
         */
        public void setSize(String size) {
            this.size = size;
        }

        /**
         *
         * @return
         * The sizeBytes
         */
        public Long getSizeBytes() {
            return sizeBytes;
        }

        /**
         *
         * @param sizeBytes
         * The size_bytes
         */
        public void setSizeBytes(Long sizeBytes) {
            this.sizeBytes = sizeBytes;
        }

        /**
         *
         * @return
         * The dateUploaded
         */
        public String getDateUploaded() {
            return dateUploaded;
        }

        /**
         *
         * @param dateUploaded
         * The date_uploaded
         */
        public void setDateUploaded(String dateUploaded) {
            this.dateUploaded = dateUploaded;
        }

        /**
         *
         * @return
         * The dateUploadedUnix
         */
        public Integer getDateUploadedUnix() {
            return dateUploadedUnix;
        }

        /**
         *
         * @param dateUploadedUnix
         * The date_uploaded_unix
         */
        public void setDateUploadedUnix(Integer dateUploadedUnix) {
            this.dateUploadedUnix = dateUploadedUnix;
        }

    }

}
