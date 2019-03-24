package com.shop.mysql;
/***获取购买记录***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBcost {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public void getCost(String username) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select * from cost where userName = ?");
			pres.setString(1, username);
			res = pres.executeQuery();
			System.out.println("\t\t---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 价 格 ----"+" 购 买 数 量 ----" + " 商 品 花 费 总 价 ----");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				int num = res.getInt("goodsNum");
				BigDecimal usercost = res.getBigDecimal("userCost");
				System.out.println("\t\t\t"+id+"\t        "+name+"\t      "+vipmoney+"\t\t"+num+"\t\t"+usercost);
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
