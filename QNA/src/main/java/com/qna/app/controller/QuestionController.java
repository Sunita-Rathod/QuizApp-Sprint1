package com.qna.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qna.app.model.Question;
import com.qna.app.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allquestions")
	public List<Question> getAllQuestions() {
		
		return questionService.getAllQuestions();
		
	}

	  @GetMapping("bycategory/{category}")
	  public List<Question> getQuestionsByCategory(@PathVariable String category)
	  { 
		  return (List<Question>) questionService.questionsByCategory(category);
	  }
	  
		
		@PostMapping("/add") // Create a new question
		public ResponseEntity<String> addQuestion(@RequestBody Question question)
		  { return questionService.addQuestion(question); }

		
		@PutMapping("/update/{id}") // Update a question by ID 
		public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question question) {
			return  questionService.updateQuestion(id, question);
		}

		@DeleteMapping("/delete/{id}") // Delete a question by ID 
		public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
			return questionService.deleteQuestion(id);
		}

	}
