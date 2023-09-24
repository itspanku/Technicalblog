package org.jsp.TimeStamp.controller;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.TimeStamp.dto.FoodOrder;

public class SaveFood {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction tx=manager.getTransaction();
	
	FoodOrder order=new FoodOrder();
	order.setFood_item("Biryani");
	order.setCost(140);
	manager.persist(order);
	tx.begin();
	tx.commit();
}
}
