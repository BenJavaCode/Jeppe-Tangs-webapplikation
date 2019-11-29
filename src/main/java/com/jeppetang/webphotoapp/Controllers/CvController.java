package com.jeppetang.webphotoapp.Controllers;


import com.jeppetang.webphotoapp.Models.Cv;
import com.jeppetang.webphotoapp.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CvController {

    @Autowired
    CvService cvService;

   @GetMapping("/Cv")
    public String Cv(Model model){
        model.addAttribute("cv", new  Cv());
        return "Cv";

    }

    @PostMapping("/Cv")
    public String updateCv(@ModelAttribute Cv cv, Model model){

       cvService.updateTheCV(cv);
       cvService.saveTheCv(cv);
       return "redirect:/";

    }


}
