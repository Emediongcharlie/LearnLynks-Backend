package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.EmailSenderRequest;
import com.project.LearnLynks.dtos.response.EmailSenderResponse;
import com.project.LearnLynks.services.ProgressReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailNotificationController {

    @Autowired
    private ProgressReportServiceImpl progressReportService;

    @PostMapping("/send-emails")
    public ResponseEntity<?> sendEmailNotification(@RequestBody EmailSenderRequest emailSenderRequest) {
        try {
            EmailSenderResponse sentEmail = progressReportService.sendEmail(emailSenderRequest);
            return new ResponseEntity<>(sentEmail, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
