package com.project.LearnLynks.models;

import com.project.LearnLynks.Data.Models.Curriculum;
import jakarta.persistence.*;

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




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonPlanName;
    private String lessonPlanDescription;
    private LocalDate lessonPlanStartDate;
    private LocalDate lessonPlanEndDate;
    private LocalDate lessonPlanDuration;
    private String lessonPlanStatus;


    public String getCurriculumAdopted() {
        return CurriculumAdopted;
    }

    public void setCurriculumAdopted(String curriculumAdopted) {
        CurriculumAdopted = curriculumAdopted;
    }

    private String CurriculumAdopted;

    public byte[] getMaterial() {
        return material;
    }

    public void setMaterial(byte[] material) {
        this.material = material;
    }

    @Lob
    private byte[] material;



}
