package com.shop.mysql;
/***用户注册信息插入***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBuserregion {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean insertUser(String username, String userpass, String usercard, int age, String useremail, String useraddress) {
		try {
			DBconnection db = new DBconnection();
			conn = db.getConn();
			pres = conn.prepareStatement("insert into user (userName, userPass, userCard, userAge, userEmail, userAddress) values(?, ?, ?, ?, ?, ?)");
			pres.setString(1, username);
		    out.println(username+userpass+usercard);
			pres.setString(2, userpass);
			pres.setString(3, usercard);
			pres.setInt(4, age);
			pres.setString(5, useremail);
			pres.setString(6, useraddress);
			int i = pres.executeUpdate();
			if(i == 1){
				return true;
			}
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
