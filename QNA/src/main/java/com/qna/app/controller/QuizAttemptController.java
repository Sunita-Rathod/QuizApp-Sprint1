package com.qna.app.controller;

import com.qna.app.model.QuizAttempt;
import com.qna.app.service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-attempts")
public class QuizAttemptController {

	@Autowired
    private  QuizAttemptService quizAttemptService;

    @GetMapping("/listquizattempts")
    public ResponseEntity<List<QuizAttempt>> getAllQuizAttempts() {
        List<QuizAttempt> quizAttempts = quizAttemptService.getAllQuizAttempts();
        return new ResponseEntity<>(quizAttempts, HttpStatus.OK);
    }

    @GetMapping("/quizattemptbyid/{id}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable int id) {
        return quizAttemptService.getQuizAttemptById(id)
                .map(quizAttempt -> new ResponseEntity<>(quizAttempt, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createquizattempt")
    public ResponseEntity<QuizAttempt> createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        QuizAttempt createdQuizAttempt = quizAttemptService.saveQuizAttempt(quizAttempt);
        return new ResponseEntity<>(createdQuizAttempt, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletequizattempt/{id}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable int id) {
        quizAttemptService.deleteQuizAttempt(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

