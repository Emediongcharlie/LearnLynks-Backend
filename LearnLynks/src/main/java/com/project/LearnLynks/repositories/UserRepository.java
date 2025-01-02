package com.project.LearnLynks.repositories;

import com.project.LearnLynks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
