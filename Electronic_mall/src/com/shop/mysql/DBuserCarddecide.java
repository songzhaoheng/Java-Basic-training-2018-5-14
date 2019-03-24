package com.shop.mysql;
/***获取用户账号、密码***/
import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBuserCarddecide {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean decideUsercard(String usercard, String useremail){
			
		DBconnection db = new DBconnection();
		conn = db.getConn();
			
		try{
			pres = conn.prepareStatement("select userName, userCard, userPass, userEmail from user where userCard = ? and userEmail = ?");
			pres.setString(1, usercard);
			pres.setString(2, useremail);
			res = pres.executeQuery();
			while(res.next()){
				String card = res.getString("userCard");
				String name = res.getString("userName");
				String pass = res.getString("userPass");
				String email = res.getString("userEmail");
				if(card.equals(usercard) && email.equals(useremail)){
					out.println("\n\t\t\t您的用户名是："+name);
					out.println("\n\t\t\t您的密码名是："+pass);
					return true;
				}
			}
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
