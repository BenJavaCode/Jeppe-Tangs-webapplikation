package com.jeppetang.webphotoapp.Models;

public class Mailer {

    private String mail;
    private String firstName;
    private String lastName;

    public Mailer(){

    }

    public Mailer(String mail, String firstName, String lastName) {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Mailer{" +
                "mail='" + mail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
