package com.jeppetang.webphotoapp.Models;

public class Cv {

    private int id;
    private int year;
    private String title;
    private String role;

    public Cv() {
    }

    public Cv(int id, int year, String title, String role) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.role = role;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
