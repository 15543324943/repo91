package ui;
/**
 * 用户信息修改
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.Impl.UserDaoImpl;
import entity.User;

public class UpdataUser extends JFrame {
	
	JPanel contentPane;
	private JTextField txtname;
	private JTextField txtidentity_number;
	private JTextField txtaccout;
	private JTextField txtPassword;
	private UserDaoImpl userDao;
	 
	public UpdataUser(User user) {
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 800, 800);
		contentPane = new JPanel();
		
		JLabel label = new JLabel("用户姓名：");
		label.setBounds(250, 100, 70, 23);
		add(label);
		
		txtname = new JTextField();
		txtname.setBounds(350, 100, 180, 23);
		add(txtname);
		txtname.setColumns(10);
		txtname.setText(user.getName());
		
		JLabel label_1 = new JLabel("证件号码");
		label_1.setBounds(250, 170, 70, 23);
		add(label_1);
		
		txtidentity_number = new JTextField();
		txtidentity_number.setBounds(350, 170, 180, 23);
		add(txtidentity_number);
		txtidentity_number.setColumns(10);
		txtidentity_number.setText(user.getIdentity_number());
		
		JLabel label_2 = new JLabel("账号");
		label_2.setBounds(250, 240, 70, 23);
		add(label_2);
		
		txtaccout = new JTextField();
		txtaccout.setBounds(350, 240, 180, 23);
		add(txtaccout);
		txtaccout.setColumns(10);
		txtaccout.setText(user.getAccount());
		
		JLabel label_3 = new JLabel("密码");
		label_3.setBounds(250, 310, 70, 23);
		add(label_3);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(350, 310, 180, 23);
		add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setText(user.getPassword());
		
		userDao = new UserDaoImpl();
		
		JButton btnNewButton = new JButton("修改用户");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtname.getText().equals(""))	{	//判断用户输入是否为空；
					JOptionPane.showMessageDialog(null, "请输入姓名","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtidentity_number.getText().equals(""))	{	//判断用户输入是否为空；
					JOptionPane.showMessageDialog(null, "请输入身份证号","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtaccout.getText().equals(""))	{	//判断用户输入是否为空；
					JOptionPane.showMessageDialog(null, "请输入账号","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtPassword.getText().equals(""))	{	//判断用户输入是否为空；
					JOptionPane.showMessageDialog(null, "请输入密码","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {
					boolean flag;
					int userid = user.getUserid();
					String name=txtname.getText();
					String identity_number=txtidentity_number.getText();
					String account = txtaccout.getText();
					String password = txtPassword.getText();
					if (account.length()<8) {
						JOptionPane.showMessageDialog(null, "账号必须大于8位！");
						txtname.setText("");
						txtidentity_number.setText("");
						txtaccout.setText("");
						txtPassword.setText("");
						return;
						}
					if (password.length()<8) {
						JOptionPane.showMessageDialog(null, "添密码必须大于8位！");
						txtname.setText("");
						txtidentity_number.setText("");
						txtaccout.setText("");
						txtPassword.setText("");
						return;
						}
					
					User user1 = new User(userid, name, identity_number, account, password);
					flag = userDao.update(user1);
					try {
						if(flag){
							JOptionPane.showMessageDialog(null, "修改成功");
							txtname.setText("");
							txtidentity_number.setText("");
							txtaccout.setText("");
							txtPassword.setText("");
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "修改失败");
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
		btnNewButton.setBounds(320, 400, 116, 23);
		add(btnNewButton);
		

	}
	
}
