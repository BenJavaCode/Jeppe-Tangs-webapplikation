package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;

import java.util.List;

public interface MailService {

    List<Mail> fetchAllMails();
    void saveMail(Mail mail);
    void delete(int id);
    Mail findById(int id);
    public void sendEmail();

}
