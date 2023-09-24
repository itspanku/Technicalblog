package org.com.onetoonebi.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.com.onetoonebi.dao.AadharCard;
import org.com.onetoonebi.dao.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Pankaj");
		p.setPhone(8989615947L);
		
		AadharCard card=new AadharCard();
		card.setNumber(4848479323843425L);
		card.setPincode(458771);
		card.setDob(LocalDate.parse("2001-08-23"));
		
		p.setCard(card);
		card.setPerson(p);
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		manager.persist(p);
		EntityTransaction tx=manager.getTransaction();
		tx.begin();
		tx.commit();
		
	}

}
