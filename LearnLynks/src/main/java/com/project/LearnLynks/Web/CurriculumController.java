package com.project.LearnLynks.web;

import com.project.LearnLynks.Data.Repositories.CurriculumRepository;
import com.project.LearnLynks.services.CurriculumService;
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
    @Autowired
    private CurriculumRepository curriculumRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestParam("materials") MultipartFile material,
                                  @RequestParam ("name") String name,
                                  @RequestParam ("description") String description,
                                  @RequestParam ("creator") String creator) throws IOException {

        try {
            CreateCurriculumRequest request = new CreateCurriculumRequest();

            request.setName(name);
            request.setDescription(description);
            request.setCreator(creator);
            request.setMaterials(material.getBytes());

            CreateCurriculumResponse response = curriculumService.create(request);
            response.setMessage("Successfully created curriculum");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCurriculum (@RequestParam("materials") MultipartFile material,
                                     @RequestParam ("name") String name,
                                     @RequestParam ("description") String description,
                                     @RequestParam ("creator") String creator) throws IOException {

        try {
            UpdateCurriculumRequest request = new UpdateCurriculumRequest();

            request.setName(name);
            request.setDescription(description);
            request.setCreator(creator);
            request.setMaterials(material.getBytes());

            UpdateCurriculumResponse response = curriculumService.update(request);
            response.setMessage("Successfully updated curriculum");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
    public ArchiveCurriculumResponse archive( @PathVariable int curriculumId) {
        return curriculumService.archive((long) curriculumId);
    }

    @DeleteMapping("/deleteCurricula")
    public ResponseEntity<DeleteCurriculumResponse> deleteCurriculum( @RequestBody DeleteCurriculumRequest deleteCurriculumRequest) {
        try{
            System.out.println("Received DELETE request with name: " + deleteCurriculumRequest.getName());
            DeleteCurriculumResponse response = curriculumService.deleteCurriculum(deleteCurriculumRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            System.err.println("Error deleting curriculum: " + e.getMessage());
            DeleteCurriculumResponse response = new DeleteCurriculumResponse();
            response.setMessage("Error deleting curriculum");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
