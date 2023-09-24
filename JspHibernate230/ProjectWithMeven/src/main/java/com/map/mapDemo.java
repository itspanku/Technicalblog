package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {
public static void main(String[] args) {
	// creating object for Question_id class
	Question_id q=new Question_id();
	q.setQuestionId(121);
	q.setQuestion("what is java ?");
	
	// creating object for Answer_id class
	Answer_id a=new Answer_id();
	a.setAnswerId(21);
	a.setAnswer("Java is a Programming language");
	a.setQuestion(q);
	
	Answer_id a1=new Answer_id();
	a1.setAnswerId(21);
	a1.setAnswer("By Using Java we can Develop Software");
	a1.setQuestion(q);
	
	List<Answer_id> list=new ArrayList<Answer_id>();
	list.add(a);
	list.add(a1);
	
	
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory factory=cfg.buildSessionFactory();
	
	Session  s=factory.openSession();
	
	Transaction t=s.beginTransaction();
	
	s.save(q);
	s.save(a);
	s.save(a1);
	
	t.commit();
	
	// Fetch the data
	Question_id qi=(Question_id)s.get(Question_id.class, 121);
	System.out.println(qi.getQuestion());
	System.out.println(((Question_id) qi.getAnswer()).getAnswer());
	
}
}
