package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;

import java.util.List;

public interface MailService {

    List<Mail> fetchAllMails();
    List<Mail> fetchByMail(String mail);
    void saveMail(Mail mail);
    void autoReplies(String receiver);
    void delete(int id);
    Mail findById(int id);
    public void sendEmail(String receiver,String subject, String text);
    public int countUnAnswered();
    public void answered(Mail mail);
    public String getTime();

}
