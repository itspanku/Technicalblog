package com.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer_id {
	@Id
	private int answerId;
	private String answer;

	@ManyToOne
	private Question_id question;
	
	public Answer_id() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer_id(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question_id getQuestion() {
		return question;
	}
	public void setQuestion(Question_id question) {
		this.question = question;
	}
	
	
	
	

}
