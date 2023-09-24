package org.jsp.manytomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class SaveBatchAndStudents {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Batch b1=new Batch();
		b1.setSubject("hibernate");
		b1.setCode("jbt-400");
		b1.setTrainer("sathish");
		
		Batch b2=new Batch();
		b2.setSubject("react js");
		b2.setCode("jbt-401");
		b2.setTrainer("prajwal");
		
		Batch b3=new Batch();
		b3.setSubject("j2ee");
		b3.setCode("jbt-300");
		b3.setTrainer("gururaj");
		
		Student s1=new Student();
		s1.setName("ram");
		s1.setPhone(7766);
		s1.setPerc(44.0);
		
		Student s2=new Student();
		s2.setName("john");
		s2.setPhone(7744);
		s2.setPerc(55.0);
		
		Student s3=new Student();
		s3.setName("vicky");
		s3.setPhone(3366);
		s3.setPerc(49.0);
		
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		
		s1.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		s2.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b3)));
		s3.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		
		manager.persist(s3);
		manager.persist(s2);
		manager.persist(s1);
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		
		tx.begin();
		tx.commit();
		
	}

}
