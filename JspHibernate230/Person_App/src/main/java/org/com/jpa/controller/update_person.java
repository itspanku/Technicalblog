package org.com.jpa.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.com.jpa.dto.Person;

//id, name, age, phone, email,password

public class update_person {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to update person");
		int id=sc.nextInt();
		System.out.println("Enter name,age,phone,email,password");
		String name=sc.next();
		int age=sc.nextInt();
		long phone=sc.nextLong();
		String email=sc.next();
		String password=sc.next();
		
		Person p=new Person();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		p.setId(id);
		p.setName(name);
		p.setAge(age);
		p.setPhone(phone);
		p.setEmail(email);
		p.setPassword(password);
		
		manager.merge(p);
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
		
		System.out.println("Update Done ");
	}

}
