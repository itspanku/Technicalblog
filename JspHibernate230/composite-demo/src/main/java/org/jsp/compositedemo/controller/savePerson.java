package org.jsp.compositedemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositedemo.dto.Person;
import org.jsp.compositedemo.dto.PersonId;

public class savePerson {
	
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Person p=new Person();
		p.setName("vicky");
		p.setPassword("abc123");
		
		PersonId id=new PersonId();
		id.setEmail("abc@gmail.com");
		id.setPhone(111);
		
		p.setId(id);
		
		manager.persist(p);
		tx.begin();
		tx.commit();
	}

}
