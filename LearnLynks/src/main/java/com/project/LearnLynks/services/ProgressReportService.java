package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.EmailSenderRequest;
import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.request.SearchProgressReportRequest;
import com.project.LearnLynks.dtos.response.EmailSenderResponse;

import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.dtos.response.SearchProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;

import java.util.List;

public interface ProgressReportService {
    ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest);
    EmailSenderResponse sendEmail(EmailSenderRequest emailSenderRequest);
    public List<ProgressReport> getAllProgressReports();
    SearchProgressReportResponse searchById(SearchProgressReportRequest searchProgressReportRequest);
}
