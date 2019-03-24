摘要信息：
电子商城系统主要功能包括：用户注册、用户登录、用户查看商城商品、用户购买商品、用户查看购物车并且清空购物车、用户找回账户以及密码、管理员登录、管理员注册、管理员查看用户信息、管理员删除用户信息、管理员删除商品信息、管理员添加商品信息、管理员修改商品信息、退出登录等。
图形可视化界面运行下能够显示系统启动进度条，删除、添加、注册等相关操作时能够弹出窗口加以提示，退出登录或系统时能够做到单击确认退出按钮才退出登录或系统，能够对用户加以提示。
注册用户或是管理员、添加商品信息、购买商品、删除商品或是用户信息、修改商品信息等相关操作时能够判断有无该用户或是商品。
用户在购买商品的时候同时更新商品的库存数量，管理员删除管理员时可以做到同时删除用户的购买信息。

主要内容：

一、项目名称
　　基于JAVASE的电子商城系统

二、功能要求
1、用户注册
2、用户登录
3、用户查看商品列表
4、用户购买商品
5、用户查看购买商品列表
6、用户清空购物车
7、用户找回账户和密码
8、管理员登录
9、管理员注册
10、查看用户信息
11、查看商品信息
12、删除用户信息
13、删除商品信息
14、添加商品信息
15、修改商品信息
16、退出用户登录
17、退出管理员登录
18、退出商城
三、需求分析
  该系统的用户是商城消费者和商城管理者，根据客户的要求，可以注册、登录、购物、查看购物车信息、找回账户和密码，管理员可以对商品信息进行增加、修改、删除操作，可以对用户进行查看和删除。

四、设计思想
    1、在控制台与图形可视化界面下运行
    2、使用Mysql数据库存取用户登录信息和商品信息
    3、使用List存取商品购买信息
4、把程序分为多个类，多个类之间的互相调用。
5、用户或是管理员进行注册、登录时能够提供校验码。
6、用户或是管理员获取数据库信息时能够与数据库进行交互。
7、用户购物要做到简洁明了。
8、用户只需要身份证号码和邮箱地址就能找回账户和密码。
9、注册、删除、修改等操作要有信息提示。
10、用户、管理员进行操作时能够做到操作提示与用户名提示。
11、退出登录或是退出系统时能够做到让用户有所考虑。

五、具体实现
　  1、技术思路：
界面：基于控制台与图形可视化界面（Swing）实现用户的输入和输出。
程序流程：在函数中利用循环与递归 ，读取用户输入，调用模块实现各个子功能。
2、功能子模块划分：
① 注册模块
② 登录模块
③ 查看商品模块（查看商品列表，购买商品）
④ 查看购买商品信息
⑤ 管理员登录（添加管理员信息，对商品信息进行查看、增加、
修改、删除，对用户信息进行查看、删除，删除用户信息
时能够做到同时删除消费记录）
⑥ 退出系统

六、运行截图
1、商城系统启动进度条（进度条能够做到动态加载）：
 
2、商城主界面：
 
3、用户注册界面（填写注册信息不符合要求时能够弹窗提示、并
且判断用户名是否重复等）：
 
4、用户登录界面（账户、密码不一致时能弹窗提示）：
 
5、用户服务选择界面（能够提示用户名）：
 
6、购买商品界面（能够判断输入的商品序号是否正确）：
 
7、查看购物车界面（能够一键清空购物车）：
 
8、查看商城商品信息界面：
 
9、管理员登录界面：
 
10、找回账户与密码界面：

 
11、管理员服务选择界面：
 
12、添加管理员界面：
 
13、查看用户信息界面：
 
14、删除用户信息界面：
 
15、删除商品信息界面：
 
16、添加商品信息界面：
 
17、修改商品信息界面：
 
18、退出账号、管理员登录、商城系统时要有提示：
 

七、源代码 （程序主要源代码）：
1、启动加载进度条：
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

2、商城主界面：
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

3、用户注册：
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
4、用户登录：
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

5、查看商城商品：
public GoodsLook() {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DBuser user = new DBuser();
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("查  看  商  城  商  品  信  息  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		text.setSize(800, 800);
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			text.append("---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 生 产 日 期 ----"+" 会 员 价 格 ----" + " 非 会 员 价 格 ----" + " 商 品 数 量 ----"+"\n");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				text.append("\n          "+id+"\t "+name+"\t     "+date+"\t           "+vipmoney+"\t        "+money+"\t        "+num+"\n");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		button.setText("购  买  商  品");
		button.setFont(new Font("微软雅黑",1,18));
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button) {
					dispose();
					UserLogin login = new UserLogin();
				}
			}		
		});
				
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
		
	}

6、用户服务选择：
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
		button.setText("1、 购     买     商     品 ");
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
		button2.setText("2、 查   看   购   物   车 ");
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
		button1.setText("3、 退     出     登     录");
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
		
	}

7、用户购物车：
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

8、用户购买商品：
public UserBuy(String username) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("用  户  购  买  商  品  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		
		label1.setText("欢迎  " + username + "  VIP用户");
		label1.setFont(new Font("微软雅黑",0,20));
		
		text.setSize(800, 800);
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			text.append("---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 生 产 日 期 ----"+" 会 员 价 格 ----" + " 非 会 员 价 格 ----" + " 商 品 数 量 ----"+"\n");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				text.append("\n          "+id+"\t "+name+"\t     "+date+"\t           "+vipmoney+"\t        "+money+"\t        "+num+"\n");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("这是所有的商品信息,购买只需要输入商品序号和购买数量！");
		label2.setFont(new Font("微软雅黑",0,18));
		
		label3.setText("请 输 入 要 购 买 商 品 的 序 号：");
		label3.setFont(new Font("微软雅黑",0,18));
		
		label4.setText("请 输 入 要 购 买 商 品 的 数 量：");
		label4.setFont(new Font("微软雅黑",0,18));
		
		button.setText("确  定  购 买");
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
		
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBgoodsId goodsid = new DBgoodsId();
			DBgoodsName goodsname = new DBgoodsName();
			DBgoodsVIPmoney money = new DBgoodsVIPmoney();
			DBgoodsNum goodsnum = new DBgoodsNum();
			DBcostInsert insert = new DBcostInsert();
			DBgoodsUP update = new DBgoodsUP();
			int id = Integer.parseInt(field.getText());
			int num = Integer.parseInt(field1.getText());
			if(goodsid.getgoodsID(id) == id) {
				int n = goodsnum.getgoodsNum(id);
				if(num > n || num == 0) {
					JOptionPane.showMessageDialog(null,"您 购 买 的 商 品 库 存 不 足 ！", "错误",JOptionPane.ERROR_MESSAGE); 
					field.setText("");
					field1.setText("");
				}else {
					String name = goodsname.getgoodsName(id);//获取商品名称
					BigDecimal vip = money.getgoodsVIPmoney(id);//获取商品价格
					BigDecimal cost = vip.multiply(BigDecimal.valueOf(num));
					if(insert.Goodsinsert(username, id, name, vip, num, cost)) {
						JOptionPane.showMessageDialog(null, name + "  商 品 购 买 成 功 ！", "购买成功",JOptionPane.DEFAULT_OPTION); 
						update.setupgoodsNum(id, n-num);//同时更新商品数量
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"您 输 入 的 商 品 序 号 不 存 在 ！", "错误",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
				field1.setText("");
			}
		}
		
	}

9、管理员登录：
public AdminLogin() {
		
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("管  理  员  登  录  界  面\n");
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
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			DBadminPassdecide passdecide = new DBadminPassdecide();
			DBadminNamedecide namedecide = new DBadminNamedecide();
			
			if(e.getSource() == button) {
				
				//获取文本框输入的信息
				username = field.getText();
				password = password1.getText();
				
				String option =username + "  用户恭喜您注册成功";
				
				//判断用户名、密码
				if(namedecide.decideAdminname(username) == false) {
					JOptionPane.showMessageDialog(null,"用户不存在，请重新输入！", "错误",JOptionPane.ERROR_MESSAGE); 
					field.setText("");
				}else if(passdecide.decideAdminpass(username, password) == false) {
					JOptionPane.showMessageDialog(null,"密码不正确，请重新输入！", "错误",JOptionPane.ERROR_MESSAGE); 
					field1.setText("");
				}else{
					dispose();
					AdminSelect select = new AdminSelect(username);//跳转到管理员服务选择界面
					select.getName(username);
					
				}
			}
		}
		
	}

10、管理员服务选择：
public AdminSelect(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("管  理  员  服  务  选  择  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		button1.setText("1、添 加 新 管 理 员");
		button1.setBackground(Color.WHITE);
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminRegion region = new AdminRegion(adminname);
					region.getName(adminname);
				}
				
			}
			
		});

		button2.setText("2、查 看 用 户 信 息");
		button2.setBackground(Color.WHITE);
		button2.setFont(new Font("微软雅黑",1,18));
		button2.setBorderPainted(false);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button2) {
					dispose();
					AdminUserLook look = new AdminUserLook(adminname);
					look.getName(adminname);
				}
			}
			
		});
		
		button3.setText("3、删 除 用 户 信 息");
		button3.setBackground(Color.WHITE);
		button3.setFont(new Font("微软雅黑",1,18));
		button3.setBorderPainted(false);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button3) {
					dispose();
					AdminUserDel del = new AdminUserDel(adminname);
					del.getName(adminname);
					
				}
			}
			
		});
		
		button4.setText("4、删 除 商 品 信 息");
		button4.setBackground(Color.WHITE);
		button4.setFont(new Font("微软雅黑",1,18));
		button4.setBorderPainted(false);
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button4) {
					dispose();
					AdminGoodsDel del = new AdminGoodsDel(adminname);
					del.getName(adminname);
					
				}
			}
			
		});
		
		button5.setText("5、添 加 商 品 信 息");
		button5.setBackground(Color.WHITE);
		button5.setFont(new Font("微软雅黑",1,18));
		button5.setBorderPainted(false);
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button5) {
					dispose();
					AdminGoodsInsert insert = new AdminGoodsInsert(adminname);
					insert.getName(adminname);
				}
				
			}
			
		});
		
		button6.setText("6、修 改 商 品 信 息");
		button6.setBackground(Color.WHITE);
		button6.setFont(new Font("微软雅黑",1,18));
		button6.setBorderPainted(false);
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button6) {
					dispose();
					AdminGoodsUpdate update = new AdminGoodsUpdate(adminname);
					update.getName(adminname);
				}
			}
			
		});
		
		button7.setText("7、退出 管理员 登录");
		button7.setBackground(Color.WHITE);
		button7.setFont(new Font("微软雅黑",1,18));
		button7.setBorderPainted(false);
		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button7) {
					OptionPane option = new OptionPane();
					dispose();
				}
			}			
		});
	}

11、管理员注册：
public AdminRegion(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("添  加  管  理  员  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		//用户名
		label2.setText("用户名（字母和数字组成，至少为6位）：");
		label2.setFont(new Font("微软雅黑",0,18));
		field.addActionListener(new Myaction());
		
		//密码
		label3.setText("密 码（字母 和 数字 组成，至少为6位）：");
		label3.setFont(new Font("微软雅黑",0,18));
		field1.addActionListener(new Myaction());
		password1.setText(password);
		//随机验证码
		Rand rand= new Rand();
		int num = rand.getRandom();
		label4.setText("请   输   入   随   机   验   证   码 ( "+ num +" )：");
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
		
		button.setText("注册");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
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
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub

			DBadminNamedecide dbadminname = new DBadminNamedecide();
			DBadminRegion insert = new DBadminRegion();
			UserDecide userdecide = new UserDecide();
			if(e.getSource() == button) {
				
				//获取文本框输入的信息
				username = field.getText();
				password = password1.getText();
				
				String option = username + "  管理员添加成功";
				
				if(dbadminname.decideAdminname(username) == true || username.length() < 6 || userdecide.Decide(username) == false) {
					JOptionPane.showMessageDialog(null,"用户名重复，由字母和数字组成，长度至少为6位！", "错误",JOptionPane.ERROR_MESSAGE); 
					field.setText("");
				}else if(userdecide.Decide(password) == false) {
					JOptionPane.showMessageDialog(null,"密码名由字母和数字组成，长度至少为6位！", "错误",JOptionPane.ERROR_MESSAGE); 
					field1.setText("");
				}else if(insert.insertAdmin(username,password )) {
						JOptionPane.showMessageDialog(null, option, "正确注册",JOptionPane.DEFAULT_OPTION); 
						AdminSelect select = new AdminSelect(adminname);
						select.getName(adminname);
						dispose();
				}
				
			}
		}
	}

12、查看用户信息：
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
	}

13、删除用户信息：
public AdminUserDel(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DBuser user = new DBuser();
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("删  除  用  户  信  息  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		text.setSize(800, 800);
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
		
		label2.setText("这是所有的用户信息,删除用户只需要输入用户序号！");
		label2.setFont(new Font("微软雅黑",0,18));
		
		label3.setText("请 输 入 要 删 除 用 户 的 序 号：");
		label3.setFont(new Font("微软雅黑",0,18));
		
		button.setText("确  定  删  除");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回管理员服务主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
					
				}
			}			
		});
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBuserDel del = new DBuserDel();
			DBuserName username = new DBuserName();
			DBuserId id = new DBuserId();
			DBcostDel costdel = new DBcostDel();
			int num = Integer.parseInt(field.getText());
			String name = username.getuserName(num);
			
			if(num < 1 || id.getuserID(num) != num || id.getuserID(num) == 0) {
				JOptionPane.showMessageDialog(null,"输入的用户序号不存在！", "错误",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
			}else if(del.setDeluser(num)) {
				costdel.Costdel(name);
				JOptionPane.showMessageDialog(null, name + "  用户删除成功", "删除成功",JOptionPane.DEFAULT_OPTION); 
				dispose();
				AdminUserDel Del = new AdminUserDel(adminname);
			}
		}
	}

14、删除商品信息：
public AdminGoodsDel(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DBuser user = new DBuser();
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("删除商品信息界面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		text.setSize(800, 800);
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			text.append("---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 生 产 日 期 ----"+" 会 员 价 格 ----" + " 非 会 员 价 格 ----" + " 商 品 数 量 ----"+"\n");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				text.append("\n          "+id+"\t "+name+"\t     "+date+"\t           "+vipmoney+"\t        "+money+"\t        "+num+"\n");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("这是所有的商品信息,删除商品只需要输入商品序号！");
		label2.setFont(new Font("微软雅黑",0,18));
		
		label3.setText("请 输 入 要 删 除 商 品 的 序 号：");
		label3.setFont(new Font("微软雅黑",0,18));
		
		button.setText("确  定  删  除");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回管理员服务主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
					
				}
			}			
		});
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBgoodsId id = new DBgoodsId();
			DBgoodsName goodsname = new DBgoodsName();
			DBgoodsDel del = new DBgoodsDel();
			int num = Integer.parseInt(field.getText());
			String name = goodsname.getgoodsName(num);
			if(num < 1 || id.getgoodsID(num) != num || id.getgoodsID(num) == 0) {
				JOptionPane.showMessageDialog(null,"输入的商品序号不存在！", "错误",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
			}else if(del.setDelgoods(num)) {
				JOptionPane.showMessageDialog(null, name + "  商品删除成功", "删除成功",JOptionPane.DEFAULT_OPTION); 
				dispose();
				AdminGoodsDel Del = new AdminGoodsDel(adminname);
			}
		}
	}

15、添加商品信息：
public AdminGoodsInsert(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("添  加  商  品  信  息  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label6.setText("欢迎  " + adminname + "  管理员");
		label6.setFont(new Font("微软雅黑",0,20));
		
		label1.setText("商 品 名 称：");
		label1.setFont(new Font("微软雅黑",0,18));
		field.addActionListener(new Myaction());
		
		label2.setText("生 产 日 期：");
		label2.setFont(new Font("微软雅黑",0,18));
		field1.addActionListener(new Myaction());
		
		label3.setText("会 员 价 格：");
		label3.setFont(new Font("微软雅黑",0,18));
		field2.addActionListener(new Myaction());
		
		label4.setText("非会员价格：");
		label4.setFont(new Font("微软雅黑",0,18));
		field3.addActionListener(new Myaction());
		
		label5.setText("商 品 数 量：");
		label5.setFont(new Font("微软雅黑",0,18));
		field4.addActionListener(new Myaction());
		
		button.setText("添加");
		button.setFont(new Font("微软雅黑",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回管理员主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
				}
			}			
		});
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DBgoodsNamedecide decide = new DBgoodsNamedecide();
			DBgoodsInsert insert = new DBgoodsInsert();
			String name = field.getText();
			String date = field1.getText();
			BigDecimal vip = BigDecimal.valueOf(Double.parseDouble(field2.getText()));
			BigDecimal money = BigDecimal.valueOf(Double.parseDouble(field3.getText()));
			int num = Integer.parseInt(field4.getText());
			
			if(decide.decideGoodsname(name)) {
				JOptionPane.showMessageDialog(null,"商品名不能重复！", "错误",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
			}else if(insert.Goodsinsert(name, date, vip, money, num)){
				JOptionPane.showMessageDialog(null,"添加商品成功！","正确", JOptionPane.DEFAULT_OPTION); 
			}
		}
	}

16、修改商品信息：
public AdminGoodsUpdate(String adminname) {
		setTitle("欢迎使用  Hern  电子商城");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    电   子   商   城");
		label.setFont(new Font("微软雅黑",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("修  改  商  品  信  息  界  面\n");
		label0.setFont(new Font("微软雅黑",1,25));
		
		label1.setText("欢迎  " + adminname + "  管理员");
		label1.setFont(new Font("微软雅黑",0,20));
		
		text.setSize(800, 800);
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			text.append("---- 商 品 序 号 ----"+" 商  品  名  称 ----" + " 商 品 生 产 日 期 ----"+" 会 员 价 格 ----" + " 非 会 员 价 格 ----" + " 商 品 数 量 ----"+"\n");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				text.append("\n          "+id+"\t "+name+"\t     "+date+"\t           "+vipmoney+"\t        "+money+"  \t        "+num+"\n");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("这是所有的商品信息！");
		label2.setFont(new Font("微软雅黑",0,18));
		
		label3.setText("请输 入 要 修 改 的 商 品 序 号：");
		label3.setFont(new Font("微软雅黑",0,18));
		label4.setText("请 输 入 要  新  的  商 品 名 称：");
		label4.setFont(new Font("微软雅黑",0,18));
		label5.setText("请 输 入 要  新  的  生 产 日 期：");
		label5.setFont(new Font("微软雅黑",0,18));
		label6.setText("请 输 入 要  新  的  会 员 价 格：");
		label6.setFont(new Font("微软雅黑",0,18));
		label7.setText("请 输 入 要  新  的 非 会员价格：");
		label7.setFont(new Font("微软雅黑",0,18));
		label8.setText("请 输 入 要  新  的  商 品 数 量：");
		label8.setFont(new Font("微软雅黑",0,18));
		
		button.setText("立  即  修  改");
		button.setFont(new Font("微软雅黑",1,18));
		button.addActionListener(new Myaction());
		
		button1.setText("返回管理员服务主界面");
		button1.setFont(new Font("微软雅黑",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
					
				}
			}			
		});
	}
	
	class Myaction extends JFrame implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBgoodsUP up = new DBgoodsUP();
			DBgoodsId id = new DBgoodsId();
			int goodsid = Integer.parseInt(field.getText());
			String name = field1.getText();
			String date = field2.getText();
			BigDecimal vip = new BigDecimal(field3.getText());
			BigDecimal money = new BigDecimal(field4.getText());
			int num = Integer.parseInt(field5.getText());
			if(goodsid < 1 || id.getgoodsID(goodsid) != goodsid || id.getgoodsID(goodsid) == 0) {
				JOptionPane.showMessageDialog(null,"输入的商品序号不存在！", "错误",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
				field1.setText("");
				field2.setText("");
				field3.setText("");
				field4.setText("");
				field5.setText("");
			}else {
				up.setupgoodsName(goodsid, name);
				up.setupgoodsDate(goodsid, date);
				up.setupgoodsVIPmoney(goodsid, vip);
				up.setupgoodsMoney(goodsid, money);
				up.setupgoodsNum(goodsid, num);
				JOptionPane.showMessageDialog(null, goodsid + "  号商品修改成功", "修改成功",JOptionPane.DEFAULT_OPTION);
				dispose();
				AdminGoodsUpdate Up = new AdminGoodsUpdate(adminname);
			}
		}
	}

17、用户账户、密码：
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

18、数据库连接：
static final String driverClass="com.mysql.jdbc.Driver";
	static final String	connStr="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8";
	static final String	user="root";
	static final String pass="admin";
	static Connection conn;	//声明Connection对象
	static PreparedStatement pres;	//向数据库发送SQL语句
	static ResultSet res;	//执行数据库查询

	public Connection getConn() {
			
			try {
				Class.forName(driverClass);
				//out.print("连接成功");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库驱动加载错误!");
			}
			
			try{
				conn =  DriverManager.getConnection(connStr, user, pass);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库连接错误!");
			}
				
			return conn;
		}
