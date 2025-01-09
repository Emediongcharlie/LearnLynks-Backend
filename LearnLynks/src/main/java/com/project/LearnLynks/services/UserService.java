package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.models.Role;
import com.project.LearnLynks.models.Users;

public interface UserService {

    public AddNewStudentResponse registerStudent(UserRegisterRequest userRegisterRequest);

    public AddTeacherResponse registerTeacher(UserRegisterRequest userRegisterRequest);

    public AddParentResponse registerParent(UserRegisterRequest userRegisterRequest);

    public LoginStudentResponse loginStudent(UserLoginRequest userLoginRequest);

    public LoginTeacherResponse loginTeacher(UserLoginRequest userLoginRequest);

    public LoginParentResponse loginParent(UserLoginRequest userLoginRequest);
}
