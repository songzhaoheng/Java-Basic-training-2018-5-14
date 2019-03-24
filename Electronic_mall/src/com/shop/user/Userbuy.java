package com.shop.user;
/***购买商品界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.mysql.*;
import com.shop.other.Timewait;
import com.shop.index.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class Userbuy {
	
	public void Buy(String username) {
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		
		while(true) {
			DBgoods goods = new DBgoods();
			goods.getGoods();
			DBgoodsId goodsid = new DBgoodsId();
			DBgoodsName goodsname = new DBgoodsName();
			DBgoodsVIPmoney money = new DBgoodsVIPmoney();
			DBgoodsNum goodsnum = new DBgoodsNum();
			DBcostInsert insert = new DBcostInsert();
			DBgoodsUP update = new DBgoodsUP();
			out.println("\n\t\t\t尊敬的  "+ username + "  会员");
			out.println("\n\t\t\t这是商城所有的商品！");
			out.print("\n\n\t\t\t输入商品序号进行购买：");
			int id = cin.nextInt();
			
			if(goodsid.getgoodsID(id) == id) {
				out.print("\n\n\t\t\t输入购买的商品数量：");
				int num = cin.nextInt();
				int n = goodsnum.getgoodsNum(id);
				if(num > n || num == 0) {
					out.println("\n\n\t\t\t\t商品库存不够，请重新输入！");
					continue;
				}else {
					String name = goodsname.getgoodsName(id);//获取商品名称
					BigDecimal vip = money.getgoodsVIPmoney(id);//获取商品价格
					BigDecimal cost = vip.multiply(BigDecimal.valueOf(num));
					
					if(insert.Goodsinsert(username, id, name, vip, num, cost)) {
						out.println("\n\n\t\t\t\t购买成功！");
						out.println("\n\n\t\t\t即将返回用户主界面！");
						
						update.setupgoodsNum(id, n-num);//同时更新商品数量
						wait.wait1000();
						UserSelect userselect = new UserSelect();
						userselect.Select(username);
					}
				}
			}else {
				out.println("\n\n\t\t\t您输入的商品序号不正确，请重新输入！");
				continue;
			}
		}

	}

}
