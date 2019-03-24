package com.shop.index;
/***商城选择界面***/

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

public class Select {
	
	public void getSelect()  {
		
		Timewait wait = new Timewait();
		Scanner cin = new Scanner(System.in);
		out.print("\t\t请您输入数字进行选择：");
		int n = cin.nextInt();
		switch(n){
			case 1:{//用户注册选项
				out.println("\n\t\t\t你选择的是 用户注册 选项，请稍后！\n");
				wait.wait500();
				UserRegion region = new UserRegion();
				region.getRegion();
				break;
				
			}case 2:{//用户登录选项
				out.println("\n\t\t\t你选择的是 用户登录 选项，请稍后！\n");
				wait.wait500();
				UserLogin login = new UserLogin();
				login.getLogin();
				break;
				
			}case 3:{//查看商城选项
				out.println("\n\t\t\t你选择的是 查看商城商品 选项，请稍后！\n");
				wait.wait500();
				UserLookgoods look = new UserLookgoods();
				look.getLookgoods();
				break;
				
			}case 4:{//查看我购买的商品选项
				out.println("\n\t\t\t你选择的是 查看我购买的商品 选项，请稍后！\n");
				wait.wait500();
				UserLogin login = new UserLogin();
				login.getLogin();
				break;
				
			}case 5:{//管理员登录选项
				out.println("\n\t\t\t你选择的是 管理员登录 选项，请稍后！\n");
				wait.wait500();
				AdminLogin login = new AdminLogin();
				login.getLogin();
				break;
				
			}case 6:{//找回账户、密码
				out.println("\n\t\t\t你选择的是 找回账户、密码 选项，请稍后！\n");
				wait.wait500();
				UserSearch search = new UserSearch();
				search.getSearch();
				break;
				
			}case 7:{//退出系统选项
				out.println("\n\t\t\t你选择的是 退出系统 选项，请稍后！\n");
				wait.wait2000();
				System.exit(0);
				break;
				
			}default:{//输入错误选项
				out.println("\n\t\t\t你输入的选项有误，请重新输入！\n");
				wait.wait500();
				Welcome welcome = new Welcome();
				welcome.getWelcome();
				break;
			}
		}
	}

}
