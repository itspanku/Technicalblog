package com.tech.blog.dao;

import java.sql.*;

import com.tech.blog.entitties.User;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	// method to insert user to data base:
	public boolean saveUser(User user )
	{
		boolean f=false;
		try {
			//user -------> database
			
			String qry= "insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
			PreparedStatement pstmt=this.con.prepareStatement(qry);
			pstmt.setString(2, user.getEmail());
			pstmt.setString(1, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());
			
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {

		}
		return f;
	}
	
	//get user by useremail and userpassword
	
	public User getUserByEmailAndPassword(String email,String password)
	{
		User user=null;
		try {
			String qry="select * from user where email=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(qry);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet set=pstmt.executeQuery();
			
			if(set.next())
			{
				user=new User();
				
				// fetch data from database
				String name=set.getString("name");
				// set data user object
				user.setName(name);
				
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setDateTime(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean updateUser(User user)
	{
		boolean f=false;
		try {
			String qry="update user set name=?, email=?, password=?, gender=?, about=?, profile=?   where id=?";
			//update btm.mytable set name=?,mobile=? where id=1
			PreparedStatement p=con.prepareStatement(qry);
			
			p.setString(1, user.getName()); 
			p.setString(2, user.getEmail());
			p.setString(3, user.getPassword());
			p.setString(4, user.getGender());
			p.setString(5, user.getAbout());
			p.setString(6, user.getProfie());
			p.setInt(7, user.getId());
			
			p.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User getUserByUserId(int userId){
		User user=null;
		try {
		String qry="select * from user where id=?";
		PreparedStatement ps = this.con.prepareStatement(qry);
		ps.setInt(1, userId);
		ResultSet set=ps.executeQuery();
		
		if(set.next())
		{

			user=new User();
			
			// fetch data from database
			String name=set.getString("name");
			// set data user object
			user.setName(name);
			
			user.setId(set.getInt("id"));
			user.setEmail(set.getString("email"));
			user.setPassword(set.getString("password"));
			user.setGender(set.getString("gender"));
			user.setAbout(set.getString("about"));
			user.setDateTime(set.getTimestamp("rdate"));
			user.setProfile(set.getString("profile"));
		}else {
		    System.out.println("No user found with userId: " + userId);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
}
