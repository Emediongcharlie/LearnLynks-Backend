package com.project.LearnLynks.Web.controllers;

import com.project.LearnLynks.dtos.request.UpdateUserDetailsRequest;
import com.project.LearnLynks.dtos.request.UserLoginRequest;
import com.project.LearnLynks.dtos.request.UserRegisterRequest;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.repositories.UserRepository;
import com.project.LearnLynks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password){
//        return "login";
//    }




//    @PostMapping("/register")
//    public ResponseEntity<?> registrationUsers(@RequestBody UserRegisterRequest request){
//        try{
//            UserRegisterResponse response = userService.registerUser(request);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } catch(Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        try {
            UserRegisterResponse response = userService.registerUser(userRegisterRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request){
        try{
            LoginUserResponse response = userService.login(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public LogoutUserResponse logout(@RequestParam Long id) {
        return userService.logout(id);
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDetailsRequest request){
        try{
            UpdateUserDetailsResponse updateDetails = userService.updateUser(request);
            return new ResponseEntity<>(updateDetails, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
