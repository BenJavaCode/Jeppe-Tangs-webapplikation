package com.jeppetang.webphotoapp.Services.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.jeppetang.webphotoapp.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    private AmazonS3 s3client;

    @Value("${jsa.s3.bucket}")
    String bucketName;



    @Override
    public String uploadFile(MultipartFile multipartFile, String folderName) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = folderName + "/" + generateFileName(multipartFile);
            uploadFileTos3bucket(fileName, file);
            fileUrl = s3client.getUrl(bucketName,fileName).toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File (file.getOriginalFilename());
        FileOutputStream fos =  new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    public void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @Override
    public void deleteFile(String fileUrl, String folderName) {
        String fileName = folderName + "/" + fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(bucketName,fileName);
    }
}
