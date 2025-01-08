package com.project.LearnLynks.Data.Repositories;

import com.project.LearnLynks.Data.Models.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
}
