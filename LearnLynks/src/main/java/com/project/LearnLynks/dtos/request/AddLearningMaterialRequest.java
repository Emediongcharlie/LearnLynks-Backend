package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.LessonPlan;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AddLearningMaterialRequest {

    private int id;
    private LessonPlan lessonPlan;
}
