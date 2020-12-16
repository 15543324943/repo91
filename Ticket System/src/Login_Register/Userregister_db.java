package Login_Register;
/**
 * 用户注册
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.swing.*;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
 
public class Userregister_db extends JFrame implements ActionListener{
 
	JTextField textacc,textpass,textname,textidentity_number;
	JButton okButton,resetButton;
	Statement stmt;
	ResultSet rs;
	UserDao userdao;
//	double acc;
//	String name;
//	Connection con = null;
	
	public void setaccountField(JTextField a){
		textacc = a;
	}
	public void setpassField(JTextField b){
		textpass= b;
	}
	public void setnameField(JTextField c) {
		textname = c;
	}
	public void setidentity_numberField(JTextField f) {
		textidentity_number = f;
	}
	
	public void setokButton(JButton b1){
		okButton = b1;
	}
	public void setresetButton(JButton b2){
		resetButton = b2;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == okButton){
			if(textacc.getText().equals(""))			//判断用户输入是否为空；
				JOptionPane.showMessageDialog(null, "请输入账号","警告对话框",JOptionPane.WARNING_MESSAGE);
			else if(textpass.getText().equals(""))
				JOptionPane.showMessageDialog(null,"请输入密码","警告对话框",JOptionPane.WARNING_MESSAGE);
			else if(textname.getText().equals(""))
				JOptionPane.showMessageDialog(null,"请输入姓名","警告对话框",JOptionPane.WARNING_MESSAGE);
			else if(textidentity_number.getText().equals(""))
				JOptionPane.showMessageDialog(null,"请输入身份证号","警告对话框",JOptionPane.WARNING_MESSAGE);
			else {
				String acc = textacc.getText();
				String pass = textpass.getText();
				String name = textname.getText();
				String identity_number = textidentity_number.getText();
				if (acc.length()<8) {
					JOptionPane.showMessageDialog(null, "账号必须大于8位！");
					
					return;
					}
				if (pass.length()<8) {
					JOptionPane.showMessageDialog(null, "密码必须大于8位！");
				
					return;
					}
			
				try {
					
					userdao = new UserDaoImpl();
					boolean flags = userdao.SelectAc(acc);
						if(flags == true){
							//break;
							JOptionPane.showMessageDialog(null, "该账号已被注册，请重新设置账号名！","警告对话框",JOptionPane.WARNING_MESSAGE);
							textacc.setText("");
							textpass.setText("");
							textname.setText("");
							textidentity_number.setText("");
						}else {
							userdao.add(name, identity_number, acc, pass);
							JOptionPane.showMessageDialog(null, "注册成功！");
						}
					
					
				} catch (Exception e1) {
					//System.out.println("插入失败");
					//e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == resetButton){
			textacc.setText("");
			textpass.setText("");
			textname.setText("");
			textidentity_number.setText("");
		}
	}
	

	
}
