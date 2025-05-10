package com.project.LearnLynks.services;

import com.project.LearnLynks.models.LoginLog;
import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginLogServiceImpl implements LoginLogService{

    @Autowired
    private LoginLogRepository loginLogRepository;

    @Override
    public void logLogin(Long id) {
        LoginLog log = new LoginLog();
        Users user = new Users();
        user.setId(id);
        log.setUser(user);
        log.setLoginTime(LocalDateTime.now());
        loginLogRepository.save(log);
    }

    @Override
    public void logLogout(Long id) {
        LoginLog log = loginLogRepository.findFirstByUser_IdOrderByLoginTimeDesc(id)
                .orElseThrow(() -> new RuntimeException("No active login session found"));
        log.setLogoutTime(LocalDateTime.now());
        loginLogRepository.save(log);
    }

    @Override
    public long calculateTotalTimeSpent(Long id) {
        List<LoginLog> logs = loginLogRepository.findByUser_Id(id);
        long totalTime = 0;

        for (LoginLog log : logs) {
            if (log.getLogoutTime() != null) {
                Duration duration = Duration.between(log.getLoginTime(), log.getLogoutTime());
                totalTime += duration.toHours();
            }
        }
        return totalTime;
    }
}
