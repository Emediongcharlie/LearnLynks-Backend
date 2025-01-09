package com.project.LearnLynks.Data.Repositories;

import com.project.LearnLynks.Data.Models.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
    Optional<Curriculum> findByName(String name);
}
