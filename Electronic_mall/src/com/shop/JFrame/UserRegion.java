package com.shop.JFrame;
/***用户注册***/

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

public class UserRegion extends JFrame{

	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(10);//姓名
	private final JTextField field1 = new JTextField(10);//密码
	private final JTextField field2 = new JTextField(10);//身份证号码
	private final JTextField field3 = new JTextField(10);//年龄
	private final JTextField field4 = new JTextField(10);//邮箱地址
	private final JTextField field5 = new JTextField(10);//联系地址
	private final JTextField field6 = new JTextField(10);//随机验证码
	private final JTextField field7 = new JTextField(10);

	private final JPasswordField password1 = new JPasswordField();//密码文本框
	
	private final JLabel label = new JLabel();//文本标签
	private final JLabel label0 = new JLabel();//文本标签
	private final JLabel label1 = new JLabel();//用户名
	private final JLabel label2 = new JLabel();//密码
	private final JLabel label3 = new JLabel();//身份证号码
	private final JLabel label4 = new JLabel();//年龄
	private final JLabel label5 = new JLabel();//邮箱地址
	private final JLabel label6 = new JLabel();//联系地址
	private final JLabel label7 = new JLabel();//随机验证码
	
	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box0 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box6 = Box.createHorizontalBox();
	private final Box box7 = Box.createHorizontalBox();
	private final Box box8 = Box.createHorizontalBox();
	
	private String username, password, address, useremail, card;
	private int age;
	
	public UserRegion(){
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("用  户  注  册  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		//用户名
		label1.setText("用户名（字母和数字）：");
		label1.setFont(new Font("微软雅黑",0,18));
		field.addActionListener(new Myaction());
		
		//密码
		label2.setText("密    码（字母和数字）：");
		label2.setFont(new Font("微软雅黑",0,18));
		field1.addActionListener(new Myaction());
		password1.setText(password);
		
		//身份证号码
		label3.setText("居  民  身  份 证  号 码 ：");
		label3.setFont(new Font("微软雅黑",0,18));
		field2.addActionListener(new Myaction());
		
		//年龄
		int a;
		label4.setText("年  龄(18 ~ 65 岁之间)：");
		label4.setFont(new Font("微软雅黑",0,18));
		field3.addActionListener(new Myaction());
		
		//邮箱地址
		label5.setText("电   子   邮    箱   地  址：");
		label5.setFont(new Font("微软雅黑",0,18));
		field4.addActionListener(new Myaction());
		
		//联系地址
		label6.setText("个   人   联   系   地   址：");
		label6.setFont(new Font("微软雅黑",0,18));
		field5.addActionListener(new Myaction());
		
		//随机验证码
		Rand rand= new Rand();
		int num = rand.getRandom();
		label7.setText("输 入 验 证 码 ( "+ num +" )：");
		label7.setFont(new Font("微软雅黑",0,18));
		field6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == field6) {
					String str = field6.getText();
					int n = Integer.parseInt(str);
					if(n != num) {
						JOptionPane.showMessageDialog(null,"验证码不正确", "错误",JOptionPane.ERROR_MESSAGE); 
						field6.setText("");
					}
				}
			}			
		});
		
		button.setText("注册");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回商城主界面");
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
		box4.add(label4);
		box4.add(field3);
		box5.add(label5);
		box5.add(field4);
		box6.add(label6);
		box6.add(field5);
		box7.add(label7);
		box7.add(field6);
		box8.add(button);
		box8.add(button1);
		
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
		base.add(box6);
		base.add(Box.createVerticalStrut(25));
		base.add(box7);
		base.add(Box.createVerticalStrut(50));
		base.add(box8);
		base.add(Box.createVerticalStrut(50));
		
		contenctPanel.add(base);
		add(contenctPanel);
		
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DBuserNamedecide dbusername = new DBuserNamedecide();//检查用户名是否重复
			UserDecide userdecide = new UserDecide();//检查用户名和密码是否为英文和数字组合，并且检查邮箱符不符合规范
			DBuserregion insert = new DBuserregion();//把用户信息添加到数据库
			// TODO Auto-generated method stub
			
			if(e.getSource() == button) {
				
				//获取文本框输入的信息
				username = field.getText();
				password = password1.getText();
				card = field2.getText();
				String str = field3.getText();
				age= Integer.parseInt(str);
				useremail = field4.getText();
				address = field5.getText();
				String option =username + "  用户恭喜您注册成功";
				
				//判断用户名、密码、年龄、身份证、邮箱地址，正确无误之后插入数据库
				if(userdecide.Decide(username) == false || dbusername.decideUsername(username)) {
					JOptionPane.showMessageDialog(null,"用户名不能重复，由字母和数字组成，至少为6位！", "错误",JOptionPane.ERROR_MESSAGE); 
					field.setText("");
				}else if(userdecide.Decide(password) == false) {
					JOptionPane.showMessageDialog(null,"密码必须由字母和数字组成，至少为6位！", "错误",JOptionPane.ERROR_MESSAGE); 
					field1.setText("");
				}else if(card.length() != 18) {
					JOptionPane.showMessageDialog(null,"身份证号码不符合要求！", "错误",JOptionPane.ERROR_MESSAGE); 
					field2.setText("");
				}else if(age < 18 || age > 65) {
					JOptionPane.showMessageDialog(null,"年龄必须在 18~65 之间！", "错误",JOptionPane.ERROR_MESSAGE); 
					field3.setText("");
				}else if(userdecide.Email(useremail) == false) {
					JOptionPane.showMessageDialog(null,"电子邮箱地址不正确！", "错误",JOptionPane.ERROR_MESSAGE); 
					field4.setText("");
				}else if(insert.insertUser(username, password, card, age, useremail, address)) {
					JOptionPane.showMessageDialog(null, option, "正确注册",JOptionPane.DEFAULT_OPTION); 
					IndexWelcome welcome = new IndexWelcome();
					dispose();
				}
			}
		}
		
	}
}
