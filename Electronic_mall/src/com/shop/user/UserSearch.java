package com.shop.user;
/***找回账户、密码界面***/

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

public class UserSearch {
	Scanner cin = new Scanner(System.in);
	
	public void getSearch() {
		
		while(true) {
			Timewait wait = new Timewait();
			DBuserCarddecide decide = new DBuserCarddecide();
			
			out.print("\n\n\t\t\t请输入您的身份证号码：");
			String card = cin.next();
			out.print("\n\n\t\t\t请输入您的邮箱：");
			String email = cin.next();
			if(decide.decideUsercard(card, email)) {
				out.println("\n\t\t\t\t找回账户、密码!");
				out.print("\n\n\t\t\t输入任意键返回商城主界面：");
				String str = cin.next();

				wait.wait1000();
				Welcome welcome = new Welcome();
				welcome.getWelcome();
				
			}else {
				out.println("\n\n\t\t\t您输入的用户信息有错，请重新输入!");
				wait.wait1000();
				continue;
			}
		}
		
	}

}
