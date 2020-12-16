package ui;
/**
 * 查看个人信息
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import Login_Register.Userlogin_db;
import entity.User;

public class UserSelf extends JFrame {
				JPanel panelBottom;
			 	JPanel contentPane;
			 	private JButton refund;
			 	private JButton aginbuy;
				private JButton tuichu;
				private User_user_db User_user_d_chart;
				private User_user_db dishonour;
				UserDao userdao;
				private String na,ide,ac,ps;
				int id;
				
		


			public int getId() {
					return id;
				}


				public void setId(int id) {
					this.id = id;
				}


			public String getNa() {
					return na;
				}


				public void setNa(String na) {
					this.na = na;
				}


				public String getIde() {
					return ide;
				}


				public void setIde(String ide) {
					this.ide = ide;
				}


				public String getAc() {
					return ac;
				}


				public void setAc(String ac) {
					this.ac = ac;
				}


				public String getPs() {
					return ps;
				}


				public void setPs(String ps) {
					this.ps = ps;
				}


			public UserSelf() throws SQLException {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(500, 100, 800, 800);
				
				
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				JPanel panel = new JPanel();
				contentPane.add(panel, BorderLayout.NORTH);
				
				panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//流式居中
				
				
			
				refund = new JButton("修改我的信息");
				panel.add(refund);
				
				
			
				
				tuichu = new JButton("退出");
				panel.add(tuichu);
				
				tuichu.addActionListener( new ActionListener() {
					public void actionPerformed( ActionEvent e ){ 
						dispose();
					}
					
				}); 
				
				Userlogin_db dg = new Userlogin_db();
				int usd = dg.getUseridDl();
				userdao = new UserDaoImpl();
			    List<User> us = userdao.QueryById(54);
			    for (User e : us) {
			    	int u = e.getUserid();
			    	String name = e.getName();
			    	String ident = e.getIdentity_number();
			    	String ac = e.getAccount();
			    	String pa = e.getPassword();
			    	setId(u);
			    	setIde(ident);
			    	setPs(pa);
			    	setAc(ac);
			    	setNa(name);
			    	setIde(ident);
			    	
				}
			    
			    refund.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						UpdataSelf ff = new UpdataSelf(getId(),getNa(),getIde(),getAc(),getPs());
						ff.setVisible(true);
						
						
					}
				});
			    
			    JLabel label = new JLabel("姓名："+"   "+ getNa());
			    label.setFont(new Font("宋体",Font.BOLD, 30));
				label.setBounds(270, 100, 5000, 50);
				add(label);
				
				JLabel label2 = new JLabel("身份证号："+" "+ getIde());
			    label2.setFont(new Font("宋体",Font.BOLD, 30));
				label2.setBounds(150, 220, 5000, 35);
				add(label2);
				
				JLabel label3 = new JLabel("账号："+"   "+ getAc());
			    label3.setFont(new Font("宋体",Font.BOLD, 30));
				label3.setBounds(260, 340, 5000, 35);
				add(label3);
				
				JLabel label4 = new JLabel("密码："+"   "+ getPs());
			    label4.setFont(new Font("宋体",Font.BOLD, 30));
				label4.setBounds(260, 460, 5000, 35);
				add(label4);
				
				JLabel label5 = new JLabel();
			    label5.setFont(new Font("宋体",Font.BOLD, 30));
				label5.setBounds(360, 460, 5000, 35);
				add(label5);
				
			}
			
			
	

			public static void main(String[] args)  {
				UserSelf ss;
				try {
					ss = new UserSelf();
					ss.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	
	
}
