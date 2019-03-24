package com.shop.admin;
/***管理员商品删除界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.Timewait;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AdmingoodsDel {
	
	public void goodsDel() {
		
		Timewait wait = new Timewait();
		
		DBgoods goods = new DBgoods();
		goods.getGoods();
		
		DBgoodsId id = new DBgoodsId();
		
		DBgoodsDel del = new DBgoodsDel();
		
		DBgoodsName goodsname = new DBgoodsName();
		Scanner cin = new Scanner(System.in);
		out.print("\n\n\t\t这是所有的商品，请您输入商品序号进行删除：");
		int n = cin.nextInt();
		String gname = goodsname.getgoodsName(n);
		if(n < 1 || id.getgoodsID(n) != n || id.getgoodsID(n) == 0) {
			out.println("\n\t\t您输入的商品序号不存在！\n");
			wait.wait1000();
			goodsDel();
		}else if(del.setDelgoods(n)) {
			out.println("\n\t\t"+ gname +"商品删除成功\n");
			out.print("\n\n\t\t请问您是否还要继续删除(输入 Y/y 继续执行操作，否则返回管理员主界面)：");
			String str = cin.next();
			if(str.equals("Y") || str.equals("y")) {
				wait.wait500();
				goodsDel();
			}else {
				out.println("\n\n\t\t即将返回管理员主界面，请稍后！\n");
				wait.wait1000();
				AdminWelcome welcome = new AdminWelcome();
				welcome.getWelcome();
			}
		}
	}
}
