package com.shop.mysql;
/***获取用户名称***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBuserName {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public String getuserName(int usersid) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select userID, userName from user where userID = ?");
			pres.setInt(1, usersid);
			res = pres.executeQuery();
			while(res.next()){
				int id = res.getInt("userID");
				if(usersid == id){
					return res.getString("userName");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "";
	}
}
