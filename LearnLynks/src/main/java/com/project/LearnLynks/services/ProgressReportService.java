package com.project.LearnLynks.Services;

import com.project.LearnLynks.dtos.request.ProgressReportRequest;
import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;

public interface ProgressReportService {

    public ProgressReportResponse generateProgressReport(ProgressReportRequest progressReportRequest);


}
