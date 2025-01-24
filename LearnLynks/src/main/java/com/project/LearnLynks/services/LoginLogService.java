package com.project.LearnLynks.services;

public interface LoginLogService {
    void logLogin(Long id);
    void logLogout(Long id);
    long calculateTotalTimeSpent(Long id);
}
