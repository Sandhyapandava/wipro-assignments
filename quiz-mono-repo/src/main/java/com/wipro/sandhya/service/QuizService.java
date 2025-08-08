package com.wipro.sandhya.service;

import com.wipro.sandhya.dto.QuizRequest;
import com.wipro.sandhya.dto.QuizResult;
import com.wipro.sandhya.dto.QuizSubmission;
import com.wipro.sandhya.model.Quiz;

public interface QuizService {
    Quiz createQuiz(QuizRequest quizRequest);
    Quiz getQuizById(Long id);
    QuizResult submitQuiz(Long quizId, QuizSubmission submission);
}
