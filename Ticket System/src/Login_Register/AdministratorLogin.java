package Login_Register;
/*
 * ����Ա��½����
 */
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class AdministratorLogin extends JFrame{
	//JLabel accountL,nameL;
	JTextField accountgT,passwordgT;
	JButton okB;
	Box baseB1,baseB2,box1,box2,box3;		//�˵�¼ҳ�����Box���ַ�ʽ��
	Administrator_db log;
	
	public AdministratorLogin(){
		initg();
	}
	void initg(){
		log= new Administrator_db();
		
		accountgT = new JTextField(20);
		//passwordgT = new JTextField(20);
		JPasswordField passwordgT= new JPasswordField();
		passwordgT.setEchoChar('*');
		okB = new JButton("��¼");
		
		
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("�˺ţ�"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("����"));
		
		box2 = Box.createVerticalBox();
		box2.add(accountgT);
		box2.add(Box.createVerticalStrut(8));
		box2.add(passwordgT);
		
		box3 = Box.createHorizontalBox();
		box3.add(okB);
		
		baseB1 = Box.createHorizontalBox();
		baseB1.add(box1);
		baseB1.add(Box.createHorizontalStrut(8));
		baseB1.add(box2);
		
		baseB2 = Box.createVerticalBox();
		baseB2.add(baseB1);
		baseB2.add(Box.createVerticalStrut(20));
		baseB2.add(box3);
		
		okB.addActionListener(log);

		
		log.setaccountT(accountgT);
		log.setpasswordT(passwordgT);
		log.setButton(okB, okB);
		
		add(baseB2);
		setLayout(new FlowLayout());
		setBounds(600,200,400,250);
		setVisible(true);
		setTitle("����Ա��¼����");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/*public static void main(String[] args) {
		new gldl();
	}									*/
}
