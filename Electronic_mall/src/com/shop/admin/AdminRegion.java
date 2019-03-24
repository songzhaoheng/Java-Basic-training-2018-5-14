package com.shop.admin;
/***管理员注册界面***/

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

public class AdminRegion {
	
	public void getRegion() {
		
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		out.println("\t\t***************  欢迎注册 Hern 电子商城管理员账户  ***************\n\n");
		out.print("\t\t请您输入用户名（数字、字母混合，长度大于5位、小于16位）：");
		
		String adminname = cin.next();//用户名
		String password;//用户密码
		
		DBadminNamedecide dbadminname = new DBadminNamedecide();
		DBadminRegion insert = new DBadminRegion();
		if( dbadminname.decideAdminname(adminname)){
			out.println("\n\t\t您输入的用户名已存在，请重新注册！");
			wait.wait500();
			getRegion();	
		}else if(adminname.length() < 6 || adminname.length() > 16){
			out.println("\n\t\t您输入的长度不符合规范，请重新注册！\n");
			wait.wait500();
			getRegion();
		}else {
			UserDecide userdecide = new UserDecide();
			if(userdecide.Decide(adminname) == false) {
				out.println("\n\t\t您输入的用户名不符合规范，请重新注册！\n");
				wait.wait500();
				getRegion();
			}
			
			out.print("\n\t\t请您输入密码：");
			password = cin.next();
			if(userdecide.Decide(password) == false) {
				out.println("\n\t\t您输入的密码不符合规范，请重新注册！\n");
				wait.wait500();
				getRegion();
			}
			
			while(true) {
				Rand rand= new Rand();
				int num = rand.getRandom();
				out.print("\n\t\t请您输入随机验证码（"+ num +")：");
				int n = cin.nextInt();
				if(n != num) {
					out.println("\t\t您输入的验证码不正确，请重新输入！\n");
					continue;
				}
				else {
					if(insert.insertAdmin(adminname,password )) {
						out.println("\n\n\t\t    尊敬的  " + adminname + "  管理员，恭喜您注册成功！\n");
						out.println("\n\n\t\t\t\t即将进入管理员主界面，请稍后！");
						wait.wait2000();
						AdminWelcome welcome = new AdminWelcome();
						welcome.getWelcome();
					}
				}
			}
		}
	}
}
