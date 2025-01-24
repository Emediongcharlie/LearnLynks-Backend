package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class CreateAssessmentRequest {
    private Long id;
    private Long lessonPlanId;
    private Double totalScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(Long lessonPlanId) {
        this.lessonPlanId = lessonPlanId;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}

