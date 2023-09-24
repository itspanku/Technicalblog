package org.com.jpql.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.com.jpa.dto.Person;

public class VerifyPersonByPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Phone Number and Password");
		long phone=sc.nextLong();
		String password=sc.next();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Query q=manager.createNamedQuery("verfiyByPhone");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		try {
			Person p=(Person) q.getSingleResult();
			
			System.out.println("Id : "+p.getId());
			System.out.println("Name : "+p.getName());
			System.out.println("Age : "+p.getAge());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Password : "+p.getPassword());
			
		} catch (Exception e) {
            System.out.println("Invalid Phone Number Or Password...");
		}
		
	}

}
