package com.project.LearnLynks.services;

import com.project.LearnLynks.models.LearningMaterial;
import com.project.LearnLynks.repositories.LearningMaterialRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LearningMaterialsServicesImpl implements LearningMaterialsServices {

    @Autowired
    private LearningMaterialRepository learningMaterialRepository;

    @Override
    public String storeFiles(MultipartFile file) throws IOException {
        LearningMaterial files = new LearningMaterial();
                files.setFileName(file.getOriginalFilename());
                files.setFileType(file.getContentType());
                files.setFileData(file.getBytes());

        files = learningMaterialRepository.save(files);
        if(files.getId() != null){
            return "File stored successfully" + file.getOriginalFilename();
        }
        return "File storage failed";
    }

    @Override
    public byte[] downloadFile(String fileName) {
        return learningMaterialRepository.findByFileName(fileName).getFileData();
    }

    public void deleteFile(Long id) {
        learningMaterialRepository.deleteById(id);
    }
}
