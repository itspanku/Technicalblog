// Fetch Phones From User table Where name=?
package org.com.Assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Phones_From_User_Where_Name {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name to Fetch Phone Number");
		String name=sc.next();
		String qry="select u.phone from User u where name=?1";
		
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q=s.createQuery(qry);
		q.setParameter(1, name);
		List<Long> phones=q.getResultList();
		for(Long ph: phones)
		{
			System.out.println(ph);
		}
		
		
	}

}
