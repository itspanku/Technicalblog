package org.com.jpql.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.com.jpa.dto.Person;

public class VerfiyPersonById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your id and PassWord");
		int id=sc.nextInt();
		String password=sc.next();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Query q=manager.createNamedQuery("verfiyById");
		q.setParameter(1, id);
		q.setParameter(2, password);
		
		List<Person> ps=q.getResultList();
		if(ps.size()>0)
		{
			for(Person p: ps)
			{
				System.out.println("Id : "+p.getId());
				System.out.println("Name : "+p.getName());
				System.out.println("Age : "+p.getAge());
				System.out.println("Phone : "+p.getPhone());
				System.out.println("Email : "+p.getEmail());
				System.out.println("Password : "+p.getPassword());
				
			}
		}else {
			System.err.println("Invalid id or password");
		}
	}

}
