package org.com.onetooneuni.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.com.onetooneuni.dto.PanCard;
import org.com.onetooneuni.dto.Person;

public class SavePersonAndPancard {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		EntityTransaction tx=manager.getTransaction();
		
		Person p=new Person();
		p.setName("Anushka");
		p.setPhone(768934);
		
		PanCard card=new PanCard();
		card.setNumber("PJK878KJH9");
		card.setPincode(458734);
		card.setDob(LocalDate.parse("1998-07-11"));
		
		p.setCard(card);
		manager.persist(p);
		
		tx.begin();
		tx.commit();
	}

}
