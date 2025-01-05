package com.troncoPruebas.classroom.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.troncoPruebas.classroom.models.vm.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    private final static String BUCKET = "classroomtroncos3bucket";

    @GetMapping("/config")
    public AmazonS3Client amazonS3Client() {
        AppConfig appConfig = new AppConfig();
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(appConfig.getCloud().getAws().getCredentials().getAccessKey(), appConfig.getCloud().getAws().getCredentials().getSecretKey());

        // Construir el cliente S3 directamente como AmazonS3Client
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(appConfig.getCloud().getAws().getS3().getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    public String putObject(MultipartFile file) {
        AmazonS3Client client = amazonS3Client();
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = String.format(file.getOriginalFilename(), extension);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());

        try{
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET,key,file.getInputStream(),metadata);
            client.putObject(putObjectRequest);
            return key;
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    @GetMapping("/config")
    public Asset getObject(String key) {

        AmazonS3Client client = amazonS3Client();
        S3Object s3Object = client.getObject(BUCKET, key);
        ObjectMetadata metadata = s3Object.getObjectMetadata();

        try {
            S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
            byte[] bytes = IOUtils.toByteArray(objectInputStream);

            return new Asset(bytes,metadata.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteObject(String key) {
        AmazonS3Client client = amazonS3Client();
        client.deleteObject(BUCKET, key);
    }
    public String getObjectUrl(String key) {
        return String.format("https://%s.s3.amazonaws.com/%s", BUCKET, key);
    }
}
