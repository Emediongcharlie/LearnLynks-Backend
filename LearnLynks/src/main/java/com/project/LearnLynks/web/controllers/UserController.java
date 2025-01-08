package com.project.LearnLynks.web.controllers;

import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @PostMapping("/register/parent")
    public Users registration(@RequestBody Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    @PostMapping("/register/student")
    public Users registrationStudent(@RequestBody Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    @GetMapping("/login")
    public String login(){
        return "custom_login";
    }

}
