package action;

import java.sql.*;

public class login 
{
	private String logininfor;
	private String loginpassword;
	
	public String login_user()
	{
		String truepassword = "";
		if(this.logininfor.length()!=0 && this.loginpassword.length()!=0)//ȫ���ǿգ���ʼ�ж�
		{
			Connection a1 = new initialize().getlink();//���ú������г�ʼ��
			boolean isfound = false;
			String sql1 = "select * from user where Name=\""+this.logininfor+"\"";//�Ȱ�����������
			try
			{
				Statement stmt1 = a1.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
				while(rs1.next()!=false)
				{
					isfound = true;//�ҵ���
					truepassword = rs1.getString(2);
					break;
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			if(isfound == false)//��δ�ҵ�,�ٰ���������һ��
			{
				String sql2 = "select * from user where Email=\""+this.logininfor+"\"";
				try
				{
					Statement stmt2 = a1.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					while(rs2.next()!=false)
					{
						isfound = true;//�ҵ���
						truepassword = rs2.getString(2);
						break;
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			if(isfound == false)//���û�ҵ�
			{
				return "loginfailed";//û���ҵ���ʧ��
			}
			else if(this.loginpassword.equals(truepassword)==true)//
			{
				return "loginsuccess";//ƥ�䣬�ɹ�
			}
			else
			{
				return "loginfailed";//�û������벻ƥ�䣬ʧ��
			}
		}
		else
		{
			return "loginfailed";//����Ϣû�����룬ʧ��
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
