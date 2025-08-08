package com.wipro.sandhya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.sandhya.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
