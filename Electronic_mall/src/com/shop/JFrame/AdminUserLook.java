package com.shop.JFrame;
/***管理员查看用户信息界面***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.concurrent.TimeUnit;
import com.shop.JFrame.*;
import com.shop.JFrame.AdminSelect;
import com.shop.JFrame.UserSelect;
import com.shop.JFrame.UserRegion.Myaction;



public class AdminUserLook extends JFrame {
	
	private String adminname;
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	private final JPanel contenctPanel = new JPanel();
	
	//private final JPasswordField password = new JPasswordField();//密码文本框
	
	private final JLabel label = new JLabel();
	private final JLabel label0 = new JLabel();
	private final JLabel label1 = new JLabel();

	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box0 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	
	private JTextArea text= new JTextArea();
	public void getName(String name) {
		this.adminname = name;
	}
	
	public AdminUserLook(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DBuser user = new DBuser();
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("查  看  用  户  信  息  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		text.setSize(700, 700);
		//text.setFont(new Font("微软雅黑",0,13));
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try {
			pres = conn.prepareStatement("select * from user");
			res = pres.executeQuery();	//执行查询语句
			text.setText("----用 户 序 号-----"+"---用 户 名------"+"-------用 户 密 码------"+"-------用 户 身 份 证 号-----------"+"--用 户 年 龄------"+"--用 户 邮 箱-----------"+"--用 户 地 址----");
			
			while(res.next()){
				int id = res.getInt("userId");
				String name = res.getString("userName");
				String pass = res.getString("userPass");
				String card = res.getString("userCard");
				int age = res.getInt("userAge");
				String email = res.getString("userEmail");
				String address = res.getString("userAddress");
				text.append("\n"+"     "+id+" \t "+name+"\t  "+pass+"    "+card+"\t    "+age+" \t "+email+"  "+address+"\n");
			}
			
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(700, 700);
		
		button1.setText("返回管理员服务主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
					dispose();
				}
			}			
		});
		
		box.add(label);
		box0.add(label0);
		box1.add(label1);
		box2.add(scroll);
		box3.add(button1);
		
		base.add(box);
		base.add(Box.createVerticalStrut(40));
		base.add(box0);
		base.add(Box.createVerticalStrut(20));
		base.add(box1);
		base.add(Box.createVerticalStrut(30));
		base.add(box2);
		base.add(Box.createVerticalStrut(30));
		base.add(box3);
		base.add(Box.createVerticalStrut(30));
		
		contenctPanel.add(base);
		add(contenctPanel);
		setVisible(true);
	}

}
