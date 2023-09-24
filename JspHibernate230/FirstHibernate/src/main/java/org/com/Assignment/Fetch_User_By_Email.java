package org.com.Assignment;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class Fetch_User_By_Email {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email to Fetch the Record ");
		String email=sc.next();
		String qry= "select u from User u where u.email=?1";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, email);
		try {
			User u=q.getSingleResult();
			System.out.println("Id :"+ u.getId());
			System.out.println("Name : "+u.getName());
			System.out.println("Email : "+ u.getEmail());
			System.out.println("password : "+ u.getPassword());
			System.out.println("Phone : "+ u.getPhone());
			
		} catch (NoResultException e) {
			System.out.println("you enterd invalid Email");
		}
	}

}
