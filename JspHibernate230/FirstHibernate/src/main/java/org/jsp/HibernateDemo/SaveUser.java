package org.jsp.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args) {
		User u=new User();
		u.setName("abc");
		u.setEmail("ABC@gmail.com");
		u.setPassword("ABC123");
		u.setPhone(72727272);
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		int id=(Integer)s.save(u);
		
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("user register with id: "+ id);
	}

}
