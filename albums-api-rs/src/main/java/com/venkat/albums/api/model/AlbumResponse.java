package com.venkat.albums.api.model;

public class AlbumResponse {

    private String userId;
    private String albumId;
    private String title;
    private String description;
    private String url;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAlbumId() {
        return albumId;
    }
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
