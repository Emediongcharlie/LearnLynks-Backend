package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.UserLoginRequest;
import com.project.LearnLynks.dtos.request.UserRegisterRequest;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.UserRepository;
import com.project.LearnLynks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/teacher/home")
    public String adminHomePage(){
        return "admin";
    }

    @GetMapping("/student/home")
    public String studentHomePage(){
        return "student";
    }

    @GetMapping("/parent/home")
    public String parentHomePage(){
        return "parent";
    }
//
//    @PostMapping("/register/parent")
//    public Users registration(@RequestBody Users users){
//        users.setPassword(passwordEncoder.encode(users.getPassword()));
//        return userRepository.save(users);
//    }
//
//    @PostMapping("/register/student")
//    public Users registrationStudent(@RequestBody Users users){
//        users.setPassword(passwordEncoder.encode(users.getPassword()));
//        return userRepository.save(users);
//    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        return "login";
    }




    @PostMapping("/register-student")
    public ResponseEntity<?> registrationStudent(@RequestBody UserRegisterRequest request){
        try{
            AddNewStudentResponse response = userService.registerStudent(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/student-login")
    public ResponseEntity<?> loginStudents(@RequestBody UserLoginRequest request){
        try{
            LoginStudentResponse response = userService.loginStudent(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register-teacher")
    public ResponseEntity<?> registrationTeachers(@RequestBody UserRegisterRequest request){
        try{
            AddTeacherResponse response = userService.registerTeacher(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/teacher-login")
    public ResponseEntity<?> loginTeachers(@RequestBody UserLoginRequest request){
        try{
            LoginTeacherResponse response = userService.loginTeacher(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register-parent")
    public ResponseEntity<?> registrationParents(@RequestBody UserRegisterRequest request){
        try{
            AddParentResponse response = userService.registerParent(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/parent-login")
    public ResponseEntity<?> loginParent(@RequestBody UserLoginRequest request){
        try{
            LoginParentResponse response = userService.loginParent(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
