package com.project.LearnLynks.services;

import com.project.LearnLynks.dtos.request.CreateQuizRequest;
import com.project.LearnLynks.dtos.response.*;
import com.project.LearnLynks.models.Quiz;
import com.project.LearnLynks.models.TriviaQuestion;
import com.project.LearnLynks.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public CreateQuizResponse createQuiz(CreateQuizRequest createQuizRequest, String userAnswer) {
        Quiz quiz = new Quiz();
        quiz.setQuestion(createQuizRequest.getQuestion());
        quiz.setOption1(createQuizRequest.getOption1());
        quiz.setOption2(createQuizRequest.getOption2());
        quiz.setOption3(createQuizRequest.getOption3());
        quiz.setCorrectAnswer(createQuizRequest.getCorrectAnswer());

        Quiz saved = quizRepository.save(quiz);

        return mapToCreateQuizResponse(saved, userAnswer);
    }

    @Override
    public GetQuizResponse getQuizById(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with ID: " + quizId));
        return mapToGetQuizResponse(quiz);
    }

    @Override
    public List<CreateQuizResponse> getAllQuizzes(String userAnswer) {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quiz -> mapToCreateQuizResponse(quiz, userAnswer))
                .collect(Collectors.toList());
    }

    @Override
    public UpdateQuizResponse updateQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with ID: " + quizId));
        return mapToUpdateQuizResponse(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    private CreateQuizResponse mapToCreateQuizResponse(Quiz quiz, String userAnswer) {
        CreateQuizResponse response = new CreateQuizResponse();
        response.setQuestion(quiz.getQuestion());
        response.setOption1(quiz.getOption1());
        response.setOption2(quiz.getOption2());
        response.setOption3(quiz.getOption3());
        response.setOption4(quiz.getOption4());
        boolean isCorrect = quiz.getCorrectAnswer().equalsIgnoreCase(userAnswer);
        response.setAnswer(isCorrect);
        response.setCorrectAnswer(quiz.getCorrectAnswer());
        return response;
    }

    private GetQuizResponse mapToGetQuizResponse(Quiz quiz) {
        GetQuizResponse response = new GetQuizResponse();
        response.setQuestion(quiz.getQuestion());
        response.setOption1(quiz.getOption1());
        response.setOption2(quiz.getOption2());
        response.setOption3(quiz.getOption3());
        response.setOption4(quiz.getOption4());
        response.setCorrectAnswer(quiz.getCorrectAnswer());

        return response;
    }

    private UpdateQuizResponse mapToUpdateQuizResponse(Quiz quiz) {
        UpdateQuizResponse response = new UpdateQuizResponse();
        response.setQuestion(quiz.getQuestion());
        response.setOption1(quiz.getOption1());
        response.setOption3(quiz.getOption3());
        response.setOption4(quiz.getOption4());
        response.setCorrectAnswer(quiz.getCorrectAnswer());

        return response;
    }
}
