package com.qna.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qna.app.model.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


	//List<Question> getAllQuestions();    // for all q.
	  
	Question findById(int id);
	  
	Question deleteById(int id);
	
		
   List <Question> findByCategory(String category);
		  
		  
	//@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT=:numQ", nativeQuery = true)
	//List<Question> findRandomQuestionsByCategory(String category, int numQ);
   
   @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
   
   List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
