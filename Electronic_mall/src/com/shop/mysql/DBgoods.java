package com.shop.mysql;
/***获取所有商品***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBgoods {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public void getGoods() {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			System.out.println("\t\t---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 生 产 日 期 ----"+" 会 员 价 格 ----" + " 非 会 员 价 格 ----" + " 商 品 数 量 ----");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				System.out.println("\t\t\t"+id+"\t        "+name+"\t      "+date+"\t "+vipmoney+"\t\t"+money+"\t\t  "+num);
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
