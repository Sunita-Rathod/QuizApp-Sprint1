package com.qna.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne()       
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne()       
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    
    private int score;

	public QuizAttempt() {
		super();	}

	public QuizAttempt(int id, User user, Quiz quiz, int score) {
		super();
		this.id = id;
		this.user = user;
		this.quiz = quiz;
		this.score = score;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "QuizAttempt [id=" + id + ", user=" + user + ", quiz=" + quiz + ", score=" + score + "]";
	}
}
