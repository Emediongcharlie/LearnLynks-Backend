package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateAssessmentRequest;
import com.project.LearnLynks.dtos.request.UpdateAssessmentRequest;
import com.project.LearnLynks.dtos.response.CreateAssessmentResponse;
import com.project.LearnLynks.dtos.response.DeleteAssessmentResponse;
import com.project.LearnLynks.dtos.response.GetAssessmentResponse;
import com.project.LearnLynks.dtos.response.UpdateAssessmentResponse;
import com.project.LearnLynks.models.Assessment;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.repositories.AssessmentRepository;
import com.project.LearnLynks.repositories.LessonPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssessmentServiceImpls implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private LessonPlanRepository lessonPlanRepository;
    @Autowired
    private LoginLogService loginLogService;

    @Override
    public CreateAssessmentResponse createAssessment(CreateAssessmentRequest createAssessmentRequest) {
        LessonPlan lessonPlan = lessonPlanRepository.findById(createAssessmentRequest.getLessonPlanId())
                .orElseThrow(() -> new RuntimeException("Lesson plan not found"));

        Double timeSpent = (double) loginLogService.calculateTotalTimeSpent(createAssessmentRequest.getId());

        Double averageScore = createAssessmentRequest.getTotalScore() / 10;

        String grade = calculateGrade(createAssessmentRequest.getTotalScore());


        Assessment assessment = new Assessment();
        assessment.setId(createAssessmentRequest.getId());
        assessment.setLessonPlan(lessonPlan);
        assessment.setCompletionDate(LocalDate.now());
        assessment.setAverageScore(averageScore);
        assessment.setTimeSpent(timeSpent);
        assessment.setTotalScore(createAssessmentRequest.getTotalScore());
        assessment.setGrade(grade);

        Assessment savedAssessment = assessmentRepository.save(assessment);

        CreateAssessmentResponse response = new CreateAssessmentResponse();
        response.setAssessmentId(savedAssessment.getAssessmentId());
        response.setId(savedAssessment.getId());
        response.setLessonPlanId(savedAssessment.getLessonPlan().getId());
        response.setCompletionDate(savedAssessment.getCompletionDate());
        response.setAverageScore(savedAssessment.getAverageScore());
        response.setTimeSpent(savedAssessment.getTimeSpent());
        response.setTotalScore(savedAssessment.getTotalScore());
        response.setGrade(savedAssessment.getGrade());

        return response;
    }

    @Override
    public GetAssessmentResponse getAssessment(Long assessmentId) {
        Assessment assessment = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));

        GetAssessmentResponse response = new GetAssessmentResponse();
        response.setId(assessment.getId());
        response.setLessonPlanId(assessment.getLessonPlan().getId());
        response.setCompletionDate(assessment.getCompletionDate());
        response.setAverageScore(assessment.getAverageScore());
        response.setTimeSpent(assessment.getTimeSpent());
        response.setTotalScore(assessment.getTotalScore());
        response.setGrade(assessment.getGrade());
        return response;
    }

    @Override
    public UpdateAssessmentResponse updateAssessment(Long assessmentId, UpdateAssessmentRequest updateAssessmentRequest) {
        Assessment assessment = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));

        assessment.setTotalScore(updateAssessmentRequest.getTotalScore());
        assessment.setTimeSpent(updateAssessmentRequest.getTimeSpent());
        assessment.setGrade(calculateGrade(updateAssessmentRequest.getTotalScore()));

        Assessment updated = assessmentRepository.save(assessment);

        UpdateAssessmentResponse response = new UpdateAssessmentResponse();
        response.setAssessmentId(updated.getAssessmentId());
        response.setId(updated.getId());
        response.setLessonPlanId(updated.getLessonPlan().getId());
        response.setCompletionDate(updated.getCompletionDate());
        response.setAverageScore(updated.getAverageScore());
        response.setTimeSpent(updated.getTimeSpent());
        response.setTotalScore(updated.getTotalScore());
        response.setGrade(updated.getGrade());

        return response;
    }

    @Override
    public DeleteAssessmentResponse deleteAssessment(Long assessmentId) {
        assessmentRepository.deleteById(assessmentId);
        DeleteAssessmentResponse response = new DeleteAssessmentResponse();
        response.setMessage("Assessment deleted successfully");
        return response;
    }

    @Override
    public String calculateGrade(Double totalScore) {
        if (totalScore >= 90) {
            return "A";
        } else if (totalScore >= 80) {
            return "B";
        } else if (totalScore >= 70) {
            return "C";
        } else if (totalScore >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}