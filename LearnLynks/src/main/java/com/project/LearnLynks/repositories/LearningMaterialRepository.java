package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.LearningMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningMaterialRepository extends JpaRepository<LearningMaterial, Long> {

    LearningMaterial findByName(String name);
}
