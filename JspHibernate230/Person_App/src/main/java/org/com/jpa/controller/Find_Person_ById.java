package org.com.jpa.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.com.jpa.dto.Person;

public class Find_Person_ById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id To Fetch Details");
		int id=sc.nextInt();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Person p=manager.find(Person.class, id);
		if(p!=null)
		{
			System.out.println("Id : "+p.getId());
			System.out.println("Name : "+p.getName());
			System.out.println("Age : "+p.getAge());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Password : "+p.getPassword());
			
		}else {
			System.out.println("Invalid Id You Enterd");
		}
	}

}
