package com.shop.JFrame;
/***用户登录界面***/

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
import com.shop.JFrame.UserRegion.Myaction;

public class UserLogin extends JFrame {
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(10);//姓名
	private final JTextField field1 = new JTextField(10);//密码
	private final JTextField field2 = new JTextField(10);//随机验证码

	private final JPasswordField password1 = new JPasswordField();//密码文本框
	
	private final JLabel label = new JLabel();//文本标签
	private final JLabel label0 = new JLabel();//文本标签
	private final JLabel label1 = new JLabel();//用户名
	private final JLabel label2 = new JLabel();//密码
	private final JLabel label3 = new JLabel();//随机验证码
	
	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box0 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	
	private String username, password, address, useremail, card;
	private int age;
	
	public void getName(String name) {
		this.username = name;
	}
	
	public UserLogin() {
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("用  户  登  录  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		//用户名
		label1.setText("请 输 入 用 户 名：");
		label1.setFont(new Font("微软雅黑",0,18));
		field.addActionListener(new Myaction());
				
		//密码
		label2.setText("请   输  入  密  码：");
		label2.setFont(new Font("微软雅黑",0,18));
		field1.addActionListener(new Myaction());
		password1.setText(password);
		
		//随机验证码
		Rand rand= new Rand();
		int num = rand.getRandom();
		label3.setText("验 证 码 ( "+ num +" )：");
		label3.setFont(new Font("微软雅黑",0,18));
		field2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == field2) {
					String str = field2.getText();
					int n = Integer.parseInt(str);
					if(n != num) {
						JOptionPane.showMessageDialog(null,"验证码不正确", "错误",JOptionPane.ERROR_MESSAGE); 
						field2.setText("");
					}
				}
			}			
		});
		
		
		//登录按钮
		button.setText("登  录");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		//返回商城主界面
		button1.setText("   返回商城主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					IndexWelcome welcome = new IndexWelcome();
				}
			}			
		});
		

		box.add(label);
		box0.add(label0);
		box1.add(label1);
		box1.add(field);
		box2.add(label2);
		box2.add(password1);
		box3.add(label3);
		box3.add(field2);
		box4.add(button);
		box4.add(button1);
		
		base.add(box);
		base.add(Box.createVerticalStrut(40));
		base.add(box0);
		base.add(Box.createVerticalStrut(40));
		base.add(box1);
		base.add(Box.createVerticalStrut(30));
		base.add(box2);
		base.add(Box.createVerticalStrut(30));
		base.add(box3);
		base.add(Box.createVerticalStrut(50));
		base.add(box4);
		base.add(Box.createVerticalStrut(50));
		
		contenctPanel.add(base);
		add(contenctPanel);
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			DBuserPassdecide passdecide = new DBuserPassdecide();
			DBuserNamedecide namedecide = new DBuserNamedecide();
			
			if(e.getSource() == button) {
				
				//获取文本框输入的信息
				username = field.getText();
				password = password1.getText();
				
				//判断用户名、密码
				if(namedecide.decideUsername(username) == false) {
					JOptionPane.showMessageDialog(null,"用户不存在，请重新输入！", "错误",JOptionPane.ERROR_MESSAGE); 
					field.setText("");
				}else if(passdecide.decideUserpass(username, password) == false) {
					JOptionPane.showMessageDialog(null,"密码不正确，请重新输入！", "错误",JOptionPane.ERROR_MESSAGE); 
					field1.setText("");
				}else{
					dispose();
					UserSelect userselect = new UserSelect(username);//跳转到用户服务选择界面
					userselect.getName(username);
				}
			}
		}
		
	}

}
