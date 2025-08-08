package com.wipro.sandhya.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.wipro.sandhya.dto.QuizRequest;
import com.wipro.sandhya.dto.QuizResult;
import com.wipro.sandhya.dto.QuizSubmission;
import com.wipro.sandhya.exception.ResourceNotFoundException;
import com.wipro.sandhya.model.Question;
import com.wipro.sandhya.model.Quiz;
import com.wipro.sandhya.repository.QuestionRepository;
import com.wipro.sandhya.repository.QuizRepository;
import com.wipro.sandhya.service.QuizService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Quiz createQuiz(QuizRequest quizRequest) {
        List<Question> questions = questionRepository.findAllById(quizRequest.getQuestionIds());

        if (questions.isEmpty()) {
            throw new ResourceNotFoundException("No questions found for provided IDs");
        }

        Quiz quiz = Quiz.builder()
                .quizTitle(quizRequest.getQuizTitle())
                .questions(questions)
                .build();

        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));
    }

    @Override
    public QuizResult submitQuiz(Long quizId, QuizSubmission submission) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + quizId));

        int totalQuestions = quiz.getQuestions().size();
        int correctAnswers = 0;

        for (Question q : quiz.getQuestions()) {
            String submittedAnswer = submission.getAnswers().get(q.getId());
            if (submittedAnswer != null && submittedAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        int scorePercentage = (int) (((double) correctAnswers / totalQuestions) * 100);

        return new QuizResult(totalQuestions, correctAnswers, scorePercentage);
    }
}
