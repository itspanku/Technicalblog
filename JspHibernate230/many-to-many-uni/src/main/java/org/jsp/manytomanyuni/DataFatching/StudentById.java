package org.jsp.manytomanyuni.DataFatching;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;


public class StudentById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Batch id to Fetch the Student");
		int bid=sc.nextInt();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b=manager.find(Batch.class, bid);
		
		if(b!=null)
		{
			Student stu=(Student) b.getStudents();
			if(stu!=null)
			{
				System.out.println("Id : "+stu.getId());
				System.out.println("Student Name : "+stu.getName());
				System.out.println("Student Percentage : "+stu.getPerc());
				System.out.println("Student phone : "+stu.getPhone());
			}
		}
		else {
			System.err.println("Invalid id ");
		}
	}

}
