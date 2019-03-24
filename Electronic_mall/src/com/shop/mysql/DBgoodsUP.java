package com.shop.mysql;
/***商品修改***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class DBgoodsUP {

	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public boolean setupgoodsName(int goodsid, String goodsname){
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			String sql = "update goods set goodsName = ? where goodsID = ?";
			pres = conn.prepareStatement(sql);
			pres.setString(1, goodsname);
			pres.setInt(2, goodsid);
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
	
	public boolean setupgoodsDate(int goodsid, String goodsdate){
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			String sql = "update goods set goodsDate = ? where goodsID = ?";
			pres = conn.prepareStatement(sql);
			pres.setString(1, goodsdate);
			pres.setInt(2, goodsid);
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
	
	public boolean setupgoodsVIPmoney(int goodsid, BigDecimal vipmoney){
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			String sql = "update goods set goodsVIPmoney = ? where goodsID = ?";
			pres = conn.prepareStatement(sql);
			pres.setBigDecimal(1, vipmoney);
			pres.setInt(2, goodsid);
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
	
	public boolean setupgoodsMoney(int goodsid, BigDecimal money){
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			String sql = "update goods set goodsMoney = ? where goodsID = ?";
			pres = conn.prepareStatement(sql);
			pres.setBigDecimal(1, money);
			pres.setInt(2, goodsid);
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
	
	public boolean setupgoodsNum(int goodsid, int num){
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			String sql = "update goods set goodsNum = ? where goodsID = ?";
			pres = conn.prepareStatement(sql);
			pres.setInt(1, num);
			pres.setInt(2, goodsid);
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
