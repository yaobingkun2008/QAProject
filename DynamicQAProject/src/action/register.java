package action;

import java.sql.*;

public class register{//这个类用于截取注册的信息
	private String name;
	private String password;
	private String email;
	private String userid;
	private String friends;
	private String confirmpassword;
	
	public String insert_user()
	{
		if(this.name.length()!=0 && this.email.length()!=0 && this.password.length()!=0)
		{
			if(this.password.equals(this.confirmpassword)==false)
			{
				return "over";
			}
		}
		else
		{
			return "over";
		}
		/*下面验证是否注册名重复*/
		Connection a1 = new initialize().getlink();//调用函数进行初始化
		boolean isrepeat = false;
		String sql1 = "select * from user where Name=\""+this.name+"\"";
		try
		{
			Statement stmt1 = a1.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			while(rs1.next()!=false)
			{
				isrepeat = true;
			}
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		if(isrepeat == true)
		{
			return "over";
		}
		else//没有重复，可以插入
		{
			/*先得到当前的编号 并更新当前的编号*/
			int idnum = 0;
			try
			{
				String sql2 = "select * from nowinformation";
				String sql3 = "";
				String s1 = "";
				Statement stmt2 = a1.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				while(rs2.next()!=false)
				{
					idnum = Integer.parseInt(rs2.getString(1))+1;
					s1 = rs2.getString(1);
				}
				sql3 = "update nowinformation set idnow="+"\""+String.valueOf(idnum)+"\""+"where idnow="+"\""+s1+"\"";                
				stmt2.executeUpdate(sql3);
			}
			catch (SQLException e2)
			{
				e2.printStackTrace();
			}
			/*得到了类型为int的编号*/
			try
	        {
	        	String sql4="insert into user(Name,PassWord,Email,UserID) values(?,?,?,?)";
	            PreparedStatement ps=a1.prepareStatement(sql4);
	            ps.setString(1, this.name);
	            ps.setString(2, this.password);
	            ps.setString(3, this.email);
	            ps.setString(4,	String.valueOf(idnum));
	        }
	        catch(Exception e3)
	        {
	        	e3.printStackTrace();
	        }
			return "over";//插入成功了
		}
		/*这样就插入成功了*/
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	public void setemail(String email)
	{
		this.email = email;
	}
	public void setpassword(String password)
	{
		this.password = password;
	}
	public void setconfirmpassword(String confirmpassword)
	{
		this.confirmpassword = confirmpassword;
	}
	public String getname()
	{
		return this.name;
	}
	public String getemail()
	{
		return this.email;
	}
	public String getpassword()
	{
		return this.password;
	}
	public String getconfirmpassword()
	{
		return this.confirmpassword;
	}
}
