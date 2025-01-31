package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.PersonalizedLearningByUsernameRequest;
import com.project.LearnLynks.dtos.request.PersonalizedLearningRequest;
import com.project.LearnLynks.dtos.response.PersonalizedLearningResponse;
import com.project.LearnLynks.services.PersonalizedLearningService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonalizedLearningController {

    @Autowired
    private PersonalizedLearningService personalizedLearningService;

    @PostMapping("/request-with-username")
    public ResponseEntity<?> requestWithId(@RequestBody PersonalizedLearningByUsernameRequest request) {
        try{
            PersonalizedLearningResponse response = personalizedLearningService.requestPersonalizedLearningByUsername(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/request-with=lesson-plan-name")
    public ResponseEntity<?> requestWithLessonPlanName(@RequestBody PersonalizedLearningRequest request, String lessonPlanName) {
        try{
            PersonalizedLearningResponse response = personalizedLearningService.requestPersonalizedLearningByLessonPlanName(lessonPlanName, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
