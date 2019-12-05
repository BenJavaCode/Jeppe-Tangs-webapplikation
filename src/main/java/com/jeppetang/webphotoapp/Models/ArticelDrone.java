package com.jeppetang.webphotoapp.Models;

public class ArticelDrone {
    
    private int id;
    private String titel;
    private String paragraf;
    private String video;
    private String gif;


    public ArticelDrone(){

    }

    public ArticelDrone(int id, String titel, String paragraf, String video, String gif) {
        this.id = id;
        this.titel = titel;
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
                ", paragraf='" + paragraf + '\'' +
                ", gif='" + gif + '\'' +
                '}';
    }
}
