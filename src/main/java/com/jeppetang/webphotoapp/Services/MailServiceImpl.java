package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
    public void autoReplies(String receiver){

        //til JeppeBob
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("tegnerthomsen@gmail.com");
        msg.setSubject("Du har fået en ny mail fra en kunde");
        msg.setText("En kunde har skrevet til dig på Jeppe-Tang.dk, gå til din side for at besvare den.");
        javaMailSender.send(msg);

        //og til en konfirmationsmail til kunden
        SimpleMailMessage msg2 = new SimpleMailMessage();
        msg2.setTo(receiver);
        msg2.setSubject("Jeppe Tang har modtaget din besked");
        msg2.setText("Jeppe Tang har modtaget din meddelelse og vil besvare den hurtigst muligt. Mvh Jeppe-Tang.dk");
        javaMailSender.send(msg2);
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
    public void sendEmail(String receiver, String subject, String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(receiver);
        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);

    }

    @Override
    public int countUnAnswered(){

        return mailRepository.countUnseen();
    }

    @Override
    public void answered(Mail mail){

        mailRepository.flipStatus(mail,1);
    }

    @Override
    public List<Mail> fetchByMail(String mail){

        List<Mail> list =  mailRepository.findByMail(mail);
        Collections.sort(list);
        return list;

    }

    @Override
    public String getTime(){

        Instant instant = Instant.now();
        ZonedDateTime datetime = instant.atZone(ZoneId.of("Europe/Stockholm"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss ");
        String formattedString = datetime.format(formatter);


        return formattedString;

    }

}
