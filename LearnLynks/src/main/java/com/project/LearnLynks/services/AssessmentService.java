package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;

public interface AssessmentService {

    public CreateAssessmentResponse createAssessmentStatus(CreateAssessmentRequest assessmentRequest);

}
