package com.shop.JFrame;
/***商城主界面***/

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

public class IndexWelcome extends JFrame {
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JButton button1 = new JButton();
	private final JButton button2 = new JButton();
	private final JButton button3 = new JButton();
	private final JButton button4 = new JButton();
	private final JButton button5 = new JButton();
	private final JButton button6 = new JButton();
	private final JButton button7 = new JButton();

	private final JLabel label = new JLabel();//文本标签
	private final JLabel label1 = new JLabel();//文本标签
	
	private final Box base = Box.createVerticalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box6 = Box.createHorizontalBox();
	private final Box box7 = Box.createHorizontalBox();
	private final Box box8 = Box.createHorizontalBox();
	private final Box box9 = Box.createHorizontalBox();
	
	public IndexWelcome() {
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label1.setText("商    城    主    界    面");
		label1.setFont(new Font("微软雅黑",0,25));
		
		button1.setText("1、用       户       注       册");
		button1.setBackground(Color.WHITE);
		button1.setFont(new Font("微软雅黑",0,18));
		button1.setBorderPainted(false);
		
		button2.setText("2、用       户       登       录");
		button2.setBackground(Color.WHITE);
		button2.setFont(new Font("微软雅黑",0,18));
		button2.setBorderPainted(false);
		
		button3.setText("3、查   看   商   城   商   品");
		button3.setBackground(Color.WHITE);
		button3.setFont(new Font("微软雅黑",0,18));
		button3.setBorderPainted(false);
		
		button4.setText("4、查 看 我 购 买 的 商 品");
		button4.setBackground(Color.WHITE);
		button4.setFont(new Font("微软雅黑",0,18));
		button4.setBorderPainted(false);
		
		button5.setText("5、管    理    员    登    录");
		button5.setBackground(Color.WHITE);
		button5.setFont(new Font("微软雅黑",0,18));
		button5.setBorderPainted(false);
		
		button6.setText("6、找  回  账  户、密  码");
		button6.setBackground(Color.WHITE);
		button6.setFont(new Font("微软雅黑",0,18));
		button6.setBorderPainted(false);
		
		button7.setText("7、退出 Hern 电子商城");
		button7.setBackground(Color.WHITE);
		button7.setFont(new Font("微软雅黑",0,18));
		button7.setBorderPainted(false);
		
		box8.add(label);
		box9.add(label1);
		box1.add(button1);
		box1.add(Box.createVerticalStrut(40));
		box2.add(button2);
		box2.add(Box.createVerticalStrut(40));
		box3.add(button3);
		box3.add(Box.createVerticalStrut(40));
		box4.add(button4);
		box4.add(Box.createVerticalStrut(40));
		box5.add(button5);
		box5.add(Box.createVerticalStrut(40));
		box6.add(button6);
		box6.add(Box.createVerticalStrut(40));
		box7.add(button7);
		box7.add(Box.createVerticalStrut(40));
		
		base.add(box8);
		base.add(Box.createVerticalStrut(40));
		base.add(box9);
		base.add(Box.createVerticalStrut(40));
		base.add(box1);
		base.add(Box.createVerticalStrut(40));
		base.add(box2);
		base.add(Box.createVerticalStrut(40));
		base.add(box3);
		base.add(Box.createVerticalStrut(40));
		base.add(box4);
		base.add(Box.createVerticalStrut(40));
		base.add(box5);
		base.add(Box.createVerticalStrut(40));
		base.add(box6);
		base.add(Box.createVerticalStrut(40));
		base.add(box7);
		base.add(Box.createVerticalStrut(40));
		contenctPanel.add(base);
		add(contenctPanel);
		

		/***用户注册***/
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button1) {
					dispose();//销毁窗体
					UserRegion region = new UserRegion();
					
				}
			}	
		});
		

		/***用户登录***/
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button2) {
					dispose();//销毁窗体
					UserLogin login = new UserLogin();
					
				}
			}	
		});
		

		/***查看商城商品***/
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button3) {
					dispose();//销毁窗体
					GoodsLook look = new GoodsLook();
					
				}
			}	
		});
		

		/***查看我购买的商品***/
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button4) {
					dispose();//销毁窗体
					UserLogin login = new UserLogin();
					
				}
			}	
		});
		

		/***管理员登录***/
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button5) {
					dispose();//销毁窗体
					AdminLogin admin = new AdminLogin();
					
				}
			}	
		});
		

		/***找回账户、密码***/
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button6) {
					dispose();//销毁窗体
					UserSearch search = new UserSearch();
					
				}
			}	
		});
		

		/***退出系统***/
		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == button7) {
					Option option = new Option();
					dispose();
				}
			}	
		});
		
	}

}
