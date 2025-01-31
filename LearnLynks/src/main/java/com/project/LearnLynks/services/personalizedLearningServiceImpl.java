package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.PersonalizedLearningByUsernameRequest;
import com.project.LearnLynks.dtos.request.PersonalizedLearningRequest;
import com.project.LearnLynks.dtos.response.PersonalizedLearningResponse;
import com.project.LearnLynks.exceptions.UserNotFoundException;
import com.project.LearnLynks.models.LessonPlan;
import com.project.LearnLynks.models.Users;
import com.project.LearnLynks.repositories.LessonPlanRepository;
import com.project.LearnLynks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class personalizedLearningServiceImpl implements PersonalizedLearningService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LessonPlanRepository lessonPlanRepository;


    @Override
    public PersonalizedLearningResponse requestPersonalizedLearningByUsername(PersonalizedLearningByUsernameRequest personalizedLearningRequest) {

        Optional<Users> optionalUsers = userRepository.findByUsername(personalizedLearningRequest.getUsername());
        if (!optionalUsers.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        Users user = optionalUsers.get();
        user.setUsername(personalizedLearningRequest.getUsername());
        userRepository.save(user);
        PersonalizedLearningResponse personalizedLearningResponse = new PersonalizedLearningResponse();
        personalizedLearningResponse.setUsername(user.getUsername());
        personalizedLearningResponse.setPassword(user.getPassword());
        personalizedLearningResponse.setFirstName(user.getFirstName());
        personalizedLearningResponse.setLastName(user.getLastName());
        personalizedLearningResponse.setEmail(user.getEmail());
        return personalizedLearningResponse;
    }

    @Override
    public PersonalizedLearningResponse requestPersonalizedLearningByLessonPlanName(String lessonPlanName, PersonalizedLearningRequest personalizedLearningRequest) {

        Optional<LessonPlan> OptionalLesson = lessonPlanRepository.findByLessonPlanName(lessonPlanName);
        if (!OptionalLesson.isPresent()) {
            throw new IllegalArgumentException("Lesson Plan not found");
        }
        LessonPlan lessonPlan = OptionalLesson.get();
        lessonPlan.setLessonPlanName(personalizedLearningRequest.getLessonPlanName());
        lessonPlanRepository.save(lessonPlan);
        PersonalizedLearningResponse personalizedLearningResponse = new PersonalizedLearningResponse();
        personalizedLearningResponse.setLessonPlanName(lessonPlan.getLessonPlanName());
        return personalizedLearningResponse;
    }
}
