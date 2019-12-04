package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Mail;

import java.util.List;

public interface MailRepository {

    List<Mail>getAllMail();
    List<Mail>findByMail(String mail);
    int saveMail(Mail mail);
    int delete(int id);
    Mail findById(int id);
    int countUnseen();
    int flipStatus(Mail mailm, int sec);



}
