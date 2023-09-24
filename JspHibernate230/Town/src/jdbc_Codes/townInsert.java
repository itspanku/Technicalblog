package jdbc_Codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class townInsert {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name=sc.next();
		System.out.println("Enter Your Phone Number");
		long phone=sc.nextLong();
		System.out.println("Enter Your Salary");
		double salary=sc.nextDouble();
		System.out.println("Enter Your Password");
		String password=sc.next();
		
		String qry="insert into town.towninsert (name,phone,salary,password) values(?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getconnection("jdbc:mysql://localhost:3306?username=root and password=root");
		pstmt=con.prepareStatment(qry);
		
		pstmt.setParameter(1,name);
		pstmt.setParameter(2,phone);
		pstmt.setParameter(3,salary);
		pstmt.setParameter(1,password);
		
		pstmt=con.executeUpdate();
		System.out.println("Data Insert sucsessfully..");
			
	}
	
	finally {
		if(con!=null)
		{
			con.close();
		}
	}

}
