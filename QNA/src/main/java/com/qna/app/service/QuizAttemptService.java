package com.qna.app.service;

import com.qna.app.dao.QuizAttemptDao;
import com.qna.app.model.QuizAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAttemptService {
	@Autowired
	private QuizAttemptDao quizAttemptDao;

    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptDao.findAll();
    }

    public Optional<QuizAttempt> getQuizAttemptById(int id) {
        return quizAttemptDao.findById(id);
    }

    public QuizAttempt saveQuizAttempt(QuizAttempt quizAttempt) {
        return quizAttemptDao.save(quizAttempt);
    }

    public void deleteQuizAttempt(int id) {
    	quizAttemptDao.deleteById(id);
    }

    public QuizAttempt updateQuizAttempt(int id, QuizAttempt updatedQuizAttempt) {
        if (quizAttemptDao.existsById(id)) {
            updatedQuizAttempt.setId(id);
            return quizAttemptDao.save(updatedQuizAttempt);
        } else {
            throw new IllegalArgumentException("QuizAttempt with ID " + id + " does not exist.");
        }
    }
}

