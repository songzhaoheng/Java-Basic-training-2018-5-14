package com.shop.index;

/***商城欢迎界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Welcome {
	
	public void getWelcome() {
		out.println("\t\t***************  欢迎来到 Hern 电子商城  ***************\n");
		out.println(" \t\t\t\t1、用户注册\n");
		out.println(" \t\t\t\t2、用户登录\n");
		out.println(" \t\t\t\t3、查看商城商品\n");
		out.println(" \t\t\t\t4、查看我购买的商品\n");
		out.println(" \t\t\t\t5、管理员登录\n");
		out.println(" \t\t\t\t6、找回账户、密码\n");
		out.println(" \t\t\t\t7、退出系统\n");
		Select select = new Select();
		select.getSelect();
	}
}
