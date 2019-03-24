package com.shop.JFrame;
/***用户查看购买商品界面***/

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

public class UserBuylook extends JFrame {
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(10);
	private final JTextField field1 = new JTextField(10);
	
	private final JLabel label = new JLabel();
	private final JLabel label0 = new JLabel();
	private final JLabel label1 = new JLabel();
	private final JLabel label2 = new JLabel();
	private final JLabel label3 = new JLabel();
	private final JLabel label4 = new JLabel();

	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box6 = Box.createHorizontalBox();
	private final Box box7 = Box.createHorizontalBox();
	private JTextArea text= new JTextArea();
	
	private String username;
	
	public void getName(String name) {
		this.username = name;
	}
	
	public UserBuylook(String username) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("用  户  购  物  车  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		
		label1.setText("欢迎  " + username + "  VIP用户");
		label1.setFont(new Font("微软雅黑",0,20));
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select * from cost where userName = ?");
			pres.setString(1, username);
			res = pres.executeQuery();
			text.append("\t\t---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 价 格 ----"+" 购 买 数 量 ----" + " 商 品 花 费 总 价 ----");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				int num = res.getInt("goodsNum");
				BigDecimal usercost = res.getBigDecimal("userCost");
				text.append("\n\t\t\t"+id+"\t        "+name+"\t      "+vipmoney+"\t\t"+num+"\t\t"+usercost+"\t");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("尊敬的 "+username+"  VIP用户，这是您所有的购买记录！");
		label2.setFont(new Font("微软雅黑",0,18));
		button.setText("清 空 购 物 车");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回用户服务选择界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					UserSelect select = new UserSelect(username);
					select.getName(username);
					
				}
			}			
		});
		
		box.add(label);
		box1.add(label0);
		box2.add(label1);
		box3.add(scroll);
		box4.add(label2);
		box5.add(button);
		box5.add(button1);
		
		base.add(box);
		base.add(Box.createVerticalStrut(20));
		base.add(box1);
		base.add(Box.createVerticalStrut(20));
		base.add(box2);
		base.add(Box.createVerticalStrut(20));
		base.add(box3);
		base.add(Box.createVerticalStrut(20));
		base.add(box4);
		base.add(Box.createVerticalStrut(30));
		base.add(box5);
		base.add(Box.createVerticalStrut(40));
		
		contenctPanel.add(base);
		add(contenctPanel);
		setVisible(true);
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBcostDel costdel = new DBcostDel();
			costdel.Costdel(username);
			JOptionPane.showMessageDialog(null, "清 空 购 物 车 ！", "成功",JOptionPane.DEFAULT_OPTION); 
		}
		
	}
}
