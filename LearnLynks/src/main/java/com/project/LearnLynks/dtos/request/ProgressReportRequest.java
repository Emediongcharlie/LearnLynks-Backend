package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.Grades;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.models.Status;
import com.project.LearnLynks.models.Users;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

public class ProgressReportRequest {


    private Long progressId;


    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @OneToOne
        private Long userId;
        private Status status;
        private LocalDate reportDate;
        private String recommendation;

    public Long getLessonPlanId() {
        return lessonPlanId;
    }

    public void setLessonPlanId(Long lessonPlanId) {
        this.lessonPlanId = lessonPlanId;
    }

    private Long lessonPlanId;
    

    
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
    
        public String getWeakness() {
            return weakness;
        }
    
        public void setWeakness(String weakness) {
            this.weakness = weakness;
        }
    
        public String getStrength() {
            return strength;
        }
    
        public void setStrength(String strength) {
            this.strength = strength;
        }

    public LessonPlan getLessonPlan() {
        return lessonPlan;
    }

    public void setLessonPlan(LessonPlan lessonPlan) {
        this.lessonPlan = lessonPlan;
    }

    @ManyToOne
        private LessonPlan lessonPlan;
        private String weakness;
        private String strength;
    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    private Grades grade;
    }