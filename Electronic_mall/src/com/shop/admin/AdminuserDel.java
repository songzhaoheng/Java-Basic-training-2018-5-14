package com.shop.admin;
/***管理员删除用户界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.Timewait;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AdminuserDel {
	
	public void userDel() {
		Timewait wait = new Timewait();
		
		AdminWelcome welcome = new AdminWelcome();
		
		DBuser user = new DBuser();
		user.getUser();
		
		DBuserDel del = new DBuserDel();
		
		DBuserName username = new DBuserName();
		
		DBuserId id = new DBuserId();
		
		DBcostDel costdel = new DBcostDel();
		
		Scanner cin = new Scanner(System.in);
		out.print("\n\n\t\t这是所有的用户，请您输入用户序号进行删除：");
		int n = cin.nextInt();
		String uname = username.getuserName(n);
		if(n < 1 || id.getuserID(n) != n) {
			out.println("\n\t\t您输入的用户序号不存在！\n");
			wait.wait1000();
			userDel();
		}else if(del.setDeluser(n)) {
			costdel.Costdel(uname);
			out.println("\n\t\t"+ uname +"用户删除成功！\n");
			out.print("\n\n\t\t请问您是否还要继续删除(输入 Y/y 继续执行操作，否则返回管理员主界面)：");
			String str = cin.next();
			if(str.equals("Y") || str.equals("y")) {
				wait.wait500();
				userDel();
			}else {
				out.println("\n\n\t\t即将返回管理员主界面，请稍后！\n");
				wait.wait1000();
				welcome.getWelcome();
			}
		}else {
			out.println("\n\t\t"+ uname +"用户删除失败，请重新删除！\n");
			wait.wait2000();
			userDel();
		}
	}
	
}
