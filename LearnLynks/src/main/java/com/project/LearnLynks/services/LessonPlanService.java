package com.project.LearnLynks.Services;

import com.project.LearnLynks.dtos.request.AddLearningMaterialRequest;
import com.project.LearnLynks.dtos.request.CreateLessonPlanRequest;
import com.project.LearnLynks.dtos.request.RemoveLearningMaterialRequest;
import com.project.LearnLynks.dtos.request.UpdateLessonPlanRequest;
import com.project.LearnLynks.dtos.response.AddLearningMaterialResponse;
import com.project.LearnLynks.dtos.response.CreateLessonPlanResponse;
import com.project.LearnLynks.dtos.response.RemoveLearningMaterialResponse;
import com.project.LearnLynks.dtos.response.UpdateLessonPlanResponse;
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
}
