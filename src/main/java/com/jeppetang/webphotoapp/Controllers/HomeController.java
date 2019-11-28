package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Services.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ArtikelService artikelService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleVideo", artikelService.getAllAv());
        return "home";
    }

    @GetMapping("/Drone-fotograf")
    public String drone(Model model){
        model.addAttribute("articleDrone", artikelService.getAllAd());
        return "dronefotograf";
    }
}
