package com.project.LearnLynks.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface LearningMaterialsServices {

    public String storeFiles(MultipartFile file) throws IOException;
    public byte[] downloadFile(String fileName);

}
