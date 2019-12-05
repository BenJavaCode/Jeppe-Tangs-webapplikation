package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Models.Mail;
import com.jeppetang.webphotoapp.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Controller
public class MailController {



    @Autowired
    MailService mailService;

    @GetMapping("/beskeder")
    public String mails(Model model){
        List<Mail> mails = mailService.fetchAllMails();
        model.addAttribute("mails", mails);
        return "beskeder";
    }

    @GetMapping("/kontakt")
    public String createMail(Model model){
        model.addAttribute("create", new Mail(0,mailService.getTime()));
        return "kontakt";
    }

    @RequestMapping(value = "/saveMail", method = RequestMethod.POST)
    public String save(@ModelAttribute Mail mail){
        mailService.saveMail(mail);
        mailService.autoReplies(mail.getMail());
        return "redirect:/kontakt";
    }



    @RequestMapping(value = "/view/{id}")
    public String answer(Model model, @PathVariable int id){

        Mail mailkunde = mailService.findById(id);
        List<Mail> liste = mailService.fetchByMail(mailkunde.getMail());
        mailService.answered(mailkunde);

        model.addAttribute("beskeder", liste);
        model.addAttribute("svar", new Mail(mailkunde.getMail(),4,mailService.getTime(),"Svar fra Jeppe Tang"));


        return "answer";
    }

    @RequestMapping(value = "/SendAnswer", method = RequestMethod.POST)
    public String sendAnswer(@ModelAttribute Mail mail){

        mailService.sendEmail(mail.getMail(), mail.getSender(), mail.getContent());
        mailService.saveMail(mail);

        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String admin(Model model){

        model.addAttribute("status", mailService.countUnAnswered());

        return "admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){

        mailService.delete(id);

        return "redirect:/beskeder";
    }
}
