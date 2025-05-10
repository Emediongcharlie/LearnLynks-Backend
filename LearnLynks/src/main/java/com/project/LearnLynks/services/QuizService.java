package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateQuizRequest;
import com.project.LearnLynks.dtos.response.CreateQuizResponse;
import com.project.LearnLynks.dtos.response.GetQuizResponse;
import com.project.LearnLynks.dtos.response.QuizResponse;
import com.project.LearnLynks.dtos.response.UpdateQuizResponse;

import java.util.List;

public interface QuizService {
     CreateQuizResponse createQuiz(CreateQuizRequest createQuizRequest, String userAnswer);
     GetQuizResponse getQuizById(Long quizId);
     List<CreateQuizResponse> getAllQuizzes(String userAnswer);
     UpdateQuizResponse updateQuiz(Long quizId);
     boolean checkAnswer(Long id, String userAnswer);
     Double calculateScore(List<Long> quizIds, List<String> userAnswers);
     void deleteQuiz(Long quizId);
}
