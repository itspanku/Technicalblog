// Code to verfiy user by using id and password
package org.com.UpdateAndFetch;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class VerfiyUser_By_Id_and_Password {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User id and Password to fetch the data");
		int id=sc.nextInt();
		String password=sc.next();
		
		String qry="select u from User u where u.id=?1 and u.password=?2";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		
		try {
			User u=q.getSingleResult();
			System.out.println("Id :"+ u.getId());
			System.out.println("Name : "+u.getName());
			System.out.println("Email : "+ u.getEmail());
			System.out.println("password : "+ u.getPassword());
			System.out.println("Phone : "+ u.getPhone());
			
		} catch (NoResultException e) {
			System.out.println("Invalid Id or password");
		}
		
	}

}
