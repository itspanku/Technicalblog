package org.jsp.TimeStamp.controller;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.TimeStamp.dto.FoodOrder;

public class UpdateFood {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		FoodOrder order=manager.find(FoodOrder.class, 3);
		//FoodOrder order=new FoodOrder();
		//order.setId(2);
		order.setFood_item("liver_curry");
		order.setCost(50);	
		
		manager.merge(order);
		
		tx.begin();
		tx.commit();
		
	}

}
