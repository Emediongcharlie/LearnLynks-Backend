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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentServiceImpls implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private LessonPlanRepository lessonPlanRepository;
    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private QuizService quizService;

    @Override
    public CreateAssessmentResponse createAssessment(CreateAssessmentRequest createAssessmentRequest) {
        LessonPlan lessonPlan = lessonPlanRepository.findById(createAssessmentRequest.getLessonPlanId())
                .orElseThrow(() -> new RuntimeException("Lesson plan not found"));

        Double score = quizService.calculateScore(
                Collections.singletonList(createAssessmentRequest.getQuizId()),
                Collections.singletonList(createAssessmentRequest.getUserAnswers())
        );

        List<Assessment> userAssessments = assessmentRepository.findAll();

        int numberOfQuizzesTaken = userAssessments.size() + 1;

        Double totalScore = userAssessments.stream().mapToDouble(Assessment::getScore).sum() + score;

        Double timeSpent = (double) loginLogService.calculateTotalTimeSpent(createAssessmentRequest.getId());

        Double averageScore = totalScore / numberOfQuizzesTaken;

        String grade = calculateGrade(totalScore);


        Assessment assessment = new Assessment();
        assessment.setId(createAssessmentRequest.getId());
        assessment.setLessonPlan(lessonPlan);
        assessment.setCompletionDate(LocalDate.now());
        assessment.setAverageScore(averageScore);
        assessment.setTimeSpent(timeSpent);
        assessment.setTotalScore(totalScore);
        assessment.setGrade(grade);
        assessment.setScore(score);
        assessment.setNumberOfQuizzesTaken(numberOfQuizzesTaken);

        Assessment savedAssessment = assessmentRepository.save(assessment);
        return mapToCreateAssessmentResponse(savedAssessment);
    }

    @Override
    public GetAssessmentResponse getAssessment(Long assessmentId) {
        Optional<Assessment> assessments = assessmentRepository.findById(assessmentId);
        if (assessments.isEmpty()) {
            throw new RuntimeException("Assessment not found");
        }
        Assessment assessment = assessments.get();
        return mapToGetAssessmentResponse(assessment);
    }

    @Override
    public UpdateAssessmentResponse updateAssessment(Long assessmentId, UpdateAssessmentRequest updateAssessmentRequest) {
        Optional<Assessment> assessments = assessmentRepository.findById(assessmentId);
        if (assessments.isEmpty()) {
            throw new RuntimeException("Assessment not found");
        }
        Assessment assessment = assessments.get();

        Double newScore = quizService.calculateScore(
                Collections.singletonList(updateAssessmentRequest.getQuizId()),
                Collections.singletonList(updateAssessmentRequest.getUserAnswer())
        );

        List<Assessment> userAssessments = assessmentRepository.findAll();

        int numberOfQuizzesTaken = userAssessments.size();

        assessment.setTotalScore(assessment.getTotalScore() + newScore);
        assessment.setNumberOfQuizzesTaken(numberOfQuizzesTaken);
        assessment.setAverageScore(assessment.getTotalScore() / numberOfQuizzesTaken);
        assessment.setGrade(calculateGrade(assessment.getTotalScore()));

        Assessment updated = assessmentRepository.save(assessment);
        return mapToUpdateAssessmentResponse(updated);
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

    private CreateAssessmentResponse mapToCreateAssessmentResponse(Assessment assessment) {
        CreateAssessmentResponse response = new CreateAssessmentResponse();
        response.setAssessmentId(assessment.getAssessmentId());
        response.setId(assessment.getId());
        response.setLessonPlanId(assessment.getLessonPlan().getId());
        response.setCompletionDate(assessment.getCompletionDate());
        response.setAverageScore(assessment.getAverageScore());
        response.setTimeSpent(assessment.getTimeSpent());
        response.setTotalScore(assessment.getTotalScore());
        response.setGrade(assessment.getGrade());
        response.setScore(assessment.getScore());
        return response;
    }

    private UpdateAssessmentResponse mapToUpdateAssessmentResponse(Assessment assessment) {
        UpdateAssessmentResponse response = new UpdateAssessmentResponse();
        response.setAssessmentId(assessment.getAssessmentId());
        response.setId(assessment.getId());
        response.setLessonPlanId(assessment.getLessonPlan().getId());
        response.setCompletionDate(assessment.getCompletionDate());
        response.setAverageScore(assessment.getAverageScore());
        response.setTimeSpent(assessment.getTimeSpent());
        response.setTotalScore(assessment.getTotalScore());
        response.setGrade(assessment.getGrade());
        response.setScore(assessment.getScore());
        return response;
    }


    private GetAssessmentResponse mapToGetAssessmentResponse(Assessment assessment) {
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
}