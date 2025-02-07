package com.project.LearnLynks.dtos.response;

import com.project.LearnLynks.models.Grades;
import com.project.LearnLynks.models.Status;

import java.time.LocalDate;

public class SearchProgressReportResponse {

        private Long id;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        private Long userId;
        private Status status;
        private LocalDate reportDate;
        private String recommendation;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        //    public LessonPlan getLessonPlan() {
//        return lessonPlan;
//    }
//
//    public void setLessonPlan(LessonPlan lessonPlan) {
//        this.lessonPlan = lessonPlan;
//    }
//
//    @ManyToOne
//    private LessonPlan lessonPlan;
        private String weakness;
        private String strength;

        public String getLessonPlanName() {
            return lessonPlanName;
        }

        public void setLessonPlanName(String lessonPlanName) {
            this.lessonPlanName = lessonPlanName;
        }

        private String lessonPlanName;
        public Grades getGrade() {
            return grade;
        }

        public void setGrade(Grades grade) {
            this.grade = grade;
        }

        private Grades grade;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        private String message;



    }


