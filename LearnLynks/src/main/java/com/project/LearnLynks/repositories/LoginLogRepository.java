package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
    List<LoginLog> findByUser_Id(Long id);
    Optional<LoginLog> findFirstByUser_IdOrderByLoginTimeDesc(Long id);
}
