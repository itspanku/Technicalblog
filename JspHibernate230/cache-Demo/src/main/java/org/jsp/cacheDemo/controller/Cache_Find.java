package org.jsp.cacheDemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.cacheDemo.dto.Employee;

public class Cache_Find {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		Employee e=new Employee();
		e.setName("abc");
		e.setSalary(23.4);
		
		Employee e1=manager.find(Employee.class, 1);
		Employee e2=manager.find(Employee.class, 1);
		
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
	}

}
