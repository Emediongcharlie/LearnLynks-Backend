package com.project.LearnLynks.dtos.response;

public class UpdateLessonPlanResponse {

        private int lessonPlanId;
        private String lessonPlanName;

        public String getLessonPlanDescription() {
            return lessonPlanDescription;
        }

        public void setLessonPlanDescription(String lessonPlanDescription) {
            this.lessonPlanDescription = lessonPlanDescription;
        }

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

        public String getLessonPlanStartDate() {
            return lessonPlanStartDate;
        }

        public void setLessonPlanStartDate(String lessonPlanStartDate) {
            this.lessonPlanStartDate = lessonPlanStartDate;
        }

        public String getLessonPlanEndDate() {
            return lessonPlanEndDate;
        }

        public void setLessonPlanEndDate(String lessonPlanEndDate) {
            this.lessonPlanEndDate = lessonPlanEndDate;
        }

        public String getLessonPlanDuration() {
            return lessonPlanDuration;
        }

        public void setLessonPlanDuration(String lessonPlanDuration) {
            this.lessonPlanDuration = lessonPlanDuration;
        }

        public String getLessonPlanStatus() {
            return lessonPlanStatus;
        }

        public void setLessonPlanStatus(String lessonPlanStatus) {
            this.lessonPlanStatus = lessonPlanStatus;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        private String lessonPlanDescription;
        private String lessonPlanStartDate;
        private String lessonPlanEndDate;
        private String lessonPlanDuration;
        private String lessonPlanStatus;
        private String message;
    }

