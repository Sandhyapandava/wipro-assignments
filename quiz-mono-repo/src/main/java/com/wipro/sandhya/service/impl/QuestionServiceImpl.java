package com.wipro.sandhya.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.sandhya.exception.ResourceNotFoundException;
import com.wipro.sandhya.model.Question;
import com.wipro.sandhya.model.enums.Category;
import com.wipro.sandhya.model.enums.DifficultyLevel;
import com.wipro.sandhya.repository.QuestionRepository;
import com.wipro.sandhya.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public List<Question> getQuestionsByCategoryAndDifficulty(Category category, DifficultyLevel difficultyLevel) {
        return questionRepository.findByCategoryAndDifficultyLevel(category, difficultyLevel);
    }

    @Override
    public Question updateQuestionPartially(Long id, Question partial) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        if (partial.getQuestionTitle() != null) question.setQuestionTitle(partial.getQuestionTitle());
        if (partial.getOption1() != null) question.setOption1(partial.getOption1());
        if (partial.getOption2() != null) question.setOption2(partial.getOption2());
        if (partial.getOption3() != null) question.setOption3(partial.getOption3());
        if (partial.getOption4() != null) question.setOption4(partial.getOption4());
        if (partial.getCorrectAnswer() != null) question.setCorrectAnswer(partial.getCorrectAnswer());
        if (partial.getDifficultyLevel() != null) question.setDifficultyLevel(partial.getDifficultyLevel());
        if (partial.getCategory() != null) question.setCategory(partial.getCategory());

        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Question not found with id: " + id);
        }
        questionRepository.deleteById(id);
    }
}