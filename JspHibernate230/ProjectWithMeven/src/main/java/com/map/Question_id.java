package com.map;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question_id {
	@Id
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy = "question")
	private List<Answer_id> answer;
	
	
	public Question_id() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer_id> getAnswer() {
		return answer;
	}

	public void setAnswer(Answer_id answer) {
		this.answer = (List<Answer_id>) answer;
	}

	public Question_id(int questionId, String question, List<Answer_id> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}
	
	

}
