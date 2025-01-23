package com.project.LearnLynks.web.controllers;

import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;
import com.project.LearnLynks.services.ProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class ProgressReportController {

    @Autowired
    private ProgressReportService progressReportService;

    @PostMapping("/reports")
    public ResponseEntity<?> report(@RequestBody ProgressReportRequest progressReportRequest) {
        try{
            ProgressReportResponse response = progressReportService.generateProgressReport(progressReportRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
