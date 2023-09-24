// Code for Fetch User By Id using Hql
package org.com.UpdateAndFetch;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class FetchUserByIdUsingHql {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to fetch the record");
		int id=sc.nextInt();
		
		String qry="select u from User u where u.id=:id";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter("id", id);
		
		try {
			User u=q.getSingleResult();
			System.out.println("id : "+ u.getId());
			System.out.println("Name : "+u.getName());
			System.out.println("Email : "+u.getEmail());
			System.out.println("Password : "+u.getPassword());
			System.out.println("Phone : "+u.getPhone());
			
		} catch (NoResultException e) {
			System.err.println("you have Enterd Invalid Id");
		}
		
	}

}
