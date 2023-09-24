package org.jsp.manytooneuni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytooneuni.dto.Branch;
import org.jsp.manytooneuni.dto.Hospital;

public class saveHospitalAndBranche {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Hospital h=new Hospital();
		h.setName("ABC");
		h.setFounder("Zofer");
		h.setYoesto(1984);
		
		Branch b1=new Branch();
		b1.setName("ABC first");
		b1.setEmail("abcd@gmail.com");
		b1.setPhone(777888);
		b1.setHospital(h);
		
		Branch b2=new Branch();
		b2.setName("ABC Second");
		b2.setEmail("abcg@gmail.com");
		b2.setPhone(999888);
		b2.setHospital(h);
		
		Branch b3=new Branch();
		b3.setName("ABC Third");
		b3.setEmail("abcf@gmail.com");
		b3.setPhone(556677);
		b3.setHospital(h);
		
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		
		tx.begin();
		tx.commit();
		
		
	}

}
