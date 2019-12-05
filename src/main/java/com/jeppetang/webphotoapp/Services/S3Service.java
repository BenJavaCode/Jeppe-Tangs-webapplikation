package com.jeppetang.webphotoapp.Services;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

    public String uploadFile(MultipartFile multipartFile, String folderName);

    public void deleteFile(String fileUrl, String folderName);

}
