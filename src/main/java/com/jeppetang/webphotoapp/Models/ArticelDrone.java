package com.jeppetang.webphotoapp.Models;

public class ArticelDrone {
    private int id;
    private String titel;
    private String video;
    private String picture;
    private String paragraf;
    private String gif;


    public ArticelDrone(){

    }

    public ArticelDrone(int id, String titel, String video, String picture, String paragraf, String gif) {
        this.id = id;
        this.titel = titel;
        this.video = video;
        this.picture = picture;
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

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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
                ", titel='" + titel + '\'' +
                ", video='" + video + '\'' +
                ", picture='" + picture + '\'' +
                ", paragraf='" + paragraf + '\'' +
                ", gif='" + gif + '\'' +
                '}';
    }
}
