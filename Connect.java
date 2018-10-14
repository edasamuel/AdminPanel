package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
		}
	}
	
	public static Connection conn;
	
	public Connect()
	{}
	public static Connection con() throws SQLException 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "sam";
		String password = "admin";
		conn = DriverManager.getConnection(url,username,password);
		return conn;
	}	
}
