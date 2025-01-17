package com.project.LearnLynks.dtos.request;


import java.time.LocalDate;

public class CreateLessonPlanRequest {


    public Long getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(Long lessonPlanId) {
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

    public String getLessonPlanStatus() {
        return lessonPlanStatus;
    }

    public void setLessonPlanStatus(String lessonPlanStatus) {
        this.lessonPlanStatus = lessonPlanStatus;
    }

    private Long lessonPlanId;
    private String lessonPlanName;
    private String lessonPlanDescription;
    private LocalDate lessonPlanStartDate;
    private LocalDate lessonPlanEndDate;

    public String getLessonPlanDuration() {
        return lessonPlanDuration;
    }

    public void setLessonPlanDuration(String lessonPlanDuration) {
        this.lessonPlanDuration = lessonPlanDuration;
    }

    private String lessonPlanDuration;
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

    private byte[] material;
}
