package com.jeppetang.webphotoapp.Models;

public class Mail {

    private int id;
    private String sender;
    private String content;
    private String date;
    private int phoneNumber;

    public Mail() {}

    public Mail(int id, String sender, String date, String content, int phoneNumber) {
        this.id = id;
        this.sender = sender;
        this.date = date;
        this.content = content;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
