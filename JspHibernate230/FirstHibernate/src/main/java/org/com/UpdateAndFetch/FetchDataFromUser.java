package org.com.UpdateAndFetch;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsp.HibernateDemo.User;

public class FetchDataFromUser {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID to Fetch Data");
		int id=sc.nextInt();
		

		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		
		User u=s.get(User.class,id);
		if(u!=null)
		{
			System.out.println("---------------");
			System.out.println();
			System.out.println("User id is : "+u.getId());
			System.out.println("User Name is : "+ u.getName());
			System.out.println("User Phone is : "+u.getPhone());
			System.out.println("User Email : "+u.getEmail());
		}else {
			System.err.println("User Id is not Valiad Please Enter Currct Id");
		}
	}

}
