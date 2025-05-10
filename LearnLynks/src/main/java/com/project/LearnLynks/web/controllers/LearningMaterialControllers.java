package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.CreateLessonPlanRequest;
import com.project.LearnLynks.dtos.response.CreateLessonPlanResponse;
import com.project.LearnLynks.services.LearningMaterialsServices;
import com.project.LearnLynks.services.LessonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@RestController
@RequestMapping
public class LearningMaterialControllers {

    @Autowired
    private LearningMaterialsServices learningMaterialsServices;
    @Autowired
    private LessonPlanService lessonPlanService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadedFiles = learningMaterialsServices.storeFiles(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadedFiles);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
        byte[] downloadedFile = learningMaterialsServices.downloadFile(fileName);
        String contentType = Files.probeContentType(Paths.get(fileName));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(contentType)).body(downloadedFile);
    }

    @PostMapping("/lesson-plan")
    public ResponseEntity<?> lessonPlan(@RequestParam("material") MultipartFile material,
                                             @RequestParam("lessonName") String lessonPlanName,
                                             @RequestParam String lessonPlanDescription,
                                             @RequestParam LocalDate lessonPlanStartDate,
                                             @RequestParam LocalDate lessonPlanEndDate,
                                             @RequestParam LocalDate lessonPlanDuration,
                                             @RequestParam String lessonPlanStatus,
                                             @RequestParam String CurriculumAdopted
                                             ) throws IOException {

        try {
            CreateLessonPlanRequest request = new CreateLessonPlanRequest();
            request.setLessonPlanName(lessonPlanName);
            request.setLessonPlanDescription(lessonPlanDescription);
            request.setLessonPlanStartDate(lessonPlanStartDate);
            request.setLessonPlanEndDate(lessonPlanEndDate);
            request.setLessonPlanDuration(lessonPlanDuration);
            request.setLessonPlanStatus(lessonPlanStatus);
            request.setCurriculumAdopted(CurriculumAdopted);
            request.setMaterial(material.getBytes());

            CreateLessonPlanResponse response = lessonPlanService.createLessonPlan(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
