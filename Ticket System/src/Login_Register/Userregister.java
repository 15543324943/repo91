package Login_Register;
/**
 * �û�ע�����
 */

import java.awt.FlowLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.JPasswordField;
 
public class Userregister extends JFrame{
	JLabel accountLabel,passLabel,nameLable,identity_numberLable;
	JButton okButton,resetButton;
	JTextField accountText,passText,nameText,identity_numberText;
	Box baseBox1,baseBox2, box1,box2,box3;
	//��ע��ҳ�����Box���ַ�ʽ��
	//JPanel pane1,pane2;
	
	Userregister_db regist;
	
	Userregister(){
		init();
	}
	
	
	void init(){
		setLayout(new FlowLayout());
		accountLabel = new JLabel("�˺�");
		passLabel= new JLabel("����");
		nameLable = new JLabel("����");
		identity_numberLable = new JLabel("���֤����");
		
		accountText = new JTextField(20);
		JPasswordField passText= new JPasswordField();
		passText.setEchoChar('*');
	//	passText = new JTextField(20);
		nameText = new JTextField(20);
		identity_numberText = new JTextField(20);
		okButton = new JButton("ȷ��");
		resetButton = new JButton("����");
		
		regist = new Userregister_db();
		
//		lab = new JLabel("�û�ע��ҳ��");
		
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(20));
		box1.add(accountLabel);
		box1.add(Box.createVerticalStrut(14));
		box1.add(passLabel);
		box1.add(Box.createVerticalStrut(14));
		box1.add(nameLable);
		box1.add(Box.createVerticalStrut(14));
		box1.add(identity_numberLable);
		
		
		
		box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalStrut(20));
		box2.add(accountText);
		box2.add(Box.createVerticalStrut(8));
		box2.add(passText);
		box2.add(Box.createVerticalStrut(8));
		box2.add(nameText);
		box2.add(Box.createVerticalStrut(8));
		box2.add(Box.createVerticalStrut(8));
		box2.add(identity_numberText);

		box3 = Box.createHorizontalBox();
		box3.add(okButton);
		box3.add(Box.createHorizontalStrut(15));
		box3.add(resetButton);
		baseBox1 = Box.createHorizontalBox();
		baseBox1.add(box1);
		baseBox1.add(Box.createHorizontalStrut(8));
		baseBox1.add(box2);
		baseBox2 = Box.createVerticalBox();
		baseBox2.add(baseBox1);
		baseBox2.add(Box.createVerticalStrut(10));
		baseBox2.add(box3);
		add(baseBox2);
		
		okButton.addActionListener(regist);
		resetButton.addActionListener(regist);
		
		
		regist.setaccountField(accountText);
		regist.setpassField(passText);
		regist.setnameField(nameText);
		regist.setidentity_numberField(identity_numberText);
		regist.setokButton(okButton);
		regist.setresetButton(resetButton);
		
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("�û�ע�����");
	}
	
//	void registAction(){
//		
//	}
	
//	public static void main(String[] args) {
//		 new Userregister();
//	}
}
