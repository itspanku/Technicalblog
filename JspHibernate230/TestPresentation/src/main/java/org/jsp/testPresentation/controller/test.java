package org.jsp.testPresentation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.testPresentation.dto.Marchent;
import org.jsp.testPresentation.dto.Product;

public class test {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=manager.getTransaction();
		
		Marchent m=new Marchent();
		m.setName("abc");
		m.setEmail("abc@gmail.com");
		m.setPassword("123");
		
		Product p=new Product();
		p.setbName("tata");
		p.setpName("car");
		p.setMnd(LocalDateTime.parse("1994-08-23"));
		
		m.setPro(null);
	}

}
