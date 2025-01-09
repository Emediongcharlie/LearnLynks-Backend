package com.project.LearnLynks.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity

public class LessonPlan {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonPlanName;
    private String lessonPlanDescription;
    private LocalDate lessonPlanStartDate;
    private LocalDate lessonPlanEndDate;
    private LocalDate lessonPlanDuration;
    private String lessonPlanStatus;
    @OneToMany
    private List<Curriculum> CurriculumAdopted;
    @OneToMany
    private List<LearningMaterial> material;

//    public Materials getLessonTool() {
//        return lessonTool;
//    }

//    public void setLessonTool(Materials lessonTool) {
//        this.lessonTool = lessonTool;
//    }
//
//    private Materials lessonTool;

}
