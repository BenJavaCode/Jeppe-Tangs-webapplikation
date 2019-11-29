package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MessageController {


    private MailService mailService;

    public MessageController(MailService smtp) {
        this.mailService = smtp;
    }

    @RequestMapping("/mail")
    public String mail() throws MessagingException {

        mailService.sendEmail();

        return "email sent";
    }
}
