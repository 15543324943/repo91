package ui;
/**
 * 车票筛选条件输入界面
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.AcPs;
import entity.Ticket;
import entity.User;

public class Inquire extends JFrame {

	 JPanel contentPanee;
	 public JTextField txtstation_arrival;
	 public JTextField txtstation_depart;
	 public JTextField txtdepart_date;
	 Statement stmt;
	 ResultSet rs;
	 String station_arrival0000 ;
	 String station_depart0000 ;
	 String depart_date0000 ;
	 
	public Inquire() {
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 800, 200);
		contentPanee = new JPanel();
		
		
		
		
		JLabel label = new JLabel("到达站：");
		label.setBounds(80, 50, 100, 23);
		add(label);
		
		txtstation_arrival = new JTextField();
		txtstation_arrival.setBounds(130,50, 100, 23);
		add(txtstation_arrival);
		txtstation_arrival.setColumns(10);
		txtstation_arrival.setText("XX站");
		
		JLabel label1 = new JLabel("乘车站：");
		label1.setBounds(250, 50, 100, 23);
		add(label1);
		
		txtstation_depart = new JTextField();
		txtstation_depart.setBounds(300, 50, 100, 23);
		add(txtstation_depart);
		txtstation_depart.setColumns(10);
		txtstation_depart.setText("XX站");
		
		JLabel label2 = new JLabel("发车日期：");
		label2.setBounds(420, 50, 100, 23);
		add(label2);
		
		txtdepart_date = new JTextField();
		txtdepart_date.setBounds(480, 50, 100, 23);
		add(txtdepart_date);
		txtdepart_date.setColumns(10);
		txtdepart_date.setText("XXXX/XX/XX");
		
		
		JButton btnNewButton = new JButton("查询车票");
		btnNewButton.setBounds(620, 50, 100, 23);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String station_arrivals = txtstation_arrival.getText();
				//String station_arrivals = "ww";
				String station_departs = txtstation_depart.getText();
				String depart_dates = txtdepart_date.getText();
				
				Inqurie_sg inquire = new Inqurie_sg();
				inquire.setStation_arrival00(station_arrivals);
				inquire.setStation_depart00(station_departs);
				inquire.setDepart_date00(depart_dates);
				//System.out.println(station_arrivals);
				
					ByTicket byTicket = new ByTicket();
							byTicket.setVisible(true);
			}
		});

	}
	
	
	
//	public static void main(String[] args) {
//		Inquire s = new Inquire();
//		s.setVisible(true);
//		
//	}
//	
	
}
