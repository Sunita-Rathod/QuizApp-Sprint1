package com.qna.app.dao;

import com.qna.app.model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAttemptDao extends JpaRepository<QuizAttempt, Integer> {

    // Define additional query methods if needed

}
