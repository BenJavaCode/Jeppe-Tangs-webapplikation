package com.jeppetang.webphotoapp.Models;

public class Article {

    private int id;
    private String title;
    private String date;
    private String videoContent;
    private String pictureContent;
    private String gif;


    public Article() {
    }

    public Article(int id, String title, String date, String videoContent, String pictureContent, String gif) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.videoContent = videoContent;
        this.pictureContent = pictureContent;
        this.gif = gif;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent;
    }

    public String getPictureContent() {
        return pictureContent;
    }

    public void setPictureContent(String pictureContent) {
        this.pictureContent = pictureContent;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", videoContent='" + videoContent + '\'' +
                ", pictureContent='" + pictureContent + '\'' +
                ", gif='" + gif + '\'' +
                '}';
    }
}
