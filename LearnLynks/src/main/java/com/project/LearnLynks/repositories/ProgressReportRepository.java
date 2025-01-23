package com.project.LearnLynks.repositories;

import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;
import com.project.LearnLynks.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressReportRepository extends JpaRepository<ProgressReport, Long> {

   Optional<ProgressReport> findById(Long userId);
}
