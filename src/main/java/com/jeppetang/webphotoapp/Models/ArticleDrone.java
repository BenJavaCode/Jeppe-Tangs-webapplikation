package com.jeppetang.webphotoapp.Models;

public class ArticleDrone {
    
    private int id;
    private String title;
    private String paragraf;
    private String video;
    private String gif;


    public ArticleDrone(){

    }

    public ArticleDrone(int id, String title, String paragraf, String video, String gif) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.paragraf = paragraf;
        this.gif = gif;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getParagraf() {
        return paragraf;
    }

    public void setParagraf(String paragraf) {
        this.paragraf = paragraf;
    }

    @Override
    public String toString() {
        return "ArtikelDrone{" +
                "id=" + id +
                ", titel='" + title + '\'' +
                ", video='" + video + '\'' +
                ", paragraf='" + paragraf + '\'' +
                ", gif='" + gif + '\'' +
                '}';
    }
}
