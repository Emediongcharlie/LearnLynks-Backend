package com.project.LearnLynks.repositories;

import com.project.LearnLynks.dtos.response.ProgressReportResponse;
import com.project.LearnLynks.models.ProgressReport;
import com.project.LearnLynks.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ProgressReportRepository extends JpaRepository<ProgressReport, Long> {
    ProgressReport findById(long id);
    List<ProgressReport> findByUsersId(Long usersId);

   Optional<ProgressReport> findById(Long userId);

}
