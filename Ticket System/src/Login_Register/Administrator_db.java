package Login_Register;
/*
 * ����Ա��½
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
 
import javax.swing.*;

import Dao.Admainistrator_qpDao;
import Dao.Impl.Admainistrator_qpImpl;
import ui.Administrator_ui;
 
public class Administrator_db  implements ActionListener {
	JTextField accgT,passgT;
	JButton okB;
	ResultSet rs;
	Admainistrator_qpDao admin;
	Userlogin userlogin;
	
	public void setaccountT(JTextField a){
		accgT = a;
	}
	public void setpasswordT(JTextField n){
		passgT = n;
	}
	public void setButton(JButton b1,JButton b2){
		okB = b1;
	
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == okB){
			if(accgT.getText().equals("")) {			//�ж��û������Ƿ�Ϊ�գ�
				JOptionPane.showMessageDialog(null, "����д�˺ţ�");
			}
			else if(passgT.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���������룡");
			}
			else{
				String accountgT = accgT.getText();
				String passwordgT = passgT.getText();
				
				try {
					
					admin = new Admainistrator_qpImpl();
					boolean flags = admin.Login(accountgT, passwordgT);
					System.out.println(flags);
					if(flags) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Administrator_ui gljm = new Administrator_ui();
									gljm.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}); 
					}
					else{
						JOptionPane.showMessageDialog(null, "�˺Ż���������ȷ������������");
						accgT.setText("");
						passgT.setText("");
					}
				} 
				
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	
	}

}
