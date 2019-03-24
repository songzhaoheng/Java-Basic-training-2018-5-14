package com.shop.mysql;
/***管理员注册信息插入***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBadminRegion {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean insertAdmin(String adminname, String adminpass) {
		try {
			DBconnection db = new DBconnection();
			conn = db.getConn();
			pres = conn.prepareStatement("insert into admin (adminName, adminPass) values(?, ?)");
			pres.setString(1, adminname);
			pres.setString(2, adminpass);
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
