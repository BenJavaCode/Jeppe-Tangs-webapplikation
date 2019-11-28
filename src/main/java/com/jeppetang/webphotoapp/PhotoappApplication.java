package com.jeppetang.webphotoapp;

import com.jeppetang.webphotoapp.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class PhotoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoappApplication.class, args);
    }


}
