package com.project.LearnLynks.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ProgressReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    private Long userId;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(Long lessonPlanId) {
        this.lessonPlanId = lessonPlanId;
    }

    private Long lessonPlanId;

    private Status status;
    private LocalDate reportDate;
    private String recommendation;

    public LessonPlan getLessonPlan() {
        return lessonPlan;
    }

    public void setLessonPlan(LessonPlan lessonPlan) {
        this.lessonPlan = lessonPlan;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_plan_id", referencedColumnName = "lesson_plan_id")
    private LessonPlan lessonPlan;

    private Ability weakness;
    private Ability strength;
    private Grades grade;

    // Getters and Setters
    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Ability getWeakness() {
        return weakness;
    }

    public void setWeakness(Ability weakness) {
        this.weakness = weakness;
    }

    public Ability getStrength() {
        return strength;
    }

    public void setStrength(Ability strength) {
        this.strength = strength;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }
}
