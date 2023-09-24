//Code to Fetch AadharCard by Person Id 2nd Way

package org.com.onetoonebi.FetchData;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.com.onetoonebi.dao.AadharCard;
import org.com.onetoonebi.dao.Person;

public class Fetch_AadharCard_By_Person_id2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Id to Fetch the AadharCard");
		int pid=sc.nextInt();
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry1="select a from AadharCard a where a.person.id=?1 ";
		String qry2="select p.card from Person p where p.id=?1 ";
		
		Query q=manager.createQuery(qry1);
		q.setParameter(1, pid);
		try {
			AadharCard card =(AadharCard) q.getSingleResult();
			
			System.out.println("id : "+card.getId());
			System.out.println("Aadhar Numbber : "+card.getNumber());
			System.out.println("Date of Birth : "+card.getDob());
			System.out.println("PinCode : "+card.getPincode());
			
		} catch (Exception e) {
			System.err.println("Invalid Details");
		}
	}

}
