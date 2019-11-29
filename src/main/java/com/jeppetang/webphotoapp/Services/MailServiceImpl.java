package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    MailRepository mailRepository;


    @Override
    public List<Mail> fetchAllMails() {
        return mailRepository.getAllMail();
    }

    @Override
    public void saveMail(Mail mail) {
        mailRepository.saveMail(mail);
    }

    @Override
    public void delete(int id) {
        mailRepository.delete(id);
    }

    @Override
    public Mail findById(int id){
        return mailRepository.findById(id);

    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("itamar.lokzinsky@gmail.com");

        msg.setSubject("Ang dit lægebesøg");
        msg.setText("Jeg er ked af at meddele dig at du har gonore i dine bihulder. mvh din læge");

        javaMailSender.send(msg);

    }

}
