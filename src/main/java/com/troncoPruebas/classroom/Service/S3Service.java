package com.troncoPruebas.classroom.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.troncoPruebas.classroom.models.vm.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    private final static String BUCKET = "classroomtroncos3bucket";

    @Autowired
    private AmazonS3Client amazonS3Client;

    public String putObject(MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String key = String.format(file.getOriginalFilename(), extension);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());

        try{
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET,key,file.getInputStream(),metadata);
            amazonS3Client.putObject(putObjectRequest);
            return key;
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public Asset getObject(String key) {
        S3Object s3Object = amazonS3Client.getObject(BUCKET, key);
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
        amazonS3Client.deleteObject(BUCKET, key);
    }
    public String getObjectUrl(String key) {
        return String.format("https://%s.s3.amazonaws.com/%s", BUCKET, key);
    }
}
