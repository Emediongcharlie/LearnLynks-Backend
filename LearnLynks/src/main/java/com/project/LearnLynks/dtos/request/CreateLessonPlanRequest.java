package com.project.LearnLynks.dtos.request;


import com.project.LearnLynks.models.Curriculum;
import com.project.LearnLynks.models.LearningMaterial;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class CreateLessonPlanRequest {


    public int getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(int lessonPlanId) {
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

    private int lessonPlanId;
    private String lessonPlanName;
    private String lessonPlanDescription;
    private LocalDate lessonPlanStartDate;
    private LocalDate lessonPlanEndDate;
    private LocalDate lessonPlanDuration;
    private String lessonPlanStatus;

    public List<Curriculum> getCurriculumAdopted() {
        return CurriculumAdopted;
    }

    public void setCurriculumAdopted(List<Curriculum> curriculumAdopted) {
        CurriculumAdopted = curriculumAdopted;
    }

    public List<LearningMaterial> getMaterial() {
        return material;
    }

    public void setMaterial(List<LearningMaterial> material) {
        this.material = material;
    }

    @OneToMany
    private List<Curriculum> CurriculumAdopted;
    @OneToMany
    private List<LearningMaterial> material;
}
