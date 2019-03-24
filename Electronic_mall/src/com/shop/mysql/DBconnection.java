package com.shop.mysql;
/***数据库链接操作***/

import com.shop.user.*;
import com.shop.index.*;
import com.shop.admin.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class DBconnection {
	static final String driverClass="com.mysql.jdbc.Driver";
	static final String	connStr="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8";
	static final String	user="root";
	static final String pass="admin";
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public Connection getConn() {
			
			try {
				Class.forName(driverClass);
				//out.print("连接成功");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库驱动加载错误!");
			}
			
			try{
				conn =  DriverManager.getConnection(connStr, user, pass);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库连接错误!");
			}
				
			return conn;
		}
}
