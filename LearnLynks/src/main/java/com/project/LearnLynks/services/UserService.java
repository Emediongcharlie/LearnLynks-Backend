package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.response.AddNewStudentResponse;
import com.project.LearnLynks.models.Users;

public interface UserService {

    public AddNewStudentResponse addStudent(Users user);
}
