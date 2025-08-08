package com.wipro.sandhya.dto;

import lombok.Data;

import java.util.Map;

@Data
public class QuizSubmission {
    // key: questionId, value: chosen answer
    private Map<Long, String> answers;
}
