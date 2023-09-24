package org.jsp.onetomanyuni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Answer;
import org.jsp.onetomanyuni.dto.Question;

public class SaveQuestionAndAnswer {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	    EntityTransaction transaction=manager.getTransaction();
	    
	    Question q1=new Question();
	    q1.setQuestion("What is Hibernate");
	    q1.setQuestionby("Allen");
	    
	    Answer a1=new Answer();
	    a1.setAnswer("hibernate is a framework");
	    a1.setAnswerby("meena");
	    
	    Answer a2=new Answer();
	    a2.setAnswer("hibernate is a opensource, lightweight framework");
	    a2.setAnswerby("jefox");
	    
	    Answer a3=new Answer();
	    a3.setAnswer("hibernate support automatic table creation");
	    a3.setAnswerby("zoff");
	    
	    List<Answer> answers=new ArrayList<Answer>();
	    answers.add(a1);
	    answers.add(a2);
	    answers.add(a3);
	    
	    q1.setAnswers(answers);
	   
	    
	    manager.persist(q1);
	    transaction.begin();
	    transaction.commit();
	}

}
