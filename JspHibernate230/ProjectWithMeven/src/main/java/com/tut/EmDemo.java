package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(22);
		student1.setName("Ankit");
		student1.setCity("Lakhnaw");
		
		Certificate certificate=new Certificate();
		certificate.setCource("Andoride");
		certificate.setDuration("1 month");
		System.out.println(certificate);
		
		student1.setCerti(certificate);
		
		Student student2=new Student();
		student2.setId(23);
		student2.setName("Ravi");
		student2.setCity("Bhopal");
		
		Certificate certificate1=new Certificate();
		certificate1.setCource("Hibernate");
		certificate1.setDuration("2 month");
		System.out.println(certificate1);
		
		student2.setCerti(certificate1);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		// objects save
		
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
		
	}

}
