package com.shop.JFrame;
/***用户选择界面***/

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
import com.shop.JFrame.UserLogin;
import com.shop.JFrame.UserRegion.Myaction;

public class UserSelect extends JFrame {
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	private final JButton button2 = new JButton();
	private final JButton button3 = new JButton();
	
	private final JLabel label = new JLabel();//文本标签
	private final JLabel label0 = new JLabel();//文本标签
	private final JLabel label1 = new JLabel();//用户名
	private final JLabel label2 = new JLabel();//用户名
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box0 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	
	private String username;
	
	public void getName(String name) {
		this.username = name;
	}
	
	public UserSelect(String username) {
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("用  户  服  务  选  择  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		
		label1.setText("欢迎  " + username + "  VIP用户");
		label1.setFont(new Font("微软雅黑",0,20));
		//购买商品
		button.setText("1、 购  买  商  品 ");
		button.setFont(new Font("微软雅黑",1,18));
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button) {
					dispose();
					UserBuy buy = new UserBuy(username);
					buy.getName(username);
				}
			}			
		});
		//查看购物车
		button2.setText("2、 查  看  购  物  车 ");
		button2.setFont(new Font("微软雅黑",1,18));
		button2.setBorderPainted(false);
		button2.setBackground(Color.WHITE);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button2) {
					dispose();
					UserBuylook look = new UserBuylook(username);
					look.getName(username);
				}
			}			
		});
				
		//退出登录
		button1.setText("3、 退    出    登    录");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					Option2 option = new Option2();
					dispose();
				}
			}			
		});
		//返回商城主界面
		button3.setText("4、返 回 商 城 主 界 面");
		button3.setFont(new Font("微软雅黑",1,18));
		button3.setBorderPainted(false);
		button3.setBackground(Color.WHITE);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button3) {
					dispose();
					IndexWelcome welcome = new IndexWelcome();
				}
			}			
		});
		box.add(label);
		box0.add(label0);
		box1.add(label1);
		//box1.add(Box.createVerticalStrut(40));
		box2.add(button);
		box2.add(Box.createVerticalStrut(40));
		box3.add(button2);
		box3.add(Box.createVerticalStrut(40));
		box4.add(button1);
		box4.add(Box.createVerticalStrut(40));
		box5.add(button3);
		box5.add(Box.createVerticalStrut(40));
		
		
		base.add(box);
		base.add(Box.createVerticalStrut(40));
		base.add(box0);
		base.add(Box.createVerticalStrut(40));
		base.add(box1);
		base.add(Box.createVerticalStrut(25));
		base.add(box2);
		base.add(Box.createVerticalStrut(25));
		base.add(box3);
		base.add(Box.createVerticalStrut(25));
		base.add(box4);
		base.add(Box.createVerticalStrut(25));
		base.add(box5);
		base.add(Box.createVerticalStrut(25));
		
		contenctPanel.add(base);
		add(contenctPanel);
		
	}
}
