package org.com.Delete;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.HibernateDemo.User;

public class DeleteData {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter id to delete a record");
		int id=sc.nextInt();
		
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id);
		Transaction t=s.beginTransaction();
		if(u!=null)
		{
			s.delete(u);
			t.commit();
		}
		else {
			System.err.println("User id is invalid Please Enter Currect user id");
		}
	}

}
