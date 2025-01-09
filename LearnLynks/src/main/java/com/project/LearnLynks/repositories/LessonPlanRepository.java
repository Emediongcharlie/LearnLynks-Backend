package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.LessonPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonPlanRepository extends JpaRepository<LessonPlan, Integer> {

    Optional<LessonPlan> findByLessonPlanId(Integer lessonPlanId);
    Optional<LessonPlan> findByLessonPlanName(String lessonPlanName);

}
