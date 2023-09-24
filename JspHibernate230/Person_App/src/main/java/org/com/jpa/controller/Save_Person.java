package org.com.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.com.jpa.dto.Person;

public class Save_Person {
	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Devashish");
		p.setAge(22);
		p.setPhone(998877);
		p.setEmail("devashish@gmail.com");
		p.setPassword("321");
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager=factory.createEntityManager();
		manager.persist(p);
		
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
		System.out.println("Person Add With Id : "+p.getId());
	}

}
