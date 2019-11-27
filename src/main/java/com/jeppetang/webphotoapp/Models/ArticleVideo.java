package com.jeppetang.webphotoapp.Models;

public class ArticleVideo {

    private int id;
    private String title;
    private String video;
    private String picture;
    private String gif;
    private String paragraf;


    public ArticleVideo() {
    }


    public ArticleVideo(int id, String title, String video, String picture, String gif, String paragraf) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.picture = picture;
        this.gif = gif;
        this.paragraf = paragraf;
    }

    public String getParagraf() {
        return paragraf;
    }

    public void setParagraf(String paragraf) {
        this.paragraf = paragraf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    @Override
    public String toString() {
        return "ArticleVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", video='" + video + '\'' +
                ", picture='" + picture + '\'' +
                ", gif='" + gif + '\'' +
                ", paragraf='" + paragraf + '\'' +
                '}';
    }
}
