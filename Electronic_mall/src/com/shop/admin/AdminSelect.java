package com.shop.admin;
/***管理员选择界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AdminSelect {
	
	public void getSelect() {
		Timewait wait = new Timewait();
		Scanner cin = new Scanner(System.in);
		out.print("\t\t请您输入数字进行选择：");
		int n = cin.nextInt();
		
		switch(n){
		
			case 1:{//添加商品
				
				out.println("\n\t\t\t你选择的是 添加商品 选项，请稍后！\n");
				AdminInsertgoods insert = new AdminInsertgoods();
				insert.Insertgoods();
				wait.wait500();
				break;
				
			}case 2:{//修改商品
				out.println("\n\t\t\t你选择的是 用户登录 选项，请稍后！\n");
				AdminUpdategoods update = new AdminUpdategoods();
				update.Updategoods();
				wait.wait500();
				break;
				
			}case 3:{//删除商品
				
				out.println("\n\t\t\t你选择的是 修改商品 选项，请稍后！\n");
				wait.wait500();
				AdmingoodsDel del = new AdmingoodsDel();
				del.goodsDel();
				break;
				
			}case 4:{//查看用户列表
				
				out.println("\n\t\t\t你选择的是 查看用户列表 选项，请稍后！\n");
				AdminSearchuser user =  new AdminSearchuser();
				user.Searchuser();
				break;
				
			}case 5:{//删除用户
				
				out.println("\n\t\t\t你选择的是 删除用户 选项，请稍后！\n");
				wait.wait500();
				AdminuserDel del = new AdminuserDel();
				del.userDel();
				break;
				
			}case 6:{//管理员注册
				
				out.println("\n\t\t\t你选择的是 管理员注册 选项，请稍后！\n");
				wait.wait500();
				AdminRegion region = new AdminRegion();
				region.getRegion();
				break;
				
			}case 7:{//退出管理员登录
			
				out.println("\n\t\t\t你选择的是 退出管理员登录 选项，请稍后！\n");
				wait.wait500();
				out.println("\n\t\t\t即将返回商城主界面，请稍后！\n");
				wait.wait1500();
				Welcome welcome = new Welcome();
				welcome.getWelcome();
				break;
				
			}default:{//输入错误选项
				
				out.println("\n\t\t\t你输入的选项有误，请重新输入！\n");
				wait.wait500();
				AdminWelcome welcome = new AdminWelcome();
				welcome.getWelcome();
				break;
			}
		}
	}

}
