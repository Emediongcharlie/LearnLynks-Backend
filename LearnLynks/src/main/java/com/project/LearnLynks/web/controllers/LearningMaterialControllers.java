package com.project.LearnLynks.web.controllers;

import com.project.LearnLynks.dtos.request.CreateLessonPlanRequest;
import com.project.LearnLynks.dtos.request.DeleteLessonPlanRequest;
import com.project.LearnLynks.dtos.request.UpdateLessonPlanRequest;
import com.project.LearnLynks.dtos.response.CreateLessonPlanResponse;
import com.project.LearnLynks.dtos.response.DeleteLessonPlanResponse;
import com.project.LearnLynks.dtos.response.UpdateLessonPlanResponse;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.services.LearningMaterialsServices;
import com.project.LearnLynks.services.LessonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

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

//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
//        byte[] downloadedFile = learningMaterialsServices.downloadFile(fileName);
//        String contentType = Files.probeContentType(Paths.get(fileName));
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(contentType)).body(downloadedFile);
//    }

//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
//        try {
//            // Fetch file from database
//            byte[] fileBytes = learningMaterialsServices.downloadFile(fileName);
//
//            if (fileBytes == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body(("File not found: " + fileName).getBytes());
//            }
//
//            // Determine content type
//            String contentType = "application/octet-stream"; // Default content type
//            // You can add logic to determine the actual content type if needed
//
//            // Send file to client
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(contentType))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                    .body(fileBytes);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(("Error downloading file: " + e.getMessage()).getBytes());
//        }
//    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName) {
        try {
            // Fetch file from database
            byte[] fileBytes = learningMaterialsServices.downloadFile(fileName);

            if (fileBytes == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(("File not found: " + fileName).getBytes());
            }

            // Determine content type
            String contentType = Files.probeContentType(Paths.get(fileName));
            if (contentType == null) {
                contentType = "application/octet-stream"; // Default content type
            }

            // Send file to client
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(fileBytes);

        } catch (IOException e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error downloading file: " + e.getMessage()).getBytes());
        }
    }



//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<byte[]> download(@PathVariable String fileName) {
//        try {
//            // Define file storage location
//            Path filePath = Paths.get("uploads").resolve(fileName);
//
//            // Check if file exists
//            if (!Files.exists(filePath)) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body(("File not found: " + fileName).getBytes());
//            }
//
//            // Read file as byte array
//            byte[] fileBytes = Files.readAllBytes(filePath);
//
//            // Save a copy to another directory before sending
//            Path savePath = Paths.get("saved_downloads").resolve(fileName);
//            Files.write(savePath, fileBytes);  // Save file locally
//
//            // Determine content type
//            String contentType = Files.probeContentType(filePath);
//            if (contentType == null) {
//                contentType = "application/octet-stream";
//            }
//
//            // Send file to client
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(contentType))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                    .body(fileBytes);
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(("Error downloading file: " + e.getMessage()).getBytes());
//        }
//    }


    @PostMapping("/lesson-plan")
    public ResponseEntity<?> lessonPlan(@RequestParam("material") MultipartFile material,
                                             @RequestParam("lessonPlanName") String lessonPlanName,
                                             @RequestParam("lessonPlanDescription") String lessonPlanDescription,
                                             @RequestParam("lessonPlanStartDate") LocalDate lessonPlanStartDate,
                                             @RequestParam("lessonPlanEndDate") LocalDate lessonPlanEndDate,
                                             @RequestParam("lessonPlanDuration") String lessonPlanDuration,
                                             @RequestParam("lessonPlanStatus") String lessonPlanStatus,
                                             @RequestParam("CurriculumAdopted") String CurriculumAdopted
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
            return new ResponseEntity<>("successfully created lesson plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<LessonPlan>> getAllPlan(){
        try{
            List<LessonPlan> response = lessonPlanService.getAllLessonPlan();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-plan")
    public ResponseEntity<?> updateLessonPlan(@RequestParam("material") MultipartFile material,
                                        @RequestParam("lessonPlanName") String lessonPlanName,
                                        @RequestParam("lessonPlanDescription") String lessonPlanDescription,
                                        @RequestParam("lessonPlanStartDate") LocalDate lessonPlanStartDate,
                                        @RequestParam("lessonPlanEndDate") LocalDate lessonPlanEndDate,
                                        @RequestParam("lessonPlanDuration") String lessonPlanDuration,
                                        @RequestParam("lessonPlanStatus") String lessonPlanStatus,
                                        @RequestParam("CurriculumAdopted") String CurriculumAdopted
    ) throws IOException {

        try {
            UpdateLessonPlanRequest request = new UpdateLessonPlanRequest();
            request.setLessonPlanName(lessonPlanName);
            request.setLessonPlanDescription(lessonPlanDescription);
            request.setLessonPlanStartDate(lessonPlanStartDate);
            request.setLessonPlanEndDate(lessonPlanEndDate);
            request.setLessonPlanDuration(lessonPlanDuration);
            request.setLessonPlanStatus(lessonPlanStatus);
            request.setCurriculumAdopted(CurriculumAdopted);
            request.setMaterial(material.getBytes());

            UpdateLessonPlanResponse response = lessonPlanService.updateLessonPlan(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("successfully updated lesson plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-plan")
    public ResponseEntity<?> deletePlan(@RequestBody DeleteLessonPlanRequest deleteLessonPlan){
        try{
            DeleteLessonPlanResponse response = lessonPlanService.deleteLessonPlanByName(deleteLessonPlan.getLessonPlanName());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            DeleteLessonPlanResponse response = new DeleteLessonPlanResponse();
            response.setMessage("Error deleting lesson plan");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
