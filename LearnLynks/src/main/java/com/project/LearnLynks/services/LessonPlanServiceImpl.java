package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
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
        lessonPlan.setLessonPlanDuration(createLessonPlanRequest.getLessonPlanDuration());
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

    public DeleteLessonPlanResponse deleteLessonPlanByName(String lessonPlanName) {
        Optional<LessonPlan> lessonPlan = lessonPlanRepository.findByLessonPlanName(lessonPlanName);
        if (lessonPlan.isPresent()) {
            lessonPlanRepository.delete(lessonPlan.get());
            DeleteLessonPlanResponse deleteLessonPlanResponse = new DeleteLessonPlanResponse();
            deleteLessonPlanResponse.setMessage("Successfully deleted");
            return deleteLessonPlanResponse;
        }
        return  null;
    }

    @Override
    public UpdateLessonPlanResponse updateLessonPlan(UpdateLessonPlanRequest updateLessonPlan) {
        if(updateLessonPlan == null){
            throw new IllegalArgumentException("Update LessonPlan required");
        }
        if(updateLessonPlan.getLessonPlanName() == null){
            throw new IllegalArgumentException("LessonPlan name required");
        }
        if(updateLessonPlan.getLessonPlanDescription() == null){
            throw new IllegalArgumentException("LessonPlan description required");
        }
        LessonPlan lesson = lessonPlanRepository.findByLessonPlanName(updateLessonPlan.getLessonPlanName())
                .orElseThrow(() -> new IllegalArgumentException("LessonPlan not found"));

        lesson.setLessonPlanName(updateLessonPlan.getLessonPlanName());
        lesson.setLessonPlanDescription(updateLessonPlan.getLessonPlanDescription());
        lesson.setLessonPlanStatus(updateLessonPlan.getLessonPlanStatus());
        lesson.setLessonPlanDuration(updateLessonPlan.getLessonPlanDuration());
        lesson.setLessonPlanStartDate(updateLessonPlan.getLessonPlanStartDate());
        lesson.setLessonPlanEndDate(updateLessonPlan.getLessonPlanEndDate());
        lesson.setCurriculumAdopted(updateLessonPlan.getCurriculumAdopted());
        lesson.setMaterial(updateLessonPlan.getMaterial());
        lessonPlanRepository.save(lesson);

        UpdateLessonPlanResponse updateLessonPlanResponse = new UpdateLessonPlanResponse();
        updateLessonPlanResponse.setMessage("Successfully updated");
        return updateLessonPlanResponse;


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
