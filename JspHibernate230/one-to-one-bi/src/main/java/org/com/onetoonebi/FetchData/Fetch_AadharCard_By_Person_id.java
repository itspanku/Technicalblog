// Code To Fetch AadharCard By Person Id 1st Way

package org.com.onetoonebi.FetchData;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.com.onetoonebi.dao.AadharCard;
import org.com.onetoonebi.dao.Person;

public class Fetch_AadharCard_By_Person_id {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person id to Fetch the AadharCard");
		int pid=sc.nextInt();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p=manager.find(Person.class, pid);
		
		if(p!=null)
		{
			AadharCard card= p.getCard();
			if(card!=null)
			{
				System.out.println("Id : "+card.getId());
				System.out.println("AadharCard Number : "+card.getNumber());
				System.out.println("Date of Birth : "+card.getDob());
				System.out.println("Pincode : "+card.getPincode());
			}
		}
		else {
			System.out.println("Invalid Person Id ");
		}
	}

}
