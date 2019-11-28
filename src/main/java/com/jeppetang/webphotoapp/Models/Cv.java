package com.jeppetang.webphotoapp.Models;

public class Cv {

    private String title;
    private String mainText;
    private String mailAddress;
    private int phoneNumber;
    private String previousWork;
    private String cvPicture;


    public Cv() {
    }

    public Cv(String title, String mainText, String mailAddress, int phoneNumber, String previousWork ,String cvPicture ) {
        this.title = title;
        this.mainText = mainText;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.previousWork = previousWork;
        this.cvPicture = cvPicture;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreviousWork() {
        return previousWork;
    }

    public void setPreviousWork(String previousWork) {
        this.previousWork = previousWork;
    }


    public String getCvPicture() {
        return cvPicture;
    }

    public void setCvPicture(String cvPicture) {
        this.cvPicture = cvPicture;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "title='" + title + '\'' +
                ", mainText='" + mainText + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", previousWork='" + previousWork + '\'' +
                ", cvPicture='" + cvPicture + '\'' +
                '}';
    }
}
