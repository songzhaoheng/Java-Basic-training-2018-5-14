package com.shop.admin;
/***管理员添加商品界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class AdminInsertgoods {
	
	public void Insertgoods() {
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		
		DBgoodsNamedecide decide = new DBgoodsNamedecide();
		
		DBgoodsInsert insert = new DBgoodsInsert();
		
		out.print("\n\t\t请您输入商品名称：");
		String goodsname = cin.next();
		if(decide.decideGoodsname(goodsname)) {
			out.println("\n\t\t您输入的商品名称已存在，请重新输入！");
			wait.wait500();
			Insertgoods();
		}
		
		out.print("\n\t\t请您输入商品生产日期（样式：2018-01-01）：");
		String date = cin.next();
		out.print("\n\t\t请您输入商品的会员价格：");
		BigDecimal vipmoney = cin.nextBigDecimal();
		out.print("\n\t\t请您输入商品的非会员价格：");
		BigDecimal money = cin.nextBigDecimal();
		out.print("\n\t\t请您输入商品的数量：");
		int num = cin.nextInt();
		if(insert.Goodsinsert(goodsname, date, vipmoney, money, num)) {
			out.println("\n\t\t\t商品添加成功！\n");
			out.print("\n\n\t\t请问您是否还要继续删除(输入 Y/y 继续执行操作，否则返回管理员主界面)：");
			String str = cin.next();
			if(str.equals("Y") || str.equals("y")) {
				wait.wait500();
				Insertgoods();
			}else {
				out.println("\n\n\t\t即将返回管理员主界面，请稍后！\n");
				wait.wait1000();
				AdminWelcome welcome = new AdminWelcome();
				welcome.getWelcome();
			}
		}else {
			out.println("\n\t\t\t商品添加失败，请您重新添加！\n");
			wait.wait2000();
			Insertgoods();
		}
	}

}
