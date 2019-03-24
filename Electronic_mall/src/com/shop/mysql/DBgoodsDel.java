package com.shop.mysql;
/***商品删除***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBgoodsDel {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean setDelgoods(int goodsid) {
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try {
			conn = db.getConn();
			pres = conn.prepareStatement("delete from goods where goodsID = ?");
			pres.setInt(1, goodsid);
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
