package ui;
/**
 * �û�UI
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import Login_Register.Userlogin_db;

public class User_ui extends JFrame {
		
	 JPanel contentPane;
	 JPanel panelBottom;
	private JButton button;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	UserDao userdao;
	public User_ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 500, 200);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel paneld = new JPanel();
		contentPane.add(paneld, BorderLayout.CENTER);
		paneld.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
	
		button = new JButton("��ѯ/����");
		paneld.add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Inquire inquire = new Inquire();
				inquire.setVisible(true);
				dispose();
			}
		});
		
		button0 = new JButton("��ѯ����Ʊ");
		paneld.add(button0);
		button0.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				User_user user_user = new User_user();
				user_user.setVisible(true);
				dispose();
			}
		});
		
		button1 = new JButton("��ѯ������Ϣ");
		paneld.add(button1);
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					UserSelf uu = new UserSelf();
					uu.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		button2 = new JButton("��ѯ���");
		paneld.add(button2);
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				userdao = new UserDaoImpl();
				Userlogin_db dg = new Userlogin_db();
				int usd = dg.getUseridDl();
				try {
					int bl = userdao.selectbl(usd);
					JOptionPane.showMessageDialog(null, "������"+bl);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
         
	}

	
}
