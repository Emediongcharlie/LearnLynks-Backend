package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;
import com.project.LearnLynks.models.Assessment;

public interface AssessmentService {

    public CreateAssessmentResponse createAssessmentStatus(CreateAssessmentRequest assessmentRequest);

}
