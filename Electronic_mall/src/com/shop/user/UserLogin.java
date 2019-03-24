package com.shop.user;
/***用户登录界面***/

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

public class UserLogin {
	
	Scanner cin = new Scanner(System.in);
	public void getLogin() {
		int cout = 0;//计数器
		Timewait wait = new Timewait();
		DBuserPassdecide passdecide = new DBuserPassdecide();
		DBuserNamedecide namedecide = new DBuserNamedecide();
		
		out.println("\t\t***************  欢迎登录 Hern 电子商城账户  ***************\n\n");
		out.println("\t\t\t0、没有商城账户（注册账户）\n");
		out.println("\t\t\t1、有商城账户（账户登录）\n");
		out.print("\n\t\t\t请输入数字进行您的选择：");
		int i = cin.nextInt();
		if(i == 0){
			UserRegion reg = new UserRegion();
			reg.getRegion();
		}else if(i != 1){
			System.out.println("\t\t\t您输入的选项有错请重新输入选择!");
			getLogin();
		}
		out.print("\n\n\t\t\t请您输入用户名：");
		String username = cin.next();//用户名
		String password;//用户密码
	
		if(namedecide.decideUsername(username)){
			out.print("\n\t\t\t请您输入密码：");
			password = cin.next();
			if(passdecide.decideUserpass(username, password)) {
				
				while(true) {
					Rand rand= new Rand();
					int num = rand.getRandom();
					out.print("\n\t\t\t请您输入随机验证码（"+ num +")：");
					int n = cin.nextInt();
					if(n != num) {
						out.println("\n\t\t\t您输入的验证码不正确，请重新输入！\n");
						continue;
					}
					else {
						out.println("\n\t\t\t尊敬的  "+ username + "  会员恭喜您登录成功！！！");
						out.println("\n\t\t\t\t即将进入用户界面，请稍后！");
						wait.wait1000();
						
						UserSelect userselect = new UserSelect();
						userselect.Select(username);
					}
				}
				
			}else {
				out.println("\n\t\t\t您输入的密码不正确，请重新输入！！！");
				out.println("\n\t\t\t您现在已经输入 " + cout + " 次密码（最多只能尝试输入三次）！");
				if(cout < 4){
					cout++;
					getLogin();
				}else{
					cout = 0;//恢复cout计数器初值
					out.println("\n\t\t\t\t您现在已经输入 3 次密码，请返回商城主界面找回密码！");
					out.println("\n\t\t\t\t即将返回商城主界面，请稍后！");
					wait.wait1000();
					Welcome welcome = new Welcome();
					welcome.getWelcome();
				}
			}
		}else {
			out.println("\n\t\t\t您输入的用户名不正确，请重新输入！！！");
			wait.wait1000();
			getLogin();
		}
			
	}
	
}
