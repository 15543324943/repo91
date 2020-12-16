package ui;
/**
 * �û���ʾ����
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ByTicket extends JFrame implements ActionListener{
	
	 JPanel contentPane;
	 JPanel panelBottom;
		private JButton tzcp;
	 	private JButton yhDel;
		private JButton yhAdd;
	 String station_arrival0000 ;
	 String station_depart0000 ;
	 String depart_date0000 ;
	private JButton tuichu;
	private Userbuy_db buy;
	private Inquire inquire;
	public String sql;
	Statement stmt;
	int useridd;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
		
		
	public ByTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 800, 800);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//��ʽ����
		
		JButton tss = new JButton("�����Ʊ");
		tss.setActionCommand("buyit");
		panel.add(tss);
		
		JButton ts = new JButton("����");
		ts.setActionCommand("back");
		panel.add(ts);
		
		
				
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
		
		ts.addActionListener(this);
		tss.addActionListener(this);
		
		panelBottom.removeAll();
		buy=new Userbuy_db();
		panelBottom.add(buy,BorderLayout.CENTER);
		panelBottom.updateUI();
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		
		String command=e.getActionCommand();
		if(command.equals("back")){
			inquire=new Inquire();
			inquire.setVisible(true);
		}else if(command.equals("buyit")){
			if(buy==null){
				JOptionPane.showMessageDialog(null, "û������");
				return;
			}
			try {
				buy.buy();
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
