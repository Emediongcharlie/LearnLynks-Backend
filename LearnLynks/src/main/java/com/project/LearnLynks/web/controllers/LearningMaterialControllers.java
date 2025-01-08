package com.project.LearnLynks.web.controllers;

import com.project.LearnLynks.services.LearningMaterialsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LearningMaterialControllers {

    @Autowired
    private LearningMaterialsServices learningMaterialsServices;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadedFiles = learningMaterialsServices.storeFiles(file);

        return ResponseEntity.status(HttpStatus.OK).body(uploadedFiles);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName) {
        byte[] downloadedFile = learningMaterialsServices.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(downloadedFile);
    }

}
