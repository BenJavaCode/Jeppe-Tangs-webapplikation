package com.jeppetang.webphotoapp.Configurations;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Skrevet af ISL
 * I vores s3 confirguration opretter vi en s3client som vi bruger til at oprette kontakt til vores s3.
 * Vi har hentet aws-sdk dependency som indholder AmazonS3 interfacet hvilket vi bruger til at oprette en bean
 * vi kan autowired i vores s3Service.
 */

@Configuration
public class S3Config {

    /*
     * Binder vores s3 properties i application.properties til de Strings vi bruger i s3client.
     */
    @Value("${jsa.aws.access_key_id}")
    private String awsId;

    @Value("${jsa.aws.secret_access_key}")
    private String awsKey;

    @Value("${jsa.s3.region}")
    private String region;


    @Bean
    public AmazonS3 s3client(){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
        return s3Client;
    }
}

