package com.project.LearnLynks.dtos.request;

import com.project.LearnLynks.models.Users;

public class SearchProgressReportRequest {

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    private Users user;
}
