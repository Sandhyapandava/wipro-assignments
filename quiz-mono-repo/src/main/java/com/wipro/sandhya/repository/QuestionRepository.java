package com.wipro.sandhya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.sandhya.model.Question;
import com.wipro.sandhya.model.enums.Category;
import com.wipro.sandhya.model.enums.DifficultyLevel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel);

	Page<Question> findAll(Pageable pageable);
}