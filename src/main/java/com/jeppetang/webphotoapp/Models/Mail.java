package com.jeppetang.webphotoapp.Models;



public class Mail implements Comparable<Mail>{



    private String date;
    private int id;
    private String sender;
    private String content;
    private int phoneNumber;
    private String mail;
    private int status;


    public Mail(){

    }

    public Mail(int status,String date) {
        this.status = status;
        this.date = date;
    }

    public Mail(String mail,int status, String date, String sender){
        this.mail = mail;
        this.status = status;
        this.date = date;
        this.sender = sender;
    }


    public Mail( String sender,String date, String content, int phoneNumber, String mail, int status) {
        this.sender = sender;
        this.content = content;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.status = status;
    }


    public Mail(int id, String sender, String content, String date, int phoneNumber, String mail, int status) {
        this.date = date;
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mail{" +
                ", date=" + date +
                ", id=" + id +
                ", sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", mail='" + mail + '\'' +
                ", status=" + status +
                '}';
    }


    /**
     * Denne metode er egentligt ikke nødvendig, da vores liste allerede returneres sorteret efter id.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Mail o) {

        Integer integer = this.getId();
        Integer integero = o.getId();
        return integer.compareTo(integero);
    }
}
