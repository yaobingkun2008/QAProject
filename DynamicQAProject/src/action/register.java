package action;

import java.sql.*;

public class register{//这个类用于截取注册的信息
	private String name;
	private String password;
	private String email;
	private String userid;
	private String friends;
	
	public void insert_user(){
		Connection a = new initialize().getlink();//调用函数进行初始化
	}
	
}
