package com.jeppetang.webphotoapp.Controllers;

import com.jeppetang.webphotoapp.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3testController {

    @Autowired
    S3Service s3Service;


    @PostMapping("/upload")
    public String uploadToS3(@RequestPart (value = "file") MultipartFile multipartFile, @RequestPart(value = "folderName") String folderName){
        return  s3Service.uploadFile(multipartFile, folderName);


    }

    @PostMapping("/delete")
    public String deleteFromS3(@RequestPart (value = "url") String fileUrl, @RequestPart(value = "folderName") String folderName){
        s3Service.deleteFile(fileUrl, folderName);
        return "deleted";
    }
}
