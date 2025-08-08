package com.wipro.sandhya.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.sandhya.model.Question;
import com.wipro.sandhya.model.enums.Category;
import com.wipro.sandhya.model.enums.DifficultyLevel;

public interface QuestionService {
    Question addQuestion(Question question);
    Page<Question> getAllQuestions(Pageable pageable);
    List<Question> getQuestionsByCategoryAndDifficulty(Category category, DifficultyLevel difficultyLevel);
    Question updateQuestionPartially(Long id, Question partialQuestion);
    void deleteQuestion(Long id);
}