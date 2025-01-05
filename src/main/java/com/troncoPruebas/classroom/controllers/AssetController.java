package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.Service.S3Service;
import com.troncoPruebas.classroom.models.vm.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/archivos")
public class AssetController {

    @Autowired
    private S3Service s3Service;

    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

    @CrossOrigin
    @PostMapping("/upload")
    Map<String,String> upload(@RequestParam MultipartFile file) {
        String key = s3Service.putObject(file);
        logger.info(key);
        Map<String,String> result = new HashMap<>();
        result.put("key", key);
        result.put("url", s3Service.getObjectUrl(key));
        return result;
    }
//    @CrossOrigin
//    @GetMapping(value = "/get-object", params = "key")
//    ResponseEntity<ByteArrayResource> getObject(@RequestParam String key) {
//        Asset asset = s3Service.getObject(key);
//        ByteArrayResource resource = new ByteArrayResource(asset.getContent());
//
//        return  ResponseEntity.ok().header("Content-Type", asset.getContentType()).contentLength(asset.getContent().length).body(resource);
//    }
    @CrossOrigin
    @GetMapping(value = "/get-object", params = "key")
    ResponseEntity<ByteArrayResource> getObject(@RequestParam String key) {
        Asset asset = s3Service.getObject(key);
        ByteArrayResource resource = new ByteArrayResource(asset.getContent());
        logger.info("imagen pedida:{}", key);
        return  ResponseEntity.ok().header("Content-Type", asset.getContentType()).contentLength(asset.getContent().length).body(resource);
    }

    @DeleteMapping(value = "/delete-object", params = "key")
    void deleteObject(@RequestParam String key) {
        s3Service.deleteObject(key);
    }
}
