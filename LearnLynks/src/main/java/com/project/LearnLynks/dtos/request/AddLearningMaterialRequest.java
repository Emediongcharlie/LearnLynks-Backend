package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.LessonPlan;


public class AddLearningMaterialRequest {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LessonPlan getLessonPlan() {
        return lessonPlan;
    }

    public void setLessonPlan(LessonPlan lessonPlan) {
        this.lessonPlan = lessonPlan;
    }

    private int id;
    private LessonPlan lessonPlan;
}
