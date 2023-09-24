package org.com.UpdateAndFetch;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.HibernateDemo.User;

public class updateUser {
	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
		System.out.println("Enter user id To Update data or save");
		int id=sc.nextInt();
		System.out.println("Enter Name, Phone, Email, Password");
		User u=new User();
		
		u.setId(id);
		u.setName(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		s.saveOrUpdate(u);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("updated succ....");
		
	}

}
