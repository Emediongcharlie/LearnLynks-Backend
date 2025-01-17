package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserLoginRequest {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    private Role role;

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
}
