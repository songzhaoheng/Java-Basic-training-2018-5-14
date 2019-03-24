package com.shop.user;
/***用户注册界面***/

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

public class UserRegion {
	
	public void getRegion() {
		
		Scanner cin = new Scanner(System.in);
		Timewait wait = new Timewait();
		out.println("\t\t***************  欢迎注册 Hern 电子商城账户  ***************\n\n");
		out.print("\t\t请您输入用户名（数字、字母混合，长度大于5位、小于16位）：");
		
		String username = cin.next();//用户名
		String password;//用户密码
		String card;//用户身份证号
		int age;//用户年龄
		String useremail;//用户邮箱
		String address;//用户地址
		
		DBuserNamedecide dbusername = new DBuserNamedecide();
		DBuserregion insert = new DBuserregion();
		if( dbusername.decideUsername(username)){
			out.println("\n\t\t您输入的用户名已存在，请重新注册！");
			wait.wait500();
			getRegion();	
		}else if(username.length() < 6 || username.length() > 16){
			out.println("\n\t\t您输入的长度不符合规范，请重新注册！\n");
			wait.wait500();
			getRegion();
		}else {
			UserDecide userdecide = new UserDecide();
			if(userdecide.Decide(username) == false) {
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
			out.print("\n\t\t请您输入身份证号码：");
			card = cin.next();
			if(card.length() != 18) {
				out.println("\n\t\t您输入的身份证不符合规范，请重新注册！\n");
				wait.wait500();
				getRegion();
			}
			out.print("\n\t\t请您输入年龄(要求年龄在18~65岁之间)：");
			age = cin.nextInt();
			if(age < 18 || age > 65) {
				out.println("\n\t\t您输入的年龄不符合规范，请重新注册！\n");
				wait.wait500();
				getRegion();
			}
			out.print("\n\t\t请您输入邮箱地址：");
			useremail = cin.next();
			if(userdecide.Email(useremail) == false) {
				out.println("\n\t\t您输入的邮箱不符合规范，请重新注册！\n");
				wait.wait500();
				getRegion();
			}
			
			out.print("\n\t\t请您输入联系地址：");
			address = cin.next();
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
					if(insert.insertUser(username, password, card, age, useremail, address)) {
						out.println("\n\t\t    尊敬的  " + username + "  会员，恭喜您注册成功！\n");
						out.println("\n\n\t\t即将返回商城主界面，请稍后！");
						wait.wait2000();
						Welcome welcome = new Welcome();
						welcome.getWelcome();
					}
				}
			}
		}
	}
}
