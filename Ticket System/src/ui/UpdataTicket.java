package ui;
/**
 * 车票信息修改
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.TickeDao;
import Dao.TickettypeDao;
import Dao.Impl.SeattypeImpl;
import Dao.Impl.TicketImpl;
import Dao.Impl.TickettypeImpl;
import entity.Tickettype;
import entity.Seattype;
import entity.Ticket;


public class UpdataTicket extends JFrame {
	JPanel contentPane;
	private JTextField txtstation_arrival;
	private JTextField txtstation_depart;
	private JTextField txtdepart_date;
	private JTextField txtdepart_time;
	private JTextField txtticket_number;
	private JTextField txttickets_left;
	private JTextField txtfares;
	private JTextField txtticket_office;
	private JComboBox cmbtickettype;
	private JComboBox cmbseattype;
	private TickeDao ticketDao;
	private TickettypeImpl tickettypeDao;
	private SeattypeImpl seattypeDao;
	/**
	 * Create the panel.
	 * @param tickettypeDao 
	 * @throws SQLException 
	 */
	public UpdataTicket(Ticket ticket) throws SQLException {
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 800, 800);
		contentPane = new JPanel();
		
		JLabel label = new JLabel("到达站：");
		label.setBounds(280, 65, 146, 23);
		add(label);
		
		txtstation_arrival = new JTextField();
		txtstation_arrival.setBounds(350, 65, 146, 23);
		add(txtstation_arrival);
		txtstation_arrival.setColumns(10);
		txtstation_arrival.setText(ticket.getStation_arrival());
		
		JLabel label1 = new JLabel("乘车站：");
		label1.setBounds(280, 97, 146, 23);
		add(label1);
		
		txtstation_depart = new JTextField();
		txtstation_depart.setBounds(350, 97, 146, 23);
		add(txtstation_depart);
		txtstation_depart.setColumns(10);
		txtstation_depart.setText(ticket.getStation_depart());

		JLabel label_20 = new JLabel("发车日期：");
		label_20.setBounds(280, 130, 146, 23);
		add(label_20);
		
		txtdepart_date= new JTextField();
		txtdepart_date.setBounds(350, 130, 146, 23);
		add(txtdepart_date);
		txtdepart_date.setColumns(10);
		txtdepart_date.setText(ticket.getDepart_date());
		
		JLabel label_2 = new JLabel("发车时间：");
		label_2.setBounds(280, 162, 146, 23);
		add(label_2);
		
		txtdepart_time = new JTextField();
		txtdepart_time.setBounds(350, 162, 146, 23);
		add(txtdepart_time);
		txtdepart_time.setColumns(10);
		txtdepart_time.setText(ticket.getDepart_time());
		
		JLabel label_3 = new JLabel("车次：");
		label_3.setBounds(280, 195, 146, 23);
		add(label_3);
		
		txtticket_number = new JTextField();
		txtticket_number.setBounds(350, 195, 146, 23);
		add(txtticket_number);
		txtticket_number.setColumns(10);
		txtticket_number.setText(String.valueOf(ticket.getTicket_number()));
		
		JLabel label_4 = new JLabel("车票余量：");
		label_4.setBounds(280, 227, 146, 23);
		add(label_4);
		
		txttickets_left = new JTextField();
		txttickets_left.setBounds(350, 227, 146, 23);
		add(txttickets_left);
		txttickets_left.setColumns(10);
		txttickets_left.setText(String.valueOf(ticket.getTickets_left()));
	
		tickettypeDao=new TickettypeImpl();
		List<Tickettype> list=tickettypeDao.queryAll();
		System.out.println(list);
		JLabel label_5 = new JLabel("机车类型：");
		label_5.setBounds(280, 260, 146, 23);
		add(label_5);
		
		cmbtickettype = new JComboBox(list.toArray());
		cmbtickettype.setBounds(350, 260, 146, 23);
		add(cmbtickettype);
		
		seattypeDao = new SeattypeImpl();
		List<Seattype> list1 = seattypeDao.queryAll(); 
		
		JLabel label_6 = new JLabel("座位类型：");
		label_6.setBounds(280, 292, 146, 23);
		add(label_6);
		
		cmbseattype = new JComboBox(list1.toArray());
		cmbseattype.setBounds(350, 292, 146, 23);
		add(cmbseattype);
		
		JLabel label_7 = new JLabel("车票价格：");
		label_7.setBounds(280, 325, 146, 23);
		add(label_7);
		
		txtfares = new JTextField();
		txtfares.setBounds(350, 325, 146, 23);
		add(txtfares);
		txtfares.setColumns(10);
		txtfares.setText(ticket.getFares());
		
		JLabel label_8 = new JLabel("发售站：");
		label_8.setBounds(280, 357, 146, 23);
		add(label_8);
		
		txtticket_office = new JTextField();
		txtticket_office.setBounds(350, 357, 146, 23);
		add(txtticket_office);
		txtticket_office.setColumns(10);
		txtticket_office.setText(ticket.getTicket_office());
		
		ticketDao = new TicketImpl();
		JButton btnNewButton = new JButton("修改车票");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtstation_arrival.getText().equals(""))	{	//判断用户输入是否为空；
					JOptionPane.showMessageDialog(null, "请输入到达站","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txtstation_depart.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入乘车站","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txtdepart_date.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入发车日期","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txtdepart_time.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入发车时间","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txtticket_number.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入车次","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txttickets_left.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"请输入余票","警告对话框",JOptionPane.WARNING_MESSAGE);
						return;
				}
				else if(txtfares.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入票价","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(txtticket_office.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入发售站","警告对话框",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				int ticketid = ticket.getTicketid();
				String station_arrival = txtstation_arrival.getText();
				String station_depart = txtstation_depart.getText();
				String depart_date = txtdepart_date.getText();
				String depart_time = txtdepart_time.getText();
				String ticket_number0 = txtticket_number.getText();
				int ticket_number=Integer.parseInt(ticket_number0);
				Seattype seattype = (Seattype) cmbseattype.getSelectedItem();
				String seattypeid = String.valueOf(seattype.getSeattypename()).toString();
				Tickettype tickettype=(Tickettype) cmbtickettype.getSelectedItem();
				String tickettypeid = String.valueOf(tickettype);
				String tickets_left0 =txttickets_left.getText();
				int tickets_left = Integer.parseInt(tickets_left0);
				String fares = txtfares.getText();
				String ticket_office = txtticket_office.getText();
				Ticket ticket = new Ticket(ticketid, station_arrival, station_depart,
						depart_date, depart_time, ticket_number, seattypeid, 
						tickettypeid, tickets_left, fares, ticket_office);
				
				boolean flag;
				try {
					
					flag = ticketDao.update(ticket);
					if(flag){
						JOptionPane.showMessageDialog(null, "修改成功");
						dispose();
					
					}else{
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(320, 480, 146, 23);
		add(btnNewButton);

	}
}
