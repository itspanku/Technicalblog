package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class SavebatchAndStudents {
	public static void main(String[] args) {
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Batch b1=new Batch();
		b1.setSubject("hibernate");
		b1.setCode("jbt-hib-a1");
		b1.setTrainer("sathish");
		
		Batch b2=new Batch();
		b2.setSubject("React js");
		b2.setCode("jbt-Rec-a2");
		b2.setTrainer("Prajwal");
		
		Batch b3=new Batch();
		b3.setSubject("J2ee");
		b3.setCode("jbt-jee-a3");
		b3.setTrainer("Gururaj");
		
		
		Student s1=new Student();
		s1.setName("virat");
		s1.setPerc(98);
		s1.setPhone(777888);
		
		
		Student s2=new Student();
		s2.setName("rohit");
		s2.setPerc(88);
		s2.setPhone(777999);
		
		Student s3=new Student();
		s3.setName("msd");
		s3.setPerc(99);
		s3.setPhone(6667777);
		
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		tx.begin();
		tx.commit();
		
		
		
		
	}

}
