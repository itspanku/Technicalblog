package org.jsp.HibernateLifeCycle.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.HibernateLifeCycle.dto.User;

public class TestHlC {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		User u=new User(); // transient state
		u.setName("abc");
		u.setPhone(888);
		u.setEmail("abc@gmail.com");
		
		manager.persist(u); // persistent state
		tx.begin();
		tx.commit();
		
		u.setName("Dhoni");
		u.setPhone(999);
		tx.begin();
		tx.commit();
		
		manager.detach(u); // detached state
		u.setName("virat");
		u.setPhone(8798);
		tx.begin();
		tx.commit();
		
	}

}
