package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;

public interface ProgressReportService {

    public ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest);


}
