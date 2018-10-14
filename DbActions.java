package adminactions;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import java.io.FileOutputStream;
import java.sql.Blob;


import connection.Connect;


public class DbActions {
	
	static int si = 0;
	static int sj = 0;
	static int sk = 0;
	
	public int goProductInsert(String category) throws SQLException
	{	
		Connection con = null;
		PreparedStatement ps= null;
		String insertion = null;
		String sql = null;
		char[] p;
		String pid = "pid";
	
		try
		{
		con = Connect.con();
		boolean b = false;
		Checks chks = new Checks();
		if( category.equals("mencollections"))
		{
			b = chks.tableCheck("MENCOLLECTIONS");
			insertion = "mencollection";
		}
		else
		{
			b = chks.tableCheck("WOMENCOLLECTIONS");
			insertion = "womencollections";
		}
		if( b == true)
		{
			if( insertion.equals("mencollections"))
			{
				sql = "insert into mencollections values(?,?,?,?,?,?,?,?,?)";
			}
			else
			{
				sql = "insert into womencollections values(?,?,?,?,?,?,?,?,?)";
			}
			ps = con.prepareStatement(sql);
			ps.setString(1,ProductBean.getCategory());
			ps.setString(2,ProductBean.getType());
			ps.setString(3,ProductBean.getItem());
			ps.setString(4,ProductBean.getProductName());
			ps.setString(5,ProductBean.getSize());
			ps.setString(6, ProductBean.getPrice());
			ps.setString(7,ProductBean.getPhoto());
			String path = "d:\\upload\\"+ProductBean.getPhoto();
			FileInputStream fin =new FileInputStream(path);
			ps.setBinaryStream(8, fin);
			p = generatePID(5);
			for(int i = 0; i<5; i++)
			{
				pid = pid + p[i];
			}
			ps.setString(9, pid);
			si = ps.executeUpdate(); 
			if(si != 0)
			{
				return si;
			}
		}
		else
		{
			if( category.equals("mencollections"))
			{
				createTable("mencollections",category);
			}
			else
			{
				createTable("womencollections",category);
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
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
		return si;
	}
	
	
	public void createTable(String tablename, String category)
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
		con = Connect.con();
		String sql = "create table "+tablename+" (category varchar2(30),ptype varchar2(30),item varchar2(30),productname varchar2(30),siz varchar2(30),price varchar2(20),imagname varchar2(20),imag blob,productid varchar2(20) unique)";
		ps = con.prepareStatement(sql);
		int i = ps.executeUpdate();
		if( i == 0 )
		{
			goProductInsert(category);
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
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
	}
	
	public ResultSet getDetails(String pid, String cat)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
		con = Connect.con(); 
		String sql = "select * from "+cat+" where productid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, pid);
		rs = ps.executeQuery(); 
		if( rs != null)
		{	
			return rs;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			return rs;
		
	}
	
	
	public int goProductUpdate(String category, String type,String item, String pname, String size,String price,String photo,String pid,String utab)
	{
		Connection con = null;
		PreparedStatement ps= null;
		try
		{
			con = Connect.con();
			String sql = "update "+utab+" set category=?,ptype=?,item=?,productname=?,siz=?,price=?,imagname=?,imag=? where productid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, type);
			ps.setString(3, item);
			ps.setString(4, pname);
			ps.setString(5, size);
			ps.setString(6, price);
			ps.setString(7, photo);
			String path = "d:\\upload\\"+photo;
			FileInputStream fin =new FileInputStream(path);
			ps.setBinaryStream(8, fin);
			ps.setString(9, pid);
			sj = ps.executeUpdate(); 
			if(sj != 0)
			{
				return sj;
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
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
		return sj;
		
	}
	
	public int goProductDelete(String pid, String tablename)
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
		con = Connect.con();
		String sql = "delete from "+tablename+" where productid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, pid);
		sk = ps.executeUpdate();
		if(sk != 0)
		{
			return sk;
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
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
		return sk;
	}
	
	
	
	public char[] generatePID(int len) 
    {
	
	String numbers = "0123456789";

	Random rndm_method = new Random();
	char[] otp = new char[len];
	for (int i = 0; i < len; i++) {
	otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
	}
	return otp;
	} 
	
	public ResultSet getProducts(String type, String tablename)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
		con = Connect.con();
		String sql = "select * from "+tablename+" where ptype=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, type);
		rs = ps.executeQuery(); 
		if( rs != null)
		{	
			return rs;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
	
	public void imageCreate(String pid,String tablename)
	{
		Connection con = null;
		
		try
		{
		con = Connect.con();
		String sql = "select * from "+tablename+" where productid=?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, pid);
		ResultSet rs = pstat.executeQuery();
		rs.next(); // go to first row
		Blob b = rs.getBlob(8);
		byte[] bt = new byte[(int) b.length()];
		bt = b.getBytes(1, (int)b.length());

		FileOutputStream fout = new FileOutputStream("D:\\workspace\\Admin_Panel\\WebContent\\images\\gimages\\"+rs.getString(7));
		fout.write(bt);
		fout.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
}
