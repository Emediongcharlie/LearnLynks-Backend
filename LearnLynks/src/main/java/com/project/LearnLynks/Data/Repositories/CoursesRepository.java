package com.project.LearnLynks.Data.Repositories;

import com.project.LearnLynks.Data.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
