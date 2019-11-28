package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Models.Mailer;
import com.jeppetang.webphotoapp.Repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@ComponentScan
@EnableAutoConfiguration
@Component
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






}
