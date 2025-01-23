package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.EmailSenderRequest;
import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.EmailSenderResponse;

import com.project.LearnLynks.dtos.response.ProgressReportResponse;

public interface ProgressReportService {
    ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest);
    EmailSenderResponse sendEmail(EmailSenderRequest emailSenderRequest);
}
