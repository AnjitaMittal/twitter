package com.example.hp.twitter;

public class Tweets {
    private String tweet;
    private String user;
    private String photoUrl;

    public Tweets() {
    }

    public Tweets(String message, String author, String photoUrl) {
        this.tweet = message;
        this.user = author;
        this.photoUrl = photoUrl;
    }

    public String getMessage() {
        return tweet;
    }

    public void setMessage(String message) {
        this.tweet = message;
    }

    public String getAuthor() {
        return user;
    }

    public void setAuthor(String author) {
        this.user = author;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
