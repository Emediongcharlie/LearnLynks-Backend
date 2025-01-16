package com.project.LearnLynks.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.LearnLynks.Data.Repositories.CurriculumRepository;
import com.project.LearnLynks.Services.CurriculumService;
import com.project.LearnLynks.dtos.request.CreateCurriculumRequest;
import com.project.LearnLynks.dtos.request.DeleteCurriculumRequest;
import com.project.LearnLynks.dtos.request.FindCurriculumRequest;
import com.project.LearnLynks.dtos.request.UpdateCurriculumRequest;
import com.project.LearnLynks.dtos.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;
    private CurriculumRepository curriculumRepository;

//    @PostMapping("/create")
//    public CreateCurriculumResponse create (@RequestBody CreateCurriculumRequest createCurriculumRequest) {
//        return curriculumService.create(createCurriculumRequest);
//    }

//    @PostMapping("/create")
//    public CreateCurriculumResponse create(
//            @RequestPart("data") String data,
//            @RequestPart("file") MultipartFile file) throws IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        CreateCurriculumRequest createCurriculumRequest = objectMapper.readValue(data, CreateCurriculumRequest.class);
//
//        // Set the file data in the request object
//        createCurriculumRequest.setMaterials(file.getBytes());
//
//        // Pass the request to the service for processing
//        return curriculumService.create(createCurriculumRequest);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("creator") String creator, @RequestParam("materials") MultipartFile materials) throws IOException {

        try{
            CreateCurriculumRequest request = new CreateCurriculumRequest();
            request.setName(name);
            request.setDescription(description);
            request.setCreator(creator);
            request.setMaterials(materials.getBytes());

            CreateCurriculumResponse response = curriculumService.create(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        }catch(IllegalArgumentException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>("Error processing request", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestParam("name") String name,
//                                    @RequestParam("description") String description,
//                                    @RequestParam("creator") String creator,
//                                    @RequestParam("materials") MultipartFile materials) {
//        try {
//            CreateCurriculumRequest request = new CreateCurriculumRequest();
//            request.setName(name);
//            request.setDescription(description);
//            request.setCreator(creator);
//            request.setMaterials(materials.getBytes()); // Convert file to bytes
//            CreateCurriculumResponse response = curriculumService.create(request);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }



    @PutMapping("/update")
    public UpdateCurriculumResponse update (@RequestBody UpdateCurriculumRequest updateCurriculumRequest) {
        return curriculumService.update(updateCurriculumRequest);
    }

    @GetMapping("/findByName")
    public FindCurriculumResponse findByName (@RequestBody FindCurriculumRequest findCurriculumRequest) {
        return curriculumService.findByName(findCurriculumRequest);
    }

    @GetMapping("/curricula")
    public FindCurriculumResponse getAll() {
        return curriculumService.getAll();
    }

    @PatchMapping("/curricula/{curriculumId}/archive")
    public ArchiveCurriculumResponse archive( @PathVariable Long curriculumId) {
        return curriculumService.archive(curriculumId);
    }

    @DeleteMapping("/deleteCurricula")
    public DeleteCurriculumResponse deleteCurriculum( @RequestBody DeleteCurriculumRequest deleteCurriculumRequest) {
        return curriculumService.deleteCurriculum(deleteCurriculumRequest);
    }
}
