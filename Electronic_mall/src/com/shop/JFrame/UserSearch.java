package com.shop.JFrame;
/***用户找回密码和账户界面***/

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

public class UserSearch extends JFrame {
	
	String useremail, card, username, password;
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(20);
	private final JTextField field1 = new JTextField(20);
	private final JTextField field2 = new JTextField(20);
	
	private final JLabel label = new JLabel();
	private final JLabel label1 = new JLabel();
	private final JLabel label2 = new JLabel();
	private final JLabel label3 = new JLabel();
	private final JLabel label4 = new JLabel();
	
	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	public UserSearch() {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label1.setText("找  回  账  户、密  码  界  面\n");
		label1.setFont(new Font("微软雅黑",1,25));
		
		//身份证号码
		label2.setText("身  份  证  号  码  ：");
		label2.setFont(new Font("微软雅黑",0,18));
		field.addActionListener(new Myaction());
				
		//邮箱
		label3.setText("电子邮箱(E-mail)：");
		label3.setFont(new Font("微软雅黑",0,18));
		field1.addActionListener(new Myaction());
		
		//随机验证码
		Rand rand= new Rand();
		int num = rand.getRandom();
		label4.setText("验  证  码  ("+ num +")：");
		label4.setFont(new Font("微软雅黑",0,18));
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
		
		//查找按钮
		button.setText("查 找");
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
		box1.add(label1);
		box2.add(label2);
		box2.add(field);
		box3.add(label3);
		box3.add(field1);
		box4.add(label4);
		box4.add(field2);
		box5.add(button);
		box5.add(button1);
		
		base.add(box);
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
		
		contenctPanel.add(base);
		add(contenctPanel);
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBuserCarddecide decide = new DBuserCarddecide();
			useremail = field1.getText();
			card = field.getText();
			
			if(decideUsercard(card,useremail) == false) {
				JOptionPane.showMessageDialog(null,"未找到该用户，请重新输入！", "错误",JOptionPane.ERROR_MESSAGE); 
			}else if(decideUsercard(card,useremail) == true){
				String option = "您的用户名是："+username+"\n"+"您的密码是："+password+"\n";
				JOptionPane.showMessageDialog(null, option, "查找结果",JOptionPane.CLOSED_OPTION); 
			}
				
		}
		
	}
	
	public boolean decideUsercard(String usercard, String useremail){
			
		DBconnection db = new DBconnection();
		conn = db.getConn();
			
		try{
			pres = conn.prepareStatement("select userName, userCard, userPass, userEmail from user where userCard = ? and userEmail = ?");
			pres.setString(1, usercard);
			pres.setString(2, useremail);
			res = pres.executeQuery();
			while(res.next()){
				String card = res.getString("userCard");
				String name = res.getString("userName");
				String pass = res.getString("userPass");
				String email = res.getString("userEmail");
				if(card.equals(usercard) && email.equals(useremail)){
					username = name;
					password = pass;
					return true;
				}
			}
			res.close();
			pres.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
