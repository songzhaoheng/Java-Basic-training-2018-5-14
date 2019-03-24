package com.shop.mysql;
/***获取所有用户信息***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBuser {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public void getUser() {
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try {
			pres = conn.prepareStatement("select * from user");
			res = pres.executeQuery();	//执行查询语句
			out.println("\t\t----用 户 序 号-----"+"---用 户 名------"+"--用 户 密 码------"+"--用 户 身 份 证 号------"+"--用 户 年 龄------"+"--用 户 邮 箱------"+"--用 户 地 址----");
			
			while(res.next()){
				int id = res.getInt("userId");
				String name = res.getString("userName");
				String pass = res.getString("userPass");
				String card = res.getString("userCard");
				int age = res.getInt("userAge");
				String email = res.getString("userEmail");
				String address = res.getString("userAddress");
						
				System.out.println("\t\t\t"+id+" \t   "+name+"\t   "+pass+"\t    "+card+"\t      "+age+" \t  "+email+"  "+address+"\n");
			}
			
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
