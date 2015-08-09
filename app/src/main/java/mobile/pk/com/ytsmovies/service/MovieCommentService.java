package mobile.pk.com.ytsmovies.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by hello on 8/9/2015.
 */
public interface MovieCommentService {
    @GET("/movie_comments.json")
    public void getMovieComments(@Query("movie_id") String movieId, Callback<MovieCommentResponse> responseCallback);

    public class Comment {

        @SerializedName("comment_id")
        @Expose
        private Integer commentId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @Expose
        private String username;
        @SerializedName("user_profile_url")
        @Expose
        private String userProfileUrl;
        @SerializedName("small_user_avatar_image")
        @Expose
        private String smallUserAvatarImage;
        @SerializedName("medium_user_avatar_image")
        @Expose
        private String mediumUserAvatarImage;
        @SerializedName("user_group")
        @Expose
        private String userGroup;
        @SerializedName("like_count")
        @Expose
        private Integer likeCount;
        @SerializedName("comment_text")
        @Expose
        private String commentText;
        @SerializedName("date_added")
        @Expose
        private String dateAdded;
        @SerializedName("date_added_unix")
        @Expose
        private Integer dateAddedUnix;

        /**
         *
         * @return
         * The commentId
         */
        public Integer getCommentId() {
            return commentId;
        }

        /**
         *
         * @param commentId
         * The comment_id
         */
        public void setCommentId(Integer commentId) {
            this.commentId = commentId;
        }

        /**
         *
         * @return
         * The userId
         */
        public Integer getUserId() {
            return userId;
        }

        /**
         *
         * @param userId
         * The user_id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

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
         * The userProfileUrl
         */
        public String getUserProfileUrl() {
            return userProfileUrl;
        }

        /**
         *
         * @param userProfileUrl
         * The user_profile_url
         */
        public void setUserProfileUrl(String userProfileUrl) {
            this.userProfileUrl = userProfileUrl;
        }

        /**
         *
         * @return
         * The smallUserAvatarImage
         */
        public String getSmallUserAvatarImage() {
            return smallUserAvatarImage;
        }

        /**
         *
         * @param smallUserAvatarImage
         * The small_user_avatar_image
         */
        public void setSmallUserAvatarImage(String smallUserAvatarImage) {
            this.smallUserAvatarImage = smallUserAvatarImage;
        }

        /**
         *
         * @return
         * The mediumUserAvatarImage
         */
        public String getMediumUserAvatarImage() {
            return mediumUserAvatarImage;
        }

        /**
         *
         * @param mediumUserAvatarImage
         * The medium_user_avatar_image
         */
        public void setMediumUserAvatarImage(String mediumUserAvatarImage) {
            this.mediumUserAvatarImage = mediumUserAvatarImage;
        }

        /**
         *
         * @return
         * The userGroup
         */
        public String getUserGroup() {
            return userGroup;
        }

        /**
         *
         * @param userGroup
         * The user_group
         */
        public void setUserGroup(String userGroup) {
            this.userGroup = userGroup;
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
         * The commentText
         */
        public String getCommentText() {
            return commentText;
        }

        /**
         *
         * @param commentText
         * The comment_text
         */
        public void setCommentText(String commentText) {
            this.commentText = commentText;
        }

        /**
         *
         * @return
         * The dateAdded
         */
        public String getDateAdded() {
            return dateAdded;
        }

        /**
         *
         * @param dateAdded
         * The date_added
         */
        public void setDateAdded(String dateAdded) {
            this.dateAdded = dateAdded;
        }

        /**
         *
         * @return
         * The dateAddedUnix
         */
        public Integer getDateAddedUnix() {
            return dateAddedUnix;
        }

        /**
         *
         * @param dateAddedUnix
         * The date_added_unix
         */
        public void setDateAddedUnix(Integer dateAddedUnix) {
            this.dateAddedUnix = dateAddedUnix;
        }

    }

    public class Data {

        @SerializedName("comment_count")
        @Expose
        private Integer commentCount;
        @Expose
        private List<Comment> comments = new ArrayList<Comment>();

        /**
         *
         * @return
         * The commentCount
         */
        public Integer getCommentCount() {
            return commentCount;
        }

        /**
         *
         * @param commentCount
         * The comment_count
         */
        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        /**
         *
         * @return
         * The comments
         */
        public List<Comment> getComments() {
            return comments;
        }

        /**
         *
         * @param comments
         * The comments
         */
        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

    }

    public class MovieCommentResponse {

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
}
