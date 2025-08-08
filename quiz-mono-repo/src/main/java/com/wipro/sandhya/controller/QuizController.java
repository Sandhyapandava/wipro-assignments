package com.wipro.sandhya.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.sandhya.dto.QuizRequest;
import com.wipro.sandhya.dto.QuizResult;
import com.wipro.sandhya.dto.QuizSubmission;
import com.wipro.sandhya.model.Quiz;
import com.wipro.sandhya.service.QuizService;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizRequest quizRequest) {
        return ResponseEntity.ok(quizService.createQuiz(quizRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<QuizResult> submitQuiz(
            @PathVariable Long id,
            @RequestBody QuizSubmission submission) {
        return ResponseEntity.ok(quizService.submitQuiz(id, submission));
    }
}
