package org.jsp.onetomanybid.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybid.dto.Department;
import org.jsp.onetomanybid.dto.Employee;

public class SaveDepartmentAndEmployees {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		Department d=new Department();
		d.setName("Development");
		d.setLocation("Bangaluru ");
		
		Employee e1=new Employee();
		e1.setName("rocky");
		e1.setDesg("ceo");
		e1.setSalary(32445);
		e1.setDept(d);
		
		Employee e2=new Employee();
		e2.setName("pushpa");
		e2.setDesg("smugler");
		e2.setSalary(324334);
		e2.setDept(d);
		
		Employee e3=new Employee();
		e3.setName("Bahubali");
		e3.setDesg("solder");
		e3.setSalary(2533);
		e3.setDept(d);
		
		List<Employee> answer=new ArrayList<Employee>();
		answer.add(e1);
		answer.add(e2);
		answer.add(e3);
		d.setEmps(answer);
		
		//d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
		
		manager.persist(d);
		tx.begin();
		tx.commit();
	}

}
