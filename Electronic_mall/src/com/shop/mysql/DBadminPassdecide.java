package com.shop.mysql;
/***判断管理员密码是否正确***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBadminPassdecide {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean decideAdminpass(String adminname, String adminpass){
			
		DBconnection db = new DBconnection();
		conn = db.getConn();
			
		try{
			pres = conn.prepareStatement("select adminPass from admin where adminName = ?");
			pres.setString(1, adminname);
			res = pres.executeQuery();
			
			while(res.next()){
				String pass = res.getString("adminPass");
				
				if(adminpass.equals(pass) == true){
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
