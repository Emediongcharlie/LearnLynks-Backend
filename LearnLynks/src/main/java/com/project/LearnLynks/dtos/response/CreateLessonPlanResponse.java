package com.project.LearnLynks.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class CreateLessonPlanResponse {

    public Long getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(Long lessonPlanId) {
        this.lessonPlanId = lessonPlanId;
    }

    public String getLessonPlanName() {
        return lessonPlanName;
    }

    public void setLessonPlanName(String lessonPlanName) {
        this.lessonPlanName = lessonPlanName;
    }

    public String getLessonPlanDescription() {
        return lessonPlanDescription;
    }

    public void setLessonPlanDescription(String lessonPlanDescription) {
        this.lessonPlanDescription = lessonPlanDescription;
    }

    public LocalDate getLessonPlanStartDate() {
        return lessonPlanStartDate;
    }

    public void setLessonPlanStartDate(LocalDate lessonPlanStartDate) {
        this.lessonPlanStartDate = lessonPlanStartDate;
    }

    public LocalDate getLessonPlanEndDate() {
        return lessonPlanEndDate;
    }

    public void setLessonPlanEndDate(LocalDate lessonPlanEndDate) {
        this.lessonPlanEndDate = lessonPlanEndDate;
    }

    public LocalDate getLessonPlanDuration() {
        return lessonPlanDuration;
    }

    public void setLessonPlanDuration(LocalDate lessonPlanDuration) {
        this.lessonPlanDuration = lessonPlanDuration;
    }

    public String getLessonPlanStatus() {
        return lessonPlanStatus;
    }

    public void setLessonPlanStatus(String lessonPlanStatus) {
        this.lessonPlanStatus = lessonPlanStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Long lessonPlanId;
    private String lessonPlanName;
    private String lessonPlanDescription;
    private LocalDate lessonPlanStartDate;
    private LocalDate lessonPlanEndDate;
    private LocalDate lessonPlanDuration;
    private String lessonPlanStatus;
    private String message;
}
