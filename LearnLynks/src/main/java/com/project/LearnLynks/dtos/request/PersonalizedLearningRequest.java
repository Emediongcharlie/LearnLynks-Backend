package com.project.LearnLynks.dtos.request;

import jakarta.persistence.Column;

public class PersonalizedLearningRequest {

    @Column(name = "lesson_plan_name", nullable = false, unique = true)
    private String LessonPlanName;


    public String getLessonPlanName() {
        return LessonPlanName;
    }

    public void setLessonPlanName(String lessonPlanName) {
        LessonPlanName = lessonPlanName;
    }
}
