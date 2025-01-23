package com.project.LearnLynks.dtos.response;

import com.project.LearnLynks.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRegisterResponse {

        private Long id;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private Role role;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    private String message;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }


    }

