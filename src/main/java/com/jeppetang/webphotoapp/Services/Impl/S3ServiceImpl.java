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

/*
Skrevet af ISL
S3Service bliver brugt til at uploade filer til s3.
 */
@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    private AmazonS3 s3client;

    //Denne value anotering sørger for at alle filer bliver uploadet til den rigtige s3 bucket.
    @Value("${jsa.s3.bucket}")
    String bucketName;

    //Benytter nedafstående metoder til at uploade til s3 og returne en object url der referer til filen der ligger i s3.
    @Override
    public String uploadFile(MultipartFile multipartFile, String folderName) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = folderName + "/" + generateFileName(multipartFile);
            uploadFileTos3bucket(fileName, file);
            fileUrl = s3client.getUrl(bucketName,fileName).toString();
            file.delete();
        } catch (Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }

    //S3 putobject metoden modtager kun File som parameter så vi bliver nødt til at convertere dem fra multipartfile til file
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File (file.getOriginalFilename());
        FileOutputStream fos =  new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    //Genere et navn ud fra dato og tid. På denne måde undgår vi at 2 filer hedder det samme i vores bucket, hvilket ville give en fejl.
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    //Metoden der via s3client uploader til s3.
    public void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    //Metoden der via s3client sletter fra s3
    @Override
    public void deleteFile(String fileUrl, String folderName) {
        String fileName = folderName + "/" + fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(bucketName,fileName);
    }
}
