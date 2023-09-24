package org.com.UpdateAndFetch;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jsp.HibernateDemo.User;

public class FetchDataByLoad {
 public static void main(String[] args) {
	
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter your id to fetch the data");
	 int uid=sc.nextInt();
	 
	 Session s=new Configuration().configure().buildSessionFactory().openSession();
	 
	User lu= s.load(User.class, uid);
	
	
	try {
		 System.out.println("------------------");
	System.out.println("Id :"+lu.getId());
	System.out.println("--------");
	System.out.println("Name : "+lu.getName());
	System.out.println("Phone : "+lu.getPhone());
	System.out.println("Email : "+ lu.getEmail());
	}catch(ObjectNotFoundException e)
	{
		System.err.println("Your Enterd Id is Invalid");
	}
}

}
