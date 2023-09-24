package org.com.jpql.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.com.jpa.dto.Person;
import org.hibernate.query.Query;

public class FetchPersonByAge {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Age");
		int age=sc.nextInt();
		String jpql="select p from Person p where p.age=?1";
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	   javax.persistence.Query q= manager.createQuery(jpql);
	   q.setParameter(1, age);
	   List<Person> ps=q.getResultList();
	   if(ps.size()>0)
	   {
		   for(Person p: ps)
		   {
			   System.out.println("id : "+p.getId());
			   System.out.println("Name :"+p.getName());
			   System.out.println("Age : "+p.getAge());
		   }
	   }else {
		   System.err.println("Invalid ag");
	   }
	   
	   
		
	}

}
