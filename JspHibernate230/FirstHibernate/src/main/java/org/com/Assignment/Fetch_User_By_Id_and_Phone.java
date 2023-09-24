package org.com.Assignment;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class Fetch_User_By_Id_and_Phone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id and phone to Fetch the Details ");
		int id=sc.nextInt();
		long phone=sc.nextLong();
		
		String qry= "select u from User u where u.id=?1 and u.phone=?2";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, phone);
		try {
			User u=q.getSingleResult();
			System.out.println("Id :"+ u.getId());
			System.out.println("Name : "+u.getName());
			System.out.println("Email : "+ u.getEmail());
			System.out.println("password : "+ u.getPassword());
			System.out.println("Phone : "+ u.getPhone());
			
		} catch (NoResultException e) {
			System.err.println("you enterd invalid Id or Phone number");
		}
	}
}
