package adminactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connect;


public class Checks {
	
	public boolean goAdminLoginCheck(String fn, String pw)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try
		{	// Creation of Connection object to connect database
			con = Connect.con();
			String sql = "select * from admin where username=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next())
			{	
				if(rs.getString(1).equals(fn) && rs.getString(2).equals(pw))
				{
					return true;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 finally
			{
				try
				{
					if(ps != null)
					{
						ps.close();
						ps = null;
					}
				}
				catch(SQLException sq1)
				{
					System.out.println(sq1);
				}
				
				
				try
				{
					if(rs != null)
					{
						rs.close();
						rs = null;
					}
				}
				catch(SQLException sq2)
				{
					System.out.println(sq2);
				}
				
				
				try
				{
					if(con != null)
					{
						con.close();
						con = null;
					}
				}
				catch(SQLException sq3)
				{
					System.out.println(sq3);
				}
				
			}
				return false;
	}
	
	public boolean tableCheck(String name)
	{
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{	
			con = Connect.con();
			String sql = "select * from tab";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{	
				if(rs.getString(1).equals(name))
				{
					return true;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
		
		try
		{
			if(ps != null)
			{
				ps.close();
				ps = null;
			}
		}
		catch(SQLException sq1)
		{
			System.out.println(sq1);
		}
		
		
		try
		{
			if(rs != null)
			{
				rs.close();
				rs = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		
		
		try
		{
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq3)
		{
			System.out.println(sq3);
		}
		
		
	}
		return false;
	}
	
}
