package org.com.UpdateAndFetch;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.HibernateDemo.User;

public class FetchAllRecord {
	public static void main(String[] args) {
		
		String qry="select u from User u";  // HQL queries
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		List<User> users=q.getResultList();
		for(User u:users)
		{
			System.out.println(u.getId());
			System.out.println(u.getName());
			System.out.println(u.getEmail());
			System.out.println(u.getPassword());
			System.out.println(u.getPhone());
			System.out.println("----------------");
		}
		}

}
