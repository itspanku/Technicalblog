package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class State_Demo {
	public static void main(String[] args) {
		// Practical of Hibernate Object Status
		// Transient state
		// Persistence state
		// Detached state
		// Remove state
		
		System.out.println("Example");
		SessionFactory f=new Configuration().configure().buildSessionFactory();
		
		//creating student object:
		Student stu=new Student();
		stu.setId(12);
		stu.setName("peter");
		stu.setCity("ABC");
		stu.setCerti(new Certificate("java hibernate cource","2 months"));
		//student : Transient
		
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		s.save(stu);
		
		//student : Persistence - session, database :
		stu.setName("john");
		
		t.commit();
		s.close();
		
		//student : Detached :
		stu.setName("sachin");
		System.out.println(stu);
		
		f.close();
	}

}
