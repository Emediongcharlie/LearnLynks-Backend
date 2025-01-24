package com.project.LearnLynks.dtos.response;

import java.time.LocalDate;

public class GetAssessmentResponse {
        private Long assessmentId;
        private Long id;
        private Long lessonPlanId;
        private LocalDate completionDate;
        private Double averageScore;
        private Double timeSpent;
        private Double totalScore;
        private String grade;

        public Long getAssessmentId() {
            return assessmentId;
        }

        public void setAssessmentId(Long assessmentId) {
            this.assessmentId = assessmentId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getLessonPlanId() {
            return lessonPlanId;
        }

        public void setLessonPlanId(Long lessonPlanId) {
            this.lessonPlanId = lessonPlanId;
        }

        public LocalDate getCompletionDate() {
            return completionDate;
        }

        public void setCompletionDate(LocalDate completionDate) {
            this.completionDate = completionDate;
        }

        public Double getAverageScore() {
            return averageScore;
        }

        public void setAverageScore(Double averageScore) {
            this.averageScore = averageScore;
        }

        public Double getTimeSpent() {
            return timeSpent;
        }

        public void setTimeSpent(Double timeSpent) {
            this.timeSpent = timeSpent;
        }

        public Double getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(Double totalScore) {
            this.totalScore = totalScore;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
}
