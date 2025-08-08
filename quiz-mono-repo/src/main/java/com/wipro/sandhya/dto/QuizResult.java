package com.wipro.sandhya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResult {
    private int totalQuestions;
    private int correctAnswers;
    private int scorePercentage;
}
