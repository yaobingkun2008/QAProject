package action;

import java.sql.*;
//import com.opensymphony.xwork2.ActionSupport; 

public class register 
{ //��������ڽ�ȡע�����Ϣ
	private String name;
	private String password;
	private String email;
	private String userid;
	private String friends;
	private String confirmpassword;
	private String message;
	public String insert_user() 
	{
		if(this.name.length()!=0 && this.email.length()!=0 && this.password.length()!=0)
		{
			if(this.password.equals(this.confirmpassword)==false)
			{
				setmessage("������������벻ƥ�䣡");
				return "over";
			}
		}
		else
		{
			setmessage("�����κ�һ����Ϣ����Ϊ�գ�");
			return "over";
		}
		/*������֤�Ƿ�ע�����ظ�*/
		Connection a1 = new initialize().getlink();//���ú������г�ʼ��
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
			setmessage("�û����Ѵ���!");
			return "over";
		}
		else//û���ظ������Բ���
		{
			/*�ȵõ���ǰ�ı�� �����µ�ǰ�ı��*/
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
			/*�õ�������Ϊint�ı��*/
			try
	        {
	        	String sql4="insert into user(Name,PassWord,Email,UserID) values(?,?,?,?)";
	            PreparedStatement ps=a1.prepareStatement(sql4);
	            
	            System.out.println(this.name);
	            System.out.println(this.password);
	            System.out.println(this.email);
	            
	            ps.setString(1, this.name);
	            ps.setString(2, this.password);
	            ps.setString(3, this.email);
	            ps.setString(4,	String.valueOf(idnum));
	            ps.executeUpdate();
	        }
	        catch(Exception e3)
	        {
	        	e3.printStackTrace();
	        }
			setmessage("ע��ɹ�����ȥ��¼�ɣ�");
			return "over";//����ɹ���
		}
		/*�����Ͳ���ɹ���*/
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
	public void setmessage(String message)
	{
		this.message = message;
	}
	public String getmessage()
	{
		return this.message;
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
