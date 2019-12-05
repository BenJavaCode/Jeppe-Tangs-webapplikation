package com.jeppetang.webphotoapp.Controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.jeppetang.webphotoapp.Models.ArticelDrone;
import com.jeppetang.webphotoapp.Models.ArticleVideo;
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
public class ArticleVideoController {

    @Autowired
    ArtikelRepository artikelRepository;

    @Autowired
    S3Service s3Service;

    @Autowired
    AmazonS3 s3client;

    @Autowired
    ArtikelService artikelService;

    @Value("${jsa.s3.bucket}")
    String bucketName;

    @GetMapping("/createAV")
    public String createAD(Model model){
        model.addAttribute("articleVideo", new ArticleVideo());
        return "createAV";
    }
    @RequestMapping(value = "createAV", method = RequestMethod.POST)
    public String createAV(@ModelAttribute ArticleVideo articleVideo, @RequestPart(value = "videoFile") MultipartFile videoFile, @RequestPart(value = "folderName1") String folderName1, @RequestPart(value = "pictureFile") MultipartFile pictureFile, @RequestPart(value = "folderName2") String folderName2) {
        articleVideo.setVideo(s3Service.uploadFile(videoFile, folderName1));
        articleVideo.setPicture(s3Service.uploadFile(pictureFile, folderName2));
        artikelRepository.saveAv(articleVideo);
        return "redirect:/";
    }
    
    @GetMapping("/deleteAV/{id}")
    public String deleteAD(@PathVariable int id, Model model){
        ArticleVideo av = artikelService.requestAv(id);
        model.addAttribute("articleDrone", av);
        return "deleteAV";
    }

    @PostMapping("/deleteAV")
    public String deleteAD(@ModelAttribute ArticleVideo articleVideo){
        s3Service.deleteFile(articleVideo.getVideo(), "videos");
        s3Service.deleteFile(articleVideo.getPicture(), "pictures");
        artikelService.removeAv(articleVideo.getId());
        return "redirect:/";
    }

}
