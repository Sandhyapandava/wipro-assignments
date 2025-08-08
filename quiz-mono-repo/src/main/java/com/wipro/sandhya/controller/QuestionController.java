
package com.wipro.sandhya.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.sandhya.model.Question;
import com.wipro.sandhya.model.enums.Category;
import com.wipro.sandhya.model.enums.DifficultyLevel;
import com.wipro.sandhya.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

	private final QuestionService questionService;

	@PostMapping
	public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question) {
		return ResponseEntity.ok(questionService.addQuestion(question));
	}

	@GetMapping
	public ResponseEntity<Page<Question>> getAllQuestions(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(questionService.getAllQuestions(pageable));
	}

	@GetMapping("/filter")
	public ResponseEntity<List<Question>> getByCategoryAndDifficulty(@RequestParam Category category,
			@RequestParam DifficultyLevel difficulty) {
		return ResponseEntity.ok(questionService.getQuestionsByCategoryAndDifficulty(category, difficulty));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question partialQuestion) {
		return ResponseEntity.ok(questionService.updateQuestionPartially(id, partialQuestion));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestion(id);
		return ResponseEntity.ok("Question deleted successfully.");
	}
}
