package Login_Register;
/**
 * �û���½
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.*;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import entity.AcPs;
import entity.GetUserid;
import entity.User;
import ui.User_ui;
import util.DBcon;
 
public class Userlogin_db implements ActionListener {
	JTextField accT,passT;
	JButton okB,registB;
	ResultSet rs;
	static String f1;
	static String f2;
	static int useridDl;
	UserDao userdao;
	Userregister re;
	GetUserid uuu = new GetUserid();
	public void setaccountT(JTextField a){
		accT = a;
	}
	public void setpasswordT(JTextField n){
		passT = n;
	}
	public void setButton(JButton b1,JButton b2){
		okB = b1;
		registB = b2;
	}
	
	
	public static int getUseridDl() {
		return useridDl;
	}
	public static void setUseridDl(int useridDl) {
		Userlogin_db.useridDl = useridDl;
	}
	public static String getF1() {
		return f1;
	}
	public static void setF1(String f1) {
		Userlogin_db.f1 = f1;
	}
	public static String getF2() {
		return f2;
	}
	public static void setF2(String f2) {
		Userlogin_db.f2 = f2;
	}

	public void actionPerformed(ActionEvent e){
		
		
		if(e.getSource() == okB){
			if(accT.getText().equals("")) {		//�ж��û������Ƿ�Ϊ�գ�
				JOptionPane.showMessageDialog(null, "����д�˺ţ�");
				accT.setText("");
				passT.setText("");
			}
			else if(passT.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����������");
				accT.setText("");
			}
			else{
				
				String accountT = accT.getText();
				String passwordT = passT.getText();
				
				String f11=accT.getText();
				String f22=passT.getText();
				setF1(f11);
				setF2(f22);
					
				try {
					userdao = new UserDaoImpl();
					boolean falg = userdao.SelectAc(accountT);
					if(falg==true) {
						int userid = userdao.GetUseridbyaccount(accountT);
						System.out.println(userid);
						setUseridDl(userid);
						UserDao userDao = new UserDaoImpl();
						boolean com = userDao.SlectAcPs(accountT, passwordT);
						if(com) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										User_ui yhjm = new User_ui();
										yhjm.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}); 
						}else{
							JOptionPane.showMessageDialog(null, "�˺Ż���������ȷ������������");
							accT.setText("");
							passT.setText("");
						}
					}
						
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == registB){
			new JFrame().dispose();
			re = new Userregister();
		}
	}
}
