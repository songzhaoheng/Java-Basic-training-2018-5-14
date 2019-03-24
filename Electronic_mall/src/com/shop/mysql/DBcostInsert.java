package com.shop.mysql;
/***添加购物车商品***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBcostInsert {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean Goodsinsert(String username, int goodsid, String goodname, BigDecimal goodsvip, int goodnum, BigDecimal usercost) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("insert into cost (userName, goodsID, goodsName, goodsVIPmoney, goodsNum, userCost ) values(?,?,?,?,?,?)");
			pres.setString(1, username);
			pres.setInt(2, goodsid);
			pres.setString(3, goodname);
			pres.setBigDecimal(4, goodsvip);
			pres.setInt(5, goodnum);
			pres.setBigDecimal(6, usercost);
			int i = pres.executeUpdate();
			if(i == 1){
				return true;
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
