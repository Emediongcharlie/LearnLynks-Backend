package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.PersonalizedLearningByUsernameRequest;
import com.project.LearnLynks.dtos.request.PersonalizedLearningRequest;
import com.project.LearnLynks.dtos.response.PersonalizedLearningResponse;

public interface PersonalizedLearningService {

    PersonalizedLearningResponse requestPersonalizedLearningByUsername(PersonalizedLearningByUsernameRequest personalizedLearningRequest);
    PersonalizedLearningResponse requestPersonalizedLearningByLessonPlanName(String lessonPlanName, PersonalizedLearningRequest personalizedLearningRequest);
}
