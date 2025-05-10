package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.AddLearningMaterialRequest;
import com.project.LearnLynks.dtos.request.CreateLessonPlanRequest;
import com.project.LearnLynks.dtos.request.RemoveLearningMaterialRequest;
import com.project.LearnLynks.dtos.request.UpdateLessonPlanRequest;
import com.project.LearnLynks.dtos.response.AddLearningMaterialResponse;
import com.project.LearnLynks.dtos.response.CreateLessonPlanResponse;
import com.project.LearnLynks.dtos.response.RemoveLearningMaterialResponse;
import com.project.LearnLynks.dtos.response.UpdateLessonPlanResponse;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.repositories.LessonPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonPlanServiceImpl implements LessonPlanService {

    @Autowired
    private LessonPlanRepository lessonPlanRepository;

    @Override
    public CreateLessonPlanResponse createLessonPlan(CreateLessonPlanRequest createLessonPlanRequest) {
        LessonPlan lessonPlan = getLessonPlan(createLessonPlanRequest);
        CreateLessonPlanResponse createLessonPlanResponse = getCreateLessonPlanResponse(lessonPlan);
        return createLessonPlanResponse;
    }

    private LessonPlan getLessonPlan(CreateLessonPlanRequest createLessonPlanRequest) {
        LessonPlan lessonPlan = new LessonPlan();
        lessonPlan.setLessonPlanName(createLessonPlanRequest.getLessonPlanName());
        lessonPlan.setLessonPlanDescription(createLessonPlanRequest.getLessonPlanDescription());
        lessonPlan.setLessonPlanStatus(createLessonPlanRequest.getLessonPlanStatus());
        lessonPlan.setLessonPlanDuration(createLessonPlanRequest.getLessonPlanDuration().plusMonths(1));
        lessonPlan.setLessonPlanStartDate(LocalDate.now());
        lessonPlan.setLessonPlanEndDate(createLessonPlanRequest.getLessonPlanStartDate().plusDays(30));
        lessonPlan.setMaterial(createLessonPlanRequest.getMaterial());
        lessonPlan.setCurriculumAdopted(createLessonPlanRequest.getCurriculumAdopted());
        lessonPlanRepository.save(lessonPlan);
        return lessonPlan;
    }

    private static CreateLessonPlanResponse getCreateLessonPlanResponse(LessonPlan lessonPlan) {
        CreateLessonPlanResponse createLessonPlanResponse = new CreateLessonPlanResponse();
        createLessonPlanResponse.setLessonPlanId(lessonPlan.getId());
        createLessonPlanResponse.setLessonPlanName(lessonPlan.getLessonPlanName());
        createLessonPlanResponse.setLessonPlanDescription(lessonPlan.getLessonPlanDescription());
        createLessonPlanResponse.setLessonPlanStatus(lessonPlan.getLessonPlanStatus());
        createLessonPlanResponse.setLessonPlanDuration(lessonPlan.getLessonPlanDuration());
        createLessonPlanResponse.setLessonPlanStartDate(lessonPlan.getLessonPlanStartDate());
        createLessonPlanResponse.setLessonPlanEndDate(lessonPlan.getLessonPlanEndDate());
        createLessonPlanResponse.setLessonPlanStatus(lessonPlan.getLessonPlanStatus());
        createLessonPlanResponse.setMessage("Successfully created");
        return createLessonPlanResponse;
    }

    @Override
    public List<LessonPlan> getAllLessonPlan() {
        return lessonPlanRepository.findAll();
    }

    @Override
    public LessonPlan getLessonPlanById(int lessonPlanId) {
        return lessonPlanRepository.findById(lessonPlanId).get();
    }


    @Override
    public LessonPlan deleteLessonPlan(int lessonPlanId) {
        LessonPlan lessonPlan = lessonPlanRepository.findById(lessonPlanId).get();
        lessonPlanRepository.delete(lessonPlan);
        return lessonPlan;
    }

    @Override
    public UpdateLessonPlanResponse updateLessonPlan(UpdateLessonPlanRequest updateLessonPlan) {
        return null;
    }

    @Override
    public AddLearningMaterialResponse addLearningMaterial(AddLearningMaterialRequest addLearningMaterialrequest) {
        Optional<LessonPlan> optionalLearningMaterial = lessonPlanRepository.findByLessonPlanName(addLearningMaterialrequest.getLessonPlan().getLessonPlanName());
        if (optionalLearningMaterial.isPresent()) {
            LessonPlan lessonPlan = optionalLearningMaterial.get();
            lessonPlan.setMaterial(addLearningMaterialrequest.getLessonPlan().getMaterial());
        }
        return null;
    }

    @Override
    public RemoveLearningMaterialResponse removeMaterial(RemoveLearningMaterialRequest request) {
        return null;
    }
}
