package action;

import java.sql.*;

public class login 
{
	private String logininfor;
	private String loginpassword;
	
	public String login_user()
	{
		String truepassword = "";
		if(this.logininfor.length()!=0 && this.loginpassword.length()!=0)//全部非空，开始判断
		{
			Connection a1 = new initialize().getlink();//调用函数进行初始化
			boolean isfound = false;
			String sql1 = "select * from user where Name=\""+this.logininfor+"\"";//先按照姓名搜索
			try
			{
				Statement stmt1 = a1.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
				while(rs1.next()!=false)
				{
					isfound = true;//找到了
					truepassword = rs1.getString(2);
					break;
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			if(isfound == false)//尚未找到,再按照邮箱找一遍
			{
				String sql2 = "select * from user where Email=\""+this.logininfor+"\"";
				try
				{
					Statement stmt2 = a1.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					while(rs2.next()!=false)
					{
						isfound = true;//找到了
						truepassword = rs2.getString(2);
						break;
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			if(isfound == false)//如果没找到
			{
				return "loginfailed";//没有找到，失败
			}
			else if(this.loginpassword.equals(truepassword)==true)//
			{
				return "loginsuccess";//匹配，成功
			}
			else
			{
				return "loginfailed";//用户名密码不匹配，失败
			}
		}
		else
		{
			return "loginfailed";//有信息没有输入，失败
		}
	}
	public void setlogininfor(String logininfor)
	{
		this.logininfor = logininfor;
	}
	
	public void setloginpassword(String loginpassword)
	{
		this.loginpassword = loginpassword;
	}
	
	public String getloginfor()
	{
		return this.logininfor;
	}
	
	public String getloginpassword()
	{
		return this.loginpassword;
	}
}
