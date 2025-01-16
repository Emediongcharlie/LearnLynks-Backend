package com.project.LearnLynks.Services;


import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.exceptions.EmailNotFoundException;
import com.project.LearnLynks.exceptions.UsernameNotFoundException;
import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static com.project.LearnLynks.models.Role.*;

@Service
public class UserServiceImpl implements com.project.LearnLynks.services.UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddNewStudentResponse registerStudent(UserRegisterRequest userRegisterRequest) {
        Users user = new Users();
        boolean isStudent = userRegisterRequest.getRole() == STUDENT;
        if(isStudent){
            validateEmail(userRegisterRequest.getEmail());
            user.setRole(STUDENT);
            user.setFirstName(userRegisterRequest.getFirstName());
            user.setLastName(userRegisterRequest.getLastName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            user.setUsername(userRegisterRequest.getUsername());
            userRepository.save(user);

        };
        AddNewStudentResponse addNewStudentResponse = new AddNewStudentResponse();
        addNewStudentResponse.setId(user.getId());
        addNewStudentResponse.setFirstName(user.getFirstName());
        addNewStudentResponse.setLastName(user.getLastName());
        addNewStudentResponse.setEmail(user.getEmail());
        addNewStudentResponse.setUsername(user.getUsername());
        addNewStudentResponse.setPassword(user.getPassword());
        addNewStudentResponse.setRole(user.getRole());
        addNewStudentResponse.setMessage("Successfully registered " + user.getFirstName() + " " + user.getLastName() + " as " + user.getRole());
        return addNewStudentResponse;
    }

    @Override
    public AddTeacherResponse registerTeacher(UserRegisterRequest userRegisterRequest) {
        Users user = new Users();
        boolean isStudent = userRegisterRequest.getRole() == TEACHER;
        if(isStudent){
            validateEmail(userRegisterRequest.getEmail());
            user.setRole(STUDENT);
            user.setFirstName(userRegisterRequest.getFirstName());
            user.setLastName(userRegisterRequest.getLastName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            user.setUsername(userRegisterRequest.getUsername());
            userRepository.save(user);


        };
        AddTeacherResponse addTeacherResponse = new AddTeacherResponse();
        addTeacherResponse.setId(user.getId());
        addTeacherResponse.setFirstName(user.getFirstName());
        addTeacherResponse.setLastName(user.getLastName());
        addTeacherResponse.setEmail(user.getEmail());
        addTeacherResponse.setUsername(user.getUsername());
        addTeacherResponse.setPassword(user.getPassword());
        addTeacherResponse.setRole(user.getRole());
        addTeacherResponse.setMessage("Successfully registered " + user.getFirstName() + " " + user.getLastName() + " as " + user.getRole());
        return addTeacherResponse;
    }

    @Override
    public AddParentResponse registerParent(UserRegisterRequest userRegisterRequest) {
        Users user = new Users();
        boolean isStudent = userRegisterRequest.getRole() == PARENT;
        if(isStudent){
            validateEmail(userRegisterRequest.getEmail());
            user.setRole(STUDENT);
            user.setFirstName(userRegisterRequest.getFirstName());
            user.setLastName(userRegisterRequest.getLastName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setPassword(userRegisterRequest.getPassword());
            user.setUsername(userRegisterRequest.getUsername());
            userRepository.save(user);

        };
        AddParentResponse addParentResponse = new AddParentResponse();
        addParentResponse.setId(user.getId());
        addParentResponse.setFirstName(user.getFirstName());
        addParentResponse.setLastName(user.getLastName());
        addParentResponse.setEmail(user.getEmail());
        addParentResponse.setUsername(user.getUsername());
        addParentResponse.setPassword(user.getPassword());
        addParentResponse.setRole(user.getRole());
        addParentResponse.setMessage("Successfully registered " + user.getFirstName() + " " + user.getLastName() + " as " + user.getRole());
        return addParentResponse;
    }

    @Override
    public LoginStudentResponse loginStudent(UserLoginRequest userLoginRequest) {
        Users user = new Users();
        boolean isStudent = userLoginRequest.getRole() == STUDENT;
        if(isStudent) {
            validateUsername(userLoginRequest.getUsername());
            user.setUsername(userLoginRequest.getUsername());
            user.setPassword(userLoginRequest.getPassword());
            userRepository.save(user);

        }
        LoginStudentResponse loginStudentResponse = new LoginStudentResponse();
        loginStudentResponse.setUsername(user.getUsername());
        loginStudentResponse.setMessage("Successfully logged in " + user.getUsername());
        return loginStudentResponse;
    }

    @Override
    public LoginTeacherResponse loginTeacher(UserLoginRequest userLoginRequest) {
        Users user = new Users();
        boolean isStudent = userLoginRequest.getRole() == STUDENT;
        if(isStudent) {
            validateUsername(userLoginRequest.getUsername());
            user.setUsername(userLoginRequest.getUsername());
            user.setPassword(userLoginRequest.getPassword());
            userRepository.save(user);

        }
        LoginTeacherResponse loginTeacherResponse = new LoginTeacherResponse();
        loginTeacherResponse.setUsername(user.getUsername());
        loginTeacherResponse.setMessage("Successfully logged in " + user.getUsername());
        return loginTeacherResponse;
    }

    @Override
    public LoginParentResponse loginParent(UserLoginRequest userLoginRequest) {
        Users user = new Users();
        boolean isStudent = userLoginRequest.getRole() == STUDENT;
        if(isStudent) {
            validateUsername(userLoginRequest.getUsername());
            user.setUsername(userLoginRequest.getUsername());
            user.setPassword(userLoginRequest.getPassword());
            userRepository.save(user);

        }
        LoginParentResponse loginParentResponse = new LoginParentResponse();
        loginParentResponse.setUsername(user.getUsername());
        loginParentResponse.setMessage("Successfully logged in " + user.getUsername());
        return loginParentResponse;
    }

    public void validateEmail(String email) {
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if (optionalUsers.isPresent()) {
            throw new EmailNotFoundException("Email Present already");
        }
    }

    public void validateUsername(String username) {
        Optional<Users> optionalUsers = userRepository.findByUsername(username);
        if (!optionalUsers.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }
    }


}
