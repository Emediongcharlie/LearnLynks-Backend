package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.models.LessonPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonPlanService {

    public CreateLessonPlanResponse createLessonPlan(CreateLessonPlanRequest createLessonPlanRequest);
    public List<LessonPlan> getAllLessonPlan();
    public LessonPlan getLessonPlanById(int lessonPlanId);
    public LessonPlan deleteLessonPlan(int lessonPlanId);
    public UpdateLessonPlanResponse updateLessonPlan(UpdateLessonPlanRequest updateLessonPlan);
    public AddLearningMaterialResponse addLearningMaterial(AddLearningMaterialRequest addLearningMaterialrequest);
    public RemoveLearningMaterialResponse removeMaterial(RemoveLearningMaterialRequest request);
    public DeleteLessonPlanResponse deleteLessonPlanByName(String deleteLessonPlanRequest);
}
