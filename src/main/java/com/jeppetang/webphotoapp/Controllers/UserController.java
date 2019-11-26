package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Models.User;
import com.jeppetang.webphotoapp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping("/createUser")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user){
        userServices.addUser(user);
        return "redirect:/";
    }
}
