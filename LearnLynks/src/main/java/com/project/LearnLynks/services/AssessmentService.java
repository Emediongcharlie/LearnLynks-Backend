package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.request.UpdateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;
import com.project.LearnLynks.dtos.response.DeleteAssessmentResponse;
import com.project.LearnLynks.dtos.response.GetAssessmentResponse;
import com.project.LearnLynks.dtos.response.UpdateAssessmentResponse;

public interface AssessmentService {
    CreateAssessmentResponse createAssessment(CreateAssessmentRequest createAssessmentRequest);
    GetAssessmentResponse getAssessment(Long assessmentId);
    UpdateAssessmentResponse updateAssessment(Long assessmentId, UpdateAssessmentRequest updateAssessmentRequest);
    DeleteAssessmentResponse deleteAssessment(Long assessmentId);
    String calculateGrade(Double totalScore);
}
