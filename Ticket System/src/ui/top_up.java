package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import Login_Register.Userlogin_db;

public class top_up extends JFrame{

	JPanel contentPane;
	private JTextField txtBance;
	private UserDaoImpl userDao;
	UserDao userdao;
	
	public top_up(int userid) {
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 350, 320, 200);
		contentPane = new JPanel();
		
		JLabel label_2 = new JLabel("��������(Ԫ)");
		label_2.setBounds(40, 50, 100, 23);
		add(label_2);
		
		txtBance = new JTextField();
		txtBance.setBounds(145, 50, 50, 23);
		add(txtBance);
		txtBance.setColumns(10);
		//txtBance.setText(user.getblance());
		
		
		
		userDao = new UserDaoImpl();
		
		JButton btnNewButton = new JButton("��ֵ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtBance.getText().equals(""))	{	//�ж��û������Ƿ�Ϊ�գ�
					JOptionPane.showMessageDialog(null, "�������˺�","����Ի���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {
					boolean flag;
					
					int yuan = Integer.parseInt(txtBance.getText());
					flag = userDao.addBlance(userid, yuan);
					System.out.println(flag);
					try {
						if(flag){
							userdao = new UserDaoImpl();
							
							int bl = userdao.selectbl(userid);
							JOptionPane.showMessageDialog(null, "��ֵ�ɹ�!"+"  "+"��ǰ���"+bl);
							txtBance.setText("");
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "��ֵʧ��");
							txtBance.setText("");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(215, 50, 80, 23);
		add(btnNewButton);
		
	}
	public static void main(String[] args) {
		top_up yy = new top_up(1);
		yy.setVisible(true);
	}
}
