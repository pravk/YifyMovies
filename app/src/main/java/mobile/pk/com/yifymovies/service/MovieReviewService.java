package mobile.pk.com.yifymovies.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by hello on 8/2/2015.
 */
public interface MovieReviewService {

    @GET("/movie_reviews.json")
    public void getMovieReviews( @Query("movie_id") String movieId, Callback<MovieReviewResponse> responseCallback);

    public class Data {

        @SerializedName("review_count")
        @Expose
        private Integer reviewCount;
        @Expose
        private List<Review> reviews = new ArrayList<Review>();

        /**
         *
         * @return
         * The reviewCount
         */
        public Integer getReviewCount() {
            return reviewCount;
        }

        /**
         *
         * @param reviewCount
         * The review_count
         */
        public void setReviewCount(Integer reviewCount) {
            this.reviewCount = reviewCount;
        }

        /**
         *
         * @return
         * The reviews
         */
        public List<Review> getReviews() {
            return reviews;
        }

        /**
         *
         * @param reviews
         * The reviews
         */
        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
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

    public class MovieReviewResponse {

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

    public class Review {

        @Expose
        private String username;
        @SerializedName("user_rating")
        @Expose
        private Integer userRating;
        @SerializedName("user_location")
        @Expose
        private String userLocation;
        @SerializedName("review_summary")
        @Expose
        private String reviewSummary;
        @SerializedName("review_text")
        @Expose
        private String reviewText;
        @SerializedName("date_written")
        @Expose
        private String dateWritten;
        @SerializedName("date_written_unix")
        @Expose
        private Integer dateWrittenUnix;

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The userRating
         */
        public Integer getUserRating() {
            return userRating;
        }

        /**
         *
         * @param userRating
         * The user_rating
         */
        public void setUserRating(Integer userRating) {
            this.userRating = userRating;
        }

        /**
         *
         * @return
         * The userLocation
         */
        public String getUserLocation() {
            return userLocation;
        }

        /**
         *
         * @param userLocation
         * The user_location
         */
        public void setUserLocation(String userLocation) {
            this.userLocation = userLocation;
        }

        /**
         *
         * @return
         * The reviewSummary
         */
        public String getReviewSummary() {
            return reviewSummary;
        }

        /**
         *
         * @param reviewSummary
         * The review_summary
         */
        public void setReviewSummary(String reviewSummary) {
            this.reviewSummary = reviewSummary;
        }

        /**
         *
         * @return
         * The reviewText
         */
        public String getReviewText() {
            return reviewText;
        }

        /**
         *
         * @param reviewText
         * The review_text
         */
        public void setReviewText(String reviewText) {
            this.reviewText = reviewText;
        }

        /**
         *
         * @return
         * The dateWritten
         */
        public String getDateWritten() {
            return dateWritten;
        }

        /**
         *
         * @param dateWritten
         * The date_written
         */
        public void setDateWritten(String dateWritten) {
            this.dateWritten = dateWritten;
        }

        /**
         *
         * @return
         * The dateWrittenUnix
         */
        public Integer getDateWrittenUnix() {
            return dateWrittenUnix;
        }

        /**
         *
         * @param dateWrittenUnix
         * The date_written_unix
         */
        public void setDateWrittenUnix(Integer dateWrittenUnix) {
            this.dateWrittenUnix = dateWrittenUnix;
        }

    }
}
