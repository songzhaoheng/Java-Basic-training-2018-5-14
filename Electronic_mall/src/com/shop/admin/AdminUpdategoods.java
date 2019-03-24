package com.shop.admin;
/***管理员修改商品界面***/

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

public class AdminUpdategoods {
	
	Scanner cin = new Scanner(System.in);
	
	public void Updategoods() {
		
		Timewait wait = new Timewait();

		DBgoods goods = new DBgoods();

		DBgoodsUP up = new DBgoodsUP();
		
		out.println("\t\t***************  修 改 商 品 信 息 ***************\n\n");
		out.println("\n\t\t\t1、修改商品名称");
		out.println("\n\t\t\t2、修改商品生产日期");
		out.println("\n\t\t\t3、修改商品会员价格");
		out.println("\n\t\t\t4、修改商品非会员价格");
		out.println("\n\t\t\t5、修改商品数量");
		out.print("\n\n\t\t请您输入数字进行选择：");
		int n = cin.nextInt();
		goods.getGoods();
		wait.wait500();
		int goodsid;

		while(true) {
			out.print("\n\n\t\t这是所有的商品，请您输入商品序号进行修改：");
			goodsid = cin.nextInt();
			DBgoodsId id = new DBgoodsId(); 
			if(goodsid < 1 || id.getgoodsID(goodsid) != goodsid || id.getgoodsID(goodsid) == 0) {
				out.print("\n\t\t您输入的商品序号不存在，请重新输入：");
				continue;
			}else {
				break;
			}
		}
		
		switch(n) {
			case 1:{
				out.print("\n\t\t您输入新的的商品名称：");
				String name = cin.next();
				up.setupgoodsName(goodsid, name);
				AdminUpdategoods update = new AdminUpdategoods();
				update.back();
				break;
				
			}case 2:{
				out.print("\n\t\t您输入新的的商品生产日期：");
				String date = cin.next();
				up.setupgoodsDate(goodsid, date);
				AdminUpdategoods update = new AdminUpdategoods();
				update.back();
				break;
				
			}case 3:{
				out.print("\n\t\t您输入新的的商品会员价格：");
				BigDecimal vipmoney = cin.nextBigDecimal();
				up.setupgoodsVIPmoney(goodsid, vipmoney);
				AdminUpdategoods update = new AdminUpdategoods();
				update.back();
				break;
				
			}case 4:{
				out.print("\n\t\t您输入新的的商品非会员价格：");
				BigDecimal money = cin.nextBigDecimal();
				up.setupgoodsMoney(goodsid, money);
				AdminUpdategoods update = new AdminUpdategoods();
				update.back();
				break;
				
			}case 5:{
				out.print("\n\t\t您输入新的的商品数量：");
				int num = cin.nextInt();
				up.setupgoodsNum(goodsid, num);
				AdminUpdategoods update = new AdminUpdategoods();
				update.back();
				break;
				
			}default:{
				out.println("\n\t\t您的输入有误!");
				break;
			}
		
		}
		
	}
	
	public void back() {
		Timewait wait = new Timewait();
		AdminUpdategoods up = new AdminUpdategoods();
		
		out.println("\n\t\t修改成功!");
		out.print("\n\n\t\t请问您是否还要继续删除(输入 Y/y 继续执行操作，否则返回管理员主界面)：");
		
		String str = cin.next();
		if(str.equals("Y") || str.equals("y")) {
			wait.wait500();
			up.Updategoods();
		}else {
			out.println("\n\n\t\t即将返回管理员主界面，请稍后！\n");
			wait.wait1000();
			AdminWelcome welcome = new AdminWelcome();
			welcome.getWelcome();
		}
	}
}
