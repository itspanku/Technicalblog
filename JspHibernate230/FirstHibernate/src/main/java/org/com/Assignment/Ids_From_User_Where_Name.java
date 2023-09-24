// fetch ids from user table where name=?
package org.com.Assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Ids_From_User_Where_Name 
{
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name for Fetch the Ids");
		String name=sc.next();
		
		String qry="select u.id from User u where name=?1 ";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> q=s.createQuery(qry);
		q.setParameter(1,name);
		List<Integer> ides=q.getResultList();
		for(Integer id: ides)
		{
			System.out.println(" id "+id);
			
			System.out.println("-------");
		}
	}

}
