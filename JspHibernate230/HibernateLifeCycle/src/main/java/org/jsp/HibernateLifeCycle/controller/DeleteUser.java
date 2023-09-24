package org.jsp.HibernateLifeCycle.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.HibernateLifeCycle.dto.User;

public class DeleteUser {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Id");
		int id=sc.nextInt();
		
		User u=manager.find(User.class, id); //persistence state
		if(u!=null) {
		manager.remove(u); // removed state
		tx.begin();
		tx.commit();
		}else {
			System.err.println("invalid id");
		}
		
	}

}
