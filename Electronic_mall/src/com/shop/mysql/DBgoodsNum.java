package com.shop.mysql;
/***获取商品数量***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBgoodsNum {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	public int getgoodsNum(int goodsid) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select goodsID,goodsNum from goods where goodsID = ?");
			pres.setInt(1, goodsid);
			res = pres.executeQuery();
			while(res.next()){
				int id = res.getInt("goodsID");
				
				if(goodsid == id){
					return res.getInt("goodsNum");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
}
