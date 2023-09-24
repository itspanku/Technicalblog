package com.tech.blog.dao;
import java.sql.*;

public class LikeDao {
	Connection con=null;
	public LikeDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean insertLike(int pid, int uid) {
		boolean f=false;
		try {
			
			String qry="insert into liked(pid,uid) values(?,?)" ;
			PreparedStatement p=this.con.prepareStatement(qry);
			// values
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.executeUpdate();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countLikeOnPost(int pid)
	{
		int count=0;
		
		String qry="select count(*) from liked where pid=?";
		
		try {
			PreparedStatement p=this.con.prepareStatement(qry);
			p.setInt(1, pid);
			
			ResultSet set=p.executeQuery();
			
			if(set.next())
			{
				count=set.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean isLikedByUser(int pid,int uid)
	{
		boolean f=false;
		try {
			String qry="select * from liked where pid=? and uid=?";
			PreparedStatement p=this.con.prepareStatement(qry);
			p.setInt(1, pid);
			p.setInt(2, uid);
			ResultSet set=p.executeQuery();
			if(set.next())
			{
				f=true;
			}
		} catch (Exception e) {

		e.printStackTrace();
		}
		return f;
	}

	
	public boolean deleteLike(int pid,int uid)
	{
		boolean f=false;
		try {
			String qry="select * from liked where pid=? and uid=?";
			PreparedStatement p=this.con.prepareStatement(qry);
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.executeUpdate();
			
				f=true;
				
		} catch (Exception e) {

		e.printStackTrace();
		}
		return f;
	}
}
