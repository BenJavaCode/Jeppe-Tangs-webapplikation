package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.Mail;

import java.util.List;

public interface MailRepository {

    List<Mail>getAllMail();
    int saveMail(Mail mail);
    int delete(int id);
    Mail findById(int id);



}
