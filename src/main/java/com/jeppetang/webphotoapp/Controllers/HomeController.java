package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Services.ArticleService;
import com.jeppetang.webphotoapp.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CvService cvService;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("cv", cvService.getAllCv());

        return "home";
    }
}