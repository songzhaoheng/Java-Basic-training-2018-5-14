package com.shop.user;
/***用户选择界面***/

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

public class UserSelect {
	
	public void Select(String username) {
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		
		while(true) {
			out.println("\n\t\t\t尊敬的  "+ username + "  会员");
			out.println("\n\t\t\t  1、查看购物车");
			out.println("\n\t\t\t  2、购买商品");
			out.println("\n\t\t\t  0、退出用户登录");
			out.print("\n\n\t\t\t请输入数字进行选择：");
			int selectnum  = cin.nextInt();
			if(selectnum == 1) {
				UserShop shop = new UserShop();
				shop.Shop(username);
			}else if(selectnum == 2) {
				Userbuy buy = new Userbuy();
				buy.Buy(username);
				
			}else if(selectnum == 0){
				out.println("\n\t\t    尊敬的  " + username + "  会员，即将返回商城主界面，请稍后！");
				wait.wait2000();
				Welcome welcome = new Welcome();
				welcome.getWelcome();
			}else {
				out.println("\n\n\t\t\t您的输入有误，请重新输入！");
				wait.wait500();
				continue;
			}
			
		}
	}

}
