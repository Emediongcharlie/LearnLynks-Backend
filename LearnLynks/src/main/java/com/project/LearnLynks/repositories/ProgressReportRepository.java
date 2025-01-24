package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.ProgressReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressReportRepository extends JpaRepository<ProgressReport, Long> {
    ProgressReport findById(long id);
    List<ProgressReport> findByUsersId(Long usersId);
}
