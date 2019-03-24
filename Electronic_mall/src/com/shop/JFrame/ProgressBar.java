package com.shop.JFrame;
/***商城启动加载进度条***/

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

public class ProgressBar extends JFrame {

private static final long serialVersionUID = 1L;
	
	private JProgressBar processBar = new JProgressBar();//进度条
	
	private final JLabel label = new JLabel();//文本标签
	private final JLabel label1 = new JLabel();
	
	private final JButton button = new JButton();
	
	private final Box base = Box.createVerticalBox();//盒子
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	
	public ProgressBar() {
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(600,600,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());//设置面板为流式布局

		label.setText("正在进入  Hern  电子商城...");
		label.setFont(new   java.awt.Font("微软雅黑", 1,18));//设置字体格式、粗细、大小
		label1.setText(" ");
		
		processBar.setStringPainted(true);//设置显示信息
		processBar.setBackground(Color.darkGray);//设置背景色
	    processBar.setForeground(Color.BLUE);//设置前景色
		
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i += 5) {
					try {
						Thread.sleep(100); // 让当前线程休眠
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					processBar.setValue(i); // 设置进度条数值
				}
				processBar.setString("单击  进入  按钮 进入商城");// 设置提示信息
			}
		}.start();
		
		button.setText("进  入");
		button.setFont(new Font("微软雅黑",1,18));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button) {
					dispose();
					IndexWelcome index = new IndexWelcome();
				}
				
			}
			
		});
		
		box1.add(label);//文本标签
		box2.add(label1);//空白文本标签
		box3.add(processBar);//进度条
		box4.add(button);
		base.add(box1);//把水平盒子添加到垂直盒子中，让其变成垂直布局
		base.add(box2);
		base.add(box3);
		base.add(Box.createVerticalStrut(30));
		base.add(box4);
		
		contentPane.add(base);// 向面板添加垂直盒子
		add(contentPane);//向窗体中添加面板
		
	}

}
