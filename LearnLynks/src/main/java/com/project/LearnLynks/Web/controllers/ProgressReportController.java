package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.services.ProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/progress-reports")
public class ProgressReportController {

    @Autowired
    private ProgressReportService progressReportService;

    @PostMapping("/generate")
    public ProgressReportResponse generateProgressReport(@RequestBody ProgressReportRequest progressReportRequest) {
        return progressReportService.generateProgressReport(progressReportRequest);
    }
}
