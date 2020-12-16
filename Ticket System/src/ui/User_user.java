package ui;
/**
 * �û���Ʊ����UI
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

import entity.AcPs;
import entity.GetUserid;


public class User_user extends JFrame implements ActionListener {
			JPanel panelBottom;
		 	JPanel contentPane;
		 	private JButton refund;
		 	private JButton aginbuy;
			private JButton tuichu;
			private User_user_db User_user_d_chart;
			private User_user_db dishonour;
			
			
			
		public User_user() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(500, 100, 800, 800);
			
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//��ʽ����
			
			
		
			refund = new JButton("��Ʊ");
			panel.add(refund);
			refund.setActionCommand("refund");
			
			aginbuy = new JButton("ȥ��Ʊ");
			panel.add(aginbuy);
			aginbuy.setActionCommand("aginbuy");
			
			tuichu = new JButton("�˳�");
			panel.add(tuichu);
			
			tuichu.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ){ 
					dispose();
				}
				
			}); 
			
			
		    
			panelBottom = new JPanel();
			contentPane.add(panelBottom, BorderLayout.CENTER);
			panelBottom.setLayout(new BorderLayout(0,0));
			
			panelBottom.removeAll();
			User_user_d_chart=new User_user_db();
			panelBottom.add(User_user_d_chart,BorderLayout.CENTER);
			panelBottom.updateUI();
			
			
			aginbuy.addActionListener(this);
			refund.addActionListener(this);
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String command=e.getActionCommand();
			System.out.println(command);
			if(command.equals("aginbuy")){
				Inquire inquire = new Inquire();
				inquire.setVisible(true);
			}else if(command.equals("refund")){
				if(User_user_d_chart==null){
					JOptionPane.showMessageDialog(null, "û������");
					return;
				}
				try {
					User_user_d_chart.refund();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
}
			
			

