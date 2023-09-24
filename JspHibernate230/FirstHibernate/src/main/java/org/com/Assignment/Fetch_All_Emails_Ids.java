package org.com.Assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Fetch_All_Emails_Ids {
	public static void main(String[] args) {
		
		String qry="select u.email from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q=s.createQuery(qry);
		List<String> emails=q.getResultList();
		for(String em: emails)
		{
			System.out.println(" Email Ids : "+em);
			
			System.out.println("-------");
		}
	}

}
