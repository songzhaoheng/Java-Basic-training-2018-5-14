package com.shop.admin;
/***管理员查看用户界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AdminSearchuser {
	
	public void Searchuser() {
		Timewait wait = new Timewait();
		Scanner cin = new Scanner(System.in);
		DBuser user = new DBuser();
		user.getUser();
		out.print("\n\n\t\t这是所有的用户，输入任意键返回管理员主界面：");
		String str = cin.next();
		out.println("\n\n\t\t即将返回管理员主界面，请稍后！");
		wait.wait2000();
		AdminWelcome welcome = new AdminWelcome();
		welcome.getWelcome();
	}

}
