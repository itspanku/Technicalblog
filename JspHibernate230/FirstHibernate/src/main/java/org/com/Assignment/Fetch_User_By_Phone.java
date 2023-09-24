package org.com.Assignment;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class Fetch_User_By_Phone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Phone to Fetch the Details ");
		long phone=sc.nextLong();
		String qry= "select u from User u where u.phone=?1";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, phone);
		try {
			User u=q.getSingleResult();
			System.out.println("Id :"+ u.getId());
			System.out.println("Name : "+u.getName());
			System.out.println("Email : "+ u.getEmail());
			System.out.println("password : "+ u.getPassword());
			System.out.println("Phone : "+ u.getPhone());
			
		} catch (NoResultException e) {
			System.err.println("you enterd invalid Phone number");
		}
	}

}
