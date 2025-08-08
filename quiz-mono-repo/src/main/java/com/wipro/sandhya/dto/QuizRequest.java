package com.wipro.sandhya.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizRequest {
    private String quizTitle;
    private List<Long> questionIds;
}
