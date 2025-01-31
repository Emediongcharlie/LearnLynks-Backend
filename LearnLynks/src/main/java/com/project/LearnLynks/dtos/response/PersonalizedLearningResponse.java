package com.project.LearnLynks.dtos.response;

import com.project.LearnLynks.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PersonalizedLearningResponse {

        private String firstName;
        private String lastName;
        private String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        private String username;


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;
        private String LessonPlanName;

        public String getLessonPlanName() {
            return LessonPlanName;
        }

        public void setLessonPlanName(String lessonPlanName) {
            LessonPlanName = lessonPlanName;
        }
    }


