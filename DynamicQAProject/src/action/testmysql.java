package action;

import java.sql.*;

public class testmysql 
{
	/*
	public static void InsertSql()
	{
        try
        {
        	String insql="insert into user(Name,PassWord,Email,UserID) values(?,?,?,?)";
        	Connection conn = new initialize().getlink();
            PreparedStatement ps=conn.prepareStatement(insql);
            ps.setString(1, "222");
            ps.setString(2, "222");
            ps.setString(3, "222");
            ps.setString(4,"222");
            int result=ps.executeUpdate();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
	public static void main(String[] args)
	{
		InsertSql();
	}
	*/
	/*
	public static void testfixdata()
	{
		int idnum = 0;
		try
		{
			Connection a1 = new initialize().getlink();
			String sql2 = "select * from nowinformation";
			String sql3 = "";
			String s1 = "";
			Statement stmt2 = a1.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			while(rs2.next()!=false)
			{
				idnum = Integer.parseInt(rs2.getString(1))+1;
				s1 = rs2.getString(1);
				System.out.println(s1);
			}
			sql3 = "update nowinformation set idnow="+"\""+String.valueOf(idnum)+"\""+"where idnow="+"\""+s1+"\"";                
			stmt2.executeUpdate(sql3);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(idnum);
	}
	*/
	public static void main(String[] args)
	{

		//testfixdata();
	}
}
