package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;
import com.project.LearnLynks.models.Assessment;
import com.project.LearnLynks.models.Status;
import com.project.LearnLynks.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpls implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;


    @Override
    public CreateAssessmentResponse createAssessmentStatus(CreateAssessmentRequest assessmentRequest) {
        Assessment assessment = getAssessment();
        assessmentRepository.save(assessment);
        CreateAssessmentResponse response = new CreateAssessmentResponse();
        response.setStatus(assessment.getStatus());
        response.setMessage("Done");
        return response;
    }

    private static Assessment getAssessment() {
        Assessment assessment = new Assessment();
        boolean isActive = assessment.getStatus() == Status.ACTIVE;
        boolean isInactive = assessment.getStatus() == Status.INACTIVE;
        boolean isCompleted = assessment.getStatus() == Status.COMPLETED;
        if (isActive) {
            assessment.setStatus(Status.ACTIVE);
        }
        if(isInactive){
            assessment.setStatus(Status.INACTIVE);
        }
        if(isCompleted){
            assessment.setStatus(Status.COMPLETED);
        }
        return assessment;
    }

}
