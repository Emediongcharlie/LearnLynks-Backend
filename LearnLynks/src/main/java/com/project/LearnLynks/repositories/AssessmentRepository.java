package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    Optional<Assessment> findById(Long id);
}
