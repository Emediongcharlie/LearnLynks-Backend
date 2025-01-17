package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
import jakarta.mail.MessagingException;

public interface UserService {

    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) throws MessagingException;

    public LoginUserResponse login(UserLoginRequest userLoginRequest);

    public UpdateUserDetailsResponse updateUser(UpdateUserDetailsRequest updateUserDetailsRequest);
}
