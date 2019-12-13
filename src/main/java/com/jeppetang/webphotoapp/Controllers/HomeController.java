package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Services.ArticleService;
import com.jeppetang.webphotoapp.Services.CvService;
import com.jeppetang.webphotoapp.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    CvService cvService;

    @Autowired
    MailService mailService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("cv", cvService.getAllCv());
        model.addAttribute("status", mailService.countUnAnswered());
        return "home";
    }

    @GetMapping("/cv-admin")
    public String homeAdmin(Model model){
        model.addAttribute("cv", cvService.getAllCv());

        return "cvAdmin";
    }

    @GetMapping("/editCV")
    public String editCV(Model model){

        model.addAttribute("cv", new Cv());

        return "cvform";

    }

    @PostMapping("/saveCv")
    public String editCV(@ModelAttribute Cv cv){
        cvService.addToCv(cv);

        return "redirect:/cv-admin";
    }

    @GetMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable int id){

        cvService.deleteFromCv(id);

        return "redirect:/cv-admin";
    }



}