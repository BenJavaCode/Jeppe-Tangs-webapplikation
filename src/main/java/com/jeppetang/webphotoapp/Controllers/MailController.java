package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MailController {


    @Autowired
    MailService mailService;

    @GetMapping("/mails")
    public String mails(Model model){
        List<Mail> mails = mailService.fetchAllMails();
        model.addAttribute("mails", mails);
        return "mails";
    }

    @GetMapping("/mails/{id}")
    public String displayMail(@PathVariable int id, Model model){
        Mail mail = mailService.findById(id);
        model.addAttribute(mail);
        return "displayMail";
    }
}
