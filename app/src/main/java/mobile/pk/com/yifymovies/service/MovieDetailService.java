package mobile.pk.com.yifymovies.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by hello on 8/1/2015.
 */
public interface MovieDetailService {

    @GET("/movie_details.json?with_images=true&with_cast=true")
    public void getMovieDetails( @Query("movie_id") String movieId, Callback<MovieDetailResponse> responseCallback);

    public class Actor {

        @Expose
        private String name;
        @SerializedName("character_name")
        @Expose
        private String characterName;
        @SerializedName("small_image")
        @Expose
        private String smallImage;
        @SerializedName("medium_image")
        @Expose
        private String mediumImage;
        @SerializedName("imdb_code")
        @Expose
        private String imdbCode;

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The characterName
         */
        public String getCharacterName() {
            return characterName;
        }

        /**
         *
         * @param characterName
         * The character_name
         */
        public void setCharacterName(String characterName) {
            this.characterName = characterName;
        }

        /**
         *
         * @return
         * The smallImage
         */
        public String getSmallImage() {
            return smallImage;
        }

        /**
         *
         * @param smallImage
         * The small_image
         */
        public void setSmallImage(String smallImage) {
            this.smallImage = smallImage;
        }

        /**
         *
         * @return
         * The mediumImage
         */
        public String getMediumImage() {
            return mediumImage;
        }

        /**
         *
         * @param mediumImage
         * The medium_image
         */
        public void setMediumImage(String mediumImage) {
            this.mediumImage = mediumImage;
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

    }

    public class Data {

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
        @SerializedName("download_count")
        @Expose
        private Integer downloadCount;
        @SerializedName("like_count")
        @Expose
        private Integer likeCount;
        @SerializedName("rt_critics_score")
        @Expose
        private Integer rtCriticsScore;
        @SerializedName("rt_critics_rating")
        @Expose
        private String rtCriticsRating;
        @SerializedName("rt_audience_score")
        @Expose
        private Integer rtAudienceScore;
        @SerializedName("rt_audience_rating")
        @Expose
        private String rtAudienceRating;
        @SerializedName("description_intro")
        @Expose
        private String descriptionIntro;
        @SerializedName("description_full")
        @Expose
        private String descriptionFull;
        @SerializedName("yt_trailer_code")
        @Expose
        private String ytTrailerCode;
        @SerializedName("date_uploaded")
        @Expose
        private String dateUploaded;
        @SerializedName("date_uploaded_unix")
        @Expose
        private Integer dateUploadedUnix;
        @Expose
        private Images images;
        @Expose
        private List<Torrent> torrents = new ArrayList<Torrent>();
        @Expose
        private List<Director> directors = new ArrayList<Director>();
        @Expose
        private List<Actor> actors = new ArrayList<Actor>();

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
         * The downloadCount
         */
        public Integer getDownloadCount() {
            return downloadCount;
        }

        /**
         *
         * @param downloadCount
         * The download_count
         */
        public void setDownloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
        }

        /**
         *
         * @return
         * The likeCount
         */
        public Integer getLikeCount() {
            return likeCount;
        }

        /**
         *
         * @param likeCount
         * The like_count
         */
        public void setLikeCount(Integer likeCount) {
            this.likeCount = likeCount;
        }

        /**
         *
         * @return
         * The rtCriticsScore
         */
        public Integer getRtCriticsScore() {
            return rtCriticsScore;
        }

        /**
         *
         * @param rtCriticsScore
         * The rt_critics_score
         */
        public void setRtCriticsScore(Integer rtCriticsScore) {
            this.rtCriticsScore = rtCriticsScore;
        }

        /**
         *
         * @return
         * The rtCriticsRating
         */
        public String getRtCriticsRating() {
            return rtCriticsRating;
        }

        /**
         *
         * @param rtCriticsRating
         * The rt_critics_rating
         */
        public void setRtCriticsRating(String rtCriticsRating) {
            this.rtCriticsRating = rtCriticsRating;
        }

        /**
         *
         * @return
         * The rtAudienceScore
         */
        public Integer getRtAudienceScore() {
            return rtAudienceScore;
        }

        /**
         *
         * @param rtAudienceScore
         * The rt_audience_score
         */
        public void setRtAudienceScore(Integer rtAudienceScore) {
            this.rtAudienceScore = rtAudienceScore;
        }

        /**
         *
         * @return
         * The rtAudienceRating
         */
        public String getRtAudienceRating() {
            return rtAudienceRating;
        }

        /**
         *
         * @param rtAudienceRating
         * The rt_audience_rating
         */
        public void setRtAudienceRating(String rtAudienceRating) {
            this.rtAudienceRating = rtAudienceRating;
        }

        /**
         *
         * @return
         * The descriptionIntro
         */
        public String getDescriptionIntro() {
            return descriptionIntro;
        }

        /**
         *
         * @param descriptionIntro
         * The description_intro
         */
        public void setDescriptionIntro(String descriptionIntro) {
            this.descriptionIntro = descriptionIntro;
        }

        /**
         *
         * @return
         * The descriptionFull
         */
        public String getDescriptionFull() {
            return descriptionFull;
        }

        /**
         *
         * @param descriptionFull
         * The description_full
         */
        public void setDescriptionFull(String descriptionFull) {
            this.descriptionFull = descriptionFull;
        }

        /**
         *
         * @return
         * The ytTrailerCode
         */
        public String getYtTrailerCode() {
            return ytTrailerCode;
        }

        /**
         *
         * @param ytTrailerCode
         * The yt_trailer_code
         */
        public void setYtTrailerCode(String ytTrailerCode) {
            this.ytTrailerCode = ytTrailerCode;
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

        /**
         *
         * @return
         * The images
         */
        public Images getImages() {
            return images;
        }

        /**
         *
         * @param images
         * The images
         */
        public void setImages(Images images) {
            this.images = images;
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
         * The directors
         */
        public List<Director> getDirectors() {
            return directors;
        }

        /**
         *
         * @param directors
         * The directors
         */
        public void setDirectors(List<Director> directors) {
            this.directors = directors;
        }

        /**
         *
         * @return
         * The actors
         */
        public List<Actor> getActors() {
            return actors;
        }

        /**
         *
         * @param actors
         * The actors
         */
        public void setActors(List<Actor> actors) {
            this.actors = actors;
        }

    }

    public class Director {

        @Expose
        private String name;
        @SerializedName("small_image")
        @Expose
        private String smallImage;
        @SerializedName("medium_image")
        @Expose
        private String mediumImage;
        @SerializedName("imdb_code")
        @Expose
        private String imdbCode;

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The smallImage
         */
        public String getSmallImage() {
            return smallImage;
        }

        /**
         *
         * @param smallImage
         * The small_image
         */
        public void setSmallImage(String smallImage) {
            this.smallImage = smallImage;
        }

        /**
         *
         * @return
         * The mediumImage
         */
        public String getMediumImage() {
            return mediumImage;
        }

        /**
         *
         * @param mediumImage
         * The medium_image
         */
        public void setMediumImage(String mediumImage) {
            this.mediumImage = mediumImage;
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

    }

    public class Images {

        @SerializedName("background_image")
        @Expose
        private String backgroundImage;
        @SerializedName("small_cover_image")
        @Expose
        private String smallCoverImage;
        @SerializedName("medium_cover_image")
        @Expose
        private String mediumCoverImage;
        @SerializedName("large_cover_image")
        @Expose
        private String largeCoverImage;
        @SerializedName("medium_screenshot_image1")
        @Expose
        private String mediumScreenshotImage1;
        @SerializedName("medium_screenshot_image2")
        @Expose
        private String mediumScreenshotImage2;
        @SerializedName("medium_screenshot_image3")
        @Expose
        private String mediumScreenshotImage3;
        @SerializedName("large_screenshot_image1")
        @Expose
        private String largeScreenshotImage1;
        @SerializedName("large_screenshot_image2")
        @Expose
        private String largeScreenshotImage2;
        @SerializedName("large_screenshot_image3")
        @Expose
        private String largeScreenshotImage3;

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
         * The largeCoverImage
         */
        public String getLargeCoverImage() {
            return largeCoverImage;
        }

        /**
         *
         * @param largeCoverImage
         * The large_cover_image
         */
        public void setLargeCoverImage(String largeCoverImage) {
            this.largeCoverImage = largeCoverImage;
        }

        /**
         *
         * @return
         * The mediumScreenshotImage1
         */
        public String getMediumScreenshotImage1() {
            return mediumScreenshotImage1;
        }

        /**
         *
         * @param mediumScreenshotImage1
         * The medium_screenshot_image1
         */
        public void setMediumScreenshotImage1(String mediumScreenshotImage1) {
            this.mediumScreenshotImage1 = mediumScreenshotImage1;
        }

        /**
         *
         * @return
         * The mediumScreenshotImage2
         */
        public String getMediumScreenshotImage2() {
            return mediumScreenshotImage2;
        }

        /**
         *
         * @param mediumScreenshotImage2
         * The medium_screenshot_image2
         */
        public void setMediumScreenshotImage2(String mediumScreenshotImage2) {
            this.mediumScreenshotImage2 = mediumScreenshotImage2;
        }

        /**
         *
         * @return
         * The mediumScreenshotImage3
         */
        public String getMediumScreenshotImage3() {
            return mediumScreenshotImage3;
        }

        /**
         *
         * @param mediumScreenshotImage3
         * The medium_screenshot_image3
         */
        public void setMediumScreenshotImage3(String mediumScreenshotImage3) {
            this.mediumScreenshotImage3 = mediumScreenshotImage3;
        }

        /**
         *
         * @return
         * The largeScreenshotImage1
         */
        public String getLargeScreenshotImage1() {
            return largeScreenshotImage1;
        }

        /**
         *
         * @param largeScreenshotImage1
         * The large_screenshot_image1
         */
        public void setLargeScreenshotImage1(String largeScreenshotImage1) {
            this.largeScreenshotImage1 = largeScreenshotImage1;
        }

        /**
         *
         * @return
         * The largeScreenshotImage2
         */
        public String getLargeScreenshotImage2() {
            return largeScreenshotImage2;
        }

        /**
         *
         * @param largeScreenshotImage2
         * The large_screenshot_image2
         */
        public void setLargeScreenshotImage2(String largeScreenshotImage2) {
            this.largeScreenshotImage2 = largeScreenshotImage2;
        }

        /**
         *
         * @return
         * The largeScreenshotImage3
         */
        public String getLargeScreenshotImage3() {
            return largeScreenshotImage3;
        }

        /**
         *
         * @param largeScreenshotImage3
         * The large_screenshot_image3
         */
        public void setLargeScreenshotImage3(String largeScreenshotImage3) {
            this.largeScreenshotImage3 = largeScreenshotImage3;
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

    public class MovieDetailResponse {

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
        private String resolution;
        @Expose
        private Double framerate;
        @Expose
        private Integer seeds;
        @Expose
        private Integer peers;
        @Expose
        private String size;
        @SerializedName("size_bytes")
        @Expose
        private Integer sizeBytes;
        @SerializedName("download_count")
        @Expose
        private Integer downloadCount;
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
         * The resolution
         */
        public String getResolution() {
            return resolution;
        }

        /**
         *
         * @param resolution
         * The resolution
         */
        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        /**
         *
         * @return
         * The framerate
         */
        public Double getFramerate() {
            return framerate;
        }

        /**
         *
         * @param framerate
         * The framerate
         */
        public void setFramerate(Double framerate) {
            this.framerate = framerate;
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
        public Integer getSizeBytes() {
            return sizeBytes;
        }

        /**
         *
         * @param sizeBytes
         * The size_bytes
         */
        public void setSizeBytes(Integer sizeBytes) {
            this.sizeBytes = sizeBytes;
        }

        /**
         *
         * @return
         * The downloadCount
         */
        public Integer getDownloadCount() {
            return downloadCount;
        }

        /**
         *
         * @param downloadCount
         * The download_count
         */
        public void setDownloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
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
