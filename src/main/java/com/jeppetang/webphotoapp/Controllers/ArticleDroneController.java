package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Services.ArticleService;
import com.jeppetang.webphotoapp.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
Skrevet af ISL, BL, AH
Controller der styrer alt data flow der har med oprettelse, sletning og visning af Drone Artikler at gøre.
 */
@Controller
public class ArticleDroneController {


    @Autowired
    ArticleService articleService;

    @Autowired
    S3Service s3Service;

    @Value("${jsa.s3.bucket}")
    String bucketName;

    @GetMapping("/createAD")
    public String createAD(Model model) {
        model.addAttribute("articleDrone", new ArticleDrone());
        return "createAD";
    }

    @RequestMapping(value = "createAD", method = RequestMethod.POST)
    public String createAD(@ModelAttribute ArticleDrone articleDrone, @RequestPart(value = "videoFile") MultipartFile videoFile, @RequestPart(value = "gifFile") MultipartFile gifFile) {
        articleDrone.setVideo(s3Service.uploadFile(videoFile, "videos"));
        articleDrone.setGif(s3Service.uploadFile(gifFile, "gifs"));
        articleService.storeAd(articleDrone);
        return "redirect:/";
    }

    @GetMapping("/deleteAD/{id}")
    public String deleteAD(@PathVariable int id, Model model) {
        ArticleDrone ad = articleService.requestAd(id);
        model.addAttribute("articleDrone", ad);
        return "deleteAD";
    }

    @PostMapping("/deleteAD")
    public String deleteAD(@ModelAttribute ArticleDrone articleDrone) {
        s3Service.deleteFile(articleDrone.getVideo(), "videos");
        s3Service.deleteFile(articleDrone.getGif(), "gifs");
        articleService.removeAd(articleDrone.getId());
        return "redirect:/";
    }

    @GetMapping("/drone-galleri")
    public String getAllAVs(Model model) {
        List<ArticleDrone> articleDrones = articleService.getAllAd();
        model.addAttribute("articleDrones", articleDrones);
        return "drone-galleri";
    }

    @GetMapping("/editAD/{id}")
    public String editAD(@PathVariable int id, Model model) {
        ArticleDrone ad = articleService.requestAd(id);
        model.addAttribute("aritcleDrone", ad);
        return "/editAD";
    }

    @PostMapping("/editAD")
    public String editAD(@ModelAttribute ArticleDrone articleDrone) {
        articleService.changeAd(articleDrone);
        return "/editAD";
    }
}