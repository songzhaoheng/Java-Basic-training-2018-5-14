package com.shop.mysql;
/***判断用户名是否重复***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBuserNamedecide {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean decideUsername(String username){
			
		DBconnection db = new DBconnection();
		conn = db.getConn();
			
		try{
			pres = conn.prepareStatement("select userName from user where userName = ?");
			pres.setString(1, username);
			res = pres.executeQuery();
			while(res.next()){
				String name = res.getString("userName");
				if(name.equals(username)){
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
