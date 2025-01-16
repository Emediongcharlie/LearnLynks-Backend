package com.project.LearnLynks.services;


import com.project.LearnLynks.dtos.request.*;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.exceptions.EmailNotFoundException;
import com.project.LearnLynks.exceptions.EmailSendingException;
import com.project.LearnLynks.exceptions.UsernameNotFoundException;
import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProgressReportServiceImpl progressReportService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailService emailService;


    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) throws MessagingException {
        Users user = new Users();
        validateEmail(userRegisterRequest.getEmail());

        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        user.setUsername(userRegisterRequest.getUsername());
        user.setRole(userRegisterRequest.getRole());
//        String subject = "Student Registration";
//        String body = "Welcome to our platform " + userRegisterRequest.getFirstName() + ", \n Your success is our concern";
//
//        emailService.sendEmail(userRegisterRequest.getEmail(), subject, body);
        userRepository.save(user);
        System.out.println("Saved user: " + user);

        UserRegisterResponse response = new UserRegisterResponse();
        response.setId(user.getId());
//        response.setFirstName(user.getFirstName());
//        response.setLastName(user.getLastName());
//        response.setEmail(user.getEmail());
//        response.setUsername(user.getUsername());
//        response.setPassword(user.getPassword());
//        response.setRole(user.getRole());
        response.setMessage("Successfully registered " + user.getFirstName() + " " + user.getLastName() + " as " + user.getRole());
        return response;
    }
    public LoginUserResponse login(UserLoginRequest userLoginRequest) {

        Users user = userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!userLoginRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setUsername(user.getUsername());
        loginUserResponse.setMessage("Successfully logged in " +user.getUsername() + " as " + user.getRole());
        return loginUserResponse;
    }

    @Override
    public UpdateUserDetailsResponse updateUser(UpdateUserDetailsRequest updateUserDetailsRequest) {
        Users users = userRepository.findByUsername(updateUserDetailsRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
        if (!updateUserDetailsRequest.getPassword().equals(users.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        users.setFirstName(updateUserDetailsRequest.getFirstName());
        users.setLastName(updateUserDetailsRequest.getLastName());
        users.setEmail(updateUserDetailsRequest.getEmail());
        users.setPassword(updateUserDetailsRequest.getPassword());
        users.setUsername(updateUserDetailsRequest.getUsername());
        users.setRole(updateUserDetailsRequest.getRole());
        userRepository.save(users);
        UpdateUserDetailsResponse response = new UpdateUserDetailsResponse();
        response.setFirstName(users.getFirstName());
        response.setLastName(users.getLastName());
        response.setEmail(users.getEmail());
        response.setPassword(users.getPassword());
        response.setRole(users.getRole());
        response.setUsername(users.getUsername());
        response.setMessage("users details updated successfully");
        return response;
    }


    public void validateEmail(String email) {
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if (optionalUsers.isPresent()) {
            throw new EmailNotFoundException("Email Present already");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public void validateUsername(String username) {
        Optional<Users> optionalUsers = userRepository.findByUsername(username);
        if (!optionalUsers.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    public void sendEmailToRegisteredUsers(String to, String subject, String body) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("emediongcharlie@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
            mailSender.send(mailMessage);
    }catch(Exception e){
        throw new EmailSendingException("Failed to sent email");}
    }

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("Failed to send email to " + to, e);
        }
    }


}
