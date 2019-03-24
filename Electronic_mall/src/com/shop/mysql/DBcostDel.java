package com.shop.mysql;
/***删除用户花费***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBcostDel {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public void Costdel(String name) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try {
			pres = conn.prepareStatement("delete from cost where userName = ?");
			pres.setString(1, name);
			int i = pres.executeUpdate();
			
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e) {
		}
	}
}
