package com.shop.mysql;
/***获取商品会员价格***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBgoodsVIPmoney {
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	public BigDecimal getgoodsVIPmoney(int goodsid) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select goodsID,goodsVIPmoney from goods where goodsID = ?");
			pres.setInt(1, goodsid);
			res = pres.executeQuery();
			while(res.next()){
				int id = res.getInt("goodsID");
				
				if(goodsid == id){
					return res.getBigDecimal("goodsVIPmoney");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return BigDecimal.valueOf(0);
	}
}
