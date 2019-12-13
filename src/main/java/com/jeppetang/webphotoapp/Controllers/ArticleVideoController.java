package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Models.ArticleDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
import com.jeppetang.webphotoapp.Services.ArticleService;
import com.jeppetang.webphotoapp.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ArticleVideoController {

    @Autowired
    S3Service s3Service;

    @Autowired
    ArticleService articleService;

    @Value("${jsa.s3.bucket}")
    String bucketName;

    @GetMapping("/createAV")
    public String createAD(Model model){
        model.addAttribute("articleVideo", new ArticleVideo());
        return "createAV";
    }
    @PostMapping("/createAV ")
    public String createAV(@ModelAttribute ArticleVideo articleVideo, @RequestPart(value = "videoFile") MultipartFile videoFile, @RequestPart(value = "pictureFile") MultipartFile pictureFile) {
        articleVideo.setVideo(s3Service.uploadFile(videoFile, "videos"));
        articleVideo.setPicture(s3Service.uploadFile(pictureFile, "pictures"));
        articleService.storeAv(articleVideo);
        return "redirect:/";
    }
    
    @GetMapping("/deleteAV/{id}")
    public String deleteAD(@PathVariable int id, Model model){
        ArticleVideo av = articleService.requestAv(id);
        model.addAttribute("articleVideo", av);
        return "deleteAV";
    }

    @PostMapping("/deleteAV")
    public String deleteAV(@ModelAttribute ArticleVideo articleVideo){
        s3Service.deleteFile(articleVideo.getVideo(), "videos");
        s3Service.deleteFile(articleVideo.getPicture(), "pictures");
        articleService.removeAv(articleVideo.getId());
        return "redirect:/av-admin";
    }

    @GetMapping("/video-galleri")
    public String getAllAVs(Model model){
        List<ArticleVideo> articleVideos = articleService.getAllAv();
        model.addAttribute("articleVideos",articleVideos);
        return "video-galleri";
    }

    @GetMapping("/av-admin")
    public String AdAdmin( Model model) {

        List<ArticleVideo> articleVideos = articleService.getAllAv();

        model.addAttribute("articleVideos", articleVideos);

        return "/AvAdmin";
    }

    @GetMapping("/editAV/{id}")
    public String editAD(@PathVariable int id, Model model){

        model.addAttribute("articleVideos", articleService.requestAv(id));

        return "editAV";
    }


    @PostMapping("/updateAV/")
    public String editAD(@ModelAttribute ArticleVideo articleVideo) {
        articleService.changeAv(articleVideo);
        return "redirect:/av-admin";
    }
}
