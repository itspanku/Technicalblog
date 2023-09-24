package org.com.jpa.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.com.jpa.dto.Person;

public class Delete_Person_ById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your id to delete the record");
		int id=sc.nextInt();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Person p=manager.find(Person.class, id);
		
		if(p!=null)
		{
			manager.remove(p);
			
			EntityTransaction t=manager.getTransaction();
			t.begin();
			t.commit();
			System.out.println(p.getName()+" Your Record is Deleted.... ");
		}else {
			System.err.println("Invalid Id Please Check Your Id");
		}
	}

}
