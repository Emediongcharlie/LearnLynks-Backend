package com.project.LearnLynks.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LearningMaterialsServices {

    public String storeFiles(MultipartFile file) throws IOException;
    public byte[] downloadFile(String fileName);

}
