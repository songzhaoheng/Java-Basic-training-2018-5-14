package com.shop.user;
/***用户购物车界面***/

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

public class UserShop {
	
	public void Shop(String username) {
		
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		while(true) {
			DBcost cost = new DBcost();
			cost.getCost(username);
			
			DBcostDel costdel = new DBcostDel();
			out.println("\n\t\t\t尊敬的  "+ username + "  会员");
			out.println("\n\t\t\t这是您所购买的商品！");
			out.print("\n\n\t\t\t输入 Y 购买商品,输入 N 清空购物车：");
			String str = cin.next();
			if(str.equals("Y") || str.equals("y") || str.equals("N") || str.equals("n")) {
				costdel.Costdel(username);
				out.println("\n\n\t\t\t\t成功!!!");
				wait.wait500();
				out.println("\n\t\t\t\t即将返回用户主界面，请稍后！");
				wait.wait2000();
				UserSelect userselect = new UserSelect();
				userselect.Select(username);
			}else {
				out.println("\n\n\t\t\t您的输入有误，请重新输入！");
				wait.wait1500();
				continue;
			}
		}

	}
}
