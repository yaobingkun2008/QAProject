package action;

import java.sql.*;

public class initialize {
	public Connection getlink()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","qweasd");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
