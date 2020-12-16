package Login_Register;
 /**
  * 用户登陆界面
  */
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class Userlogin extends JFrame{
	//JLabel accountL,nameL;
	JTextField accountT,passwordT;
	JButton okB,registB;
	Box baseB1,baseB2,box1,box2,box3;		//此登录页面采用Box布局方式；
	Userlogin_db log;
	
	public Userlogin(){
		init();
	}
	void init(){
		log = new Userlogin_db();
		
		accountT = new JTextField(20);
		//passwordT = new JTextField(20);
		JPasswordField passwordT= new JPasswordField();
		passwordT.setEchoChar('*');
		okB = new JButton("登录");
		registB = new JButton("注册");
		
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("账号："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("密码"));
		
		box2 = Box.createVerticalBox();
		box2.add(accountT);
		box2.add(Box.createVerticalStrut(8));
		box2.add(passwordT);
		
		box3 = Box.createHorizontalBox();
		box3.add(okB);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(registB);
		
		baseB1 = Box.createHorizontalBox();
		baseB1.add(box1);
		baseB1.add(Box.createHorizontalStrut(8));
		baseB1.add(box2);
		
		baseB2 = Box.createVerticalBox();
		baseB2.add(baseB1);
		baseB2.add(Box.createVerticalStrut(20));
		baseB2.add(box3);
		
		okB.addActionListener(log);
		registB.addActionListener(log);
		
		log.setaccountT(accountT);
		log.setpasswordT(passwordT);
		log.setButton(okB,registB);
		
		add(baseB2);
		setLayout(new FlowLayout());
		setBounds(600,200,400,250);
		setVisible(true);
		setTitle("用户登录界面");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
									
}
