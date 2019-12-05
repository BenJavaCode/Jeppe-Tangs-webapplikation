package com.jeppetang.webphotoapp.Controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Repositories.ArtikelRepository;
import com.jeppetang.webphotoapp.Services.ArtikelService;
import com.jeppetang.webphotoapp.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ArticleDroneController {


    @Autowired
    ArtikelService artikelService;

    @Autowired
    S3Service s3Service;

    @Autowired
    AmazonS3 s3client;

    @Value("${jsa.s3.bucket}")
    String bucketName;


    @GetMapping("/createAD")
    public String createAD(Model model) {
        model.addAttribute("articleDrone", new ArticelDrone());
        return "createAD";
    }


    @RequestMapping(value = "createAD", method = RequestMethod.POST)
    public String createAD(@ModelAttribute ArticelDrone articelDrone, @RequestPart(value = "videoFile") MultipartFile videoFile, @RequestPart(value = "folderName1") String folderName1, @RequestPart(value = "gifFile") MultipartFile gifFile, @RequestPart(value = "folderName2") String folderName2) {
        articelDrone.setVideo(s3Service.uploadFile(videoFile, folderName1));
        articelDrone.setGif(s3Service.uploadFile(gifFile, folderName2));
        artikelService.storeAd(articelDrone);
        return "redirect:/";
    }

    @GetMapping("/deleteAD/{id}")
    public String deleteAD(@PathVariable int id, Model model){
        ArticelDrone ad = artikelService.requestAd(id);
        model.addAttribute("articleDrone", ad);
        return "deleteAD";
    }

    @PostMapping("/deleteAD")
    public String deleteAD(@ModelAttribute ArticelDrone articleDrone){
        s3Service.deleteFile(articleDrone.getVideo(), "videos");
        s3Service.deleteFile(articleDrone.getGif(), "gifs");
        artikelService.removeAd(articleDrone.getId());
        return "redirect:/";
    }

}