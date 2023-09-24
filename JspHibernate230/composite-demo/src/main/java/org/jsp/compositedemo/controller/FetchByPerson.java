package org.jsp.compositedemo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositedemo.dto.Person;
import org.jsp.compositedemo.dto.PersonId;

public class FetchByPerson {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email id or phone number to fetch data");
		String email=sc.next();
		long phone=sc.nextLong();
		
		PersonId id=new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		
		
		Person p=manager.find(Person.class,id);
		
		if(p!=null)
		{
			System.out.println("------------------");
			System.out.println("person name :"+ p.getName());
			System.out.println("person password :"+p.getPassword());
			System.out.println("prson email :"+ p.getId().getEmail());
			System.out.println("person phone :"+p.getId().getPhone());
		}else {
			System.err.println("invalid credentials.......");
		}
	}

}
