
package com.wipro.sandhya.model;

import com.wipro.sandhya.model.enums.Category;
import com.wipro.sandhya.model.enums.DifficultyLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question title must not be blank")
    private String questionTitle;

    @NotBlank(message = "Option1 must not be blank")
    private String option1;

    @NotBlank(message = "Option2 must not be blank")
    private String option2;

    @NotBlank(message = "Option3 must not be blank")
    private String option3;

    @NotBlank(message = "Option4 must not be blank")
    private String option4;

    @NotBlank(message = "Correct answer must not be blank")
    private String correctAnswer;

    @NotNull(message = "Difficulty level must be provided")
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @NotNull(message = "Category must be provided")
    @Enumerated(EnumType.STRING)
    private Category category;
}
