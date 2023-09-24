package org.com.Assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Fetch_All_The_Phone_Number {
public static void main(String[] args) {
	
	String qry="select u.phone from User u";
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Query<Long> q=s.createQuery(qry);
	List<Long> phones=q.getResultList();
	for(Long ph: phones)
	{
		System.out.println(" Phone Number: "+ph);
		
		System.out.println("-------");
	}
}
}
