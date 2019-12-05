package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleVideo", articleService.getAllAv());
        return "home";
    }

    @GetMapping("/Drone-fotograf")
    public String drone(Model model){
        model.addAttribute("articleDrone", articleService.getAllAd());
        return "dronefotograf";
    }
}
