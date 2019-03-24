package com.shop.admin;
/***管理员欢迎界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AdminWelcome {
	
	public void getWelcome() {
		
		out.println("\t\t***************  欢迎来到 Hern 商城管理员界面 ***************\n");
		out.println(" \t\t\t\t1、添加商品\n");
		out.println(" \t\t\t\t2、修改商品\n");
		out.println(" \t\t\t\t3、删除商品\n");
		out.println(" \t\t\t\t4、查看用户列表\n");
		out.println(" \t\t\t\t5、删除用户\n");
		out.println(" \t\t\t\t6、管理员注册\n");
		out.println(" \t\t\t\t7、退出管理员登录\n");
		AdminSelect select = new AdminSelect();
		select.getSelect();
	}

}
