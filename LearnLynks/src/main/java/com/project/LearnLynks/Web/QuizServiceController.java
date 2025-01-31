package com.project.LearnLynks.Web;

import com.project.LearnLynks.dtos.request.CreateQuizRequest;
import com.project.LearnLynks.dtos.response.CreateQuizResponse;
import com.project.LearnLynks.dtos.response.GetQuizResponse;
import com.project.LearnLynks.dtos.response.QuizResponse;
import com.project.LearnLynks.dtos.response.UpdateQuizResponse;
import com.project.LearnLynks.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quizzes")
public class QuizServiceController {

    private final QuizService quizService;

    @Autowired
    private QuizServiceController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create-quiz")
    public CreateQuizResponse createQuiz(@RequestBody CreateQuizRequest createQuizRequest, String userAnswer) {
        return quizService.createQuiz(createQuizRequest, userAnswer);
    }

    @GetMapping("/{quizId}")
    public GetQuizResponse getQuizById(@PathVariable Long quizId) {
        return quizService.getQuizById(quizId);
    }

    @GetMapping("get-all-quizzes")
    public List<CreateQuizResponse> getAllQuizzes(String userAnswer) {
        return quizService.getAllQuizzes(userAnswer);
    }

    @PutMapping("/update")
    public UpdateQuizResponse updateQuiz(Long quizId) {
        return quizService.updateQuiz(quizId);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteQuiz(quizId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
