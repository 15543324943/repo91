package ui;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Dao.TickeDao;
import Dao.UserDao;
import Dao.UserTicketDao;
import Dao.Impl.TicketImpl;
import Dao.Impl.TickettypeImpl;
import Dao.Impl.UserDaoImpl;
import Dao.Impl.UserTicketImpl;
import Login_Register.Userlogin;
import Login_Register.Userlogin_db;
import entity.GetUserid;
import entity.Seattype;
import entity.Ticket;
import entity.Tickettype;
import entity.User;
import entity.UserTicket;

public class Userbuy_db extends JPanel{
	private JTable table;
	private DefaultTableModel model;// ���ڴ洢�������
	private String oldValue = "";// ���浥Ԫ��༭ ǰ��ֵ
	private TickeDao ticketDao;
	private TickeDao ticketim;
	private TickettypeImpl tickettypeDao;
	private UserTicketDao userticketdao;
	private UserDao userdao;
	 JPanel contentPane;
	 JPanel contentPane4;
	 JPanel panelBottom;	
	public String sql;
	Statement stmt;
	public Userbuy_db() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setColumnHeaderView(table);
		// ��ʼ���洢������ݵĶ���
		model = new DefaultTableModel(new Object[][] {}, new String[] { "��Ʊ���",
				"����վ", "����վ", "��������","����ʱ��", "����", "��λ����","��������","��Ʊ","Ʊ��","��Ʊվ"});
		// �����ݰ󶨵�������
		table.setModel(model);
		table.setRowHeight(30);

		scrollPane.setViewportView(table);

		tickettypeDao = new TickettypeImpl();
		ticketDao = new TicketImpl();
		try {
			loadData();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// Ϊ�����޸�ֵ����¼�
		model.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getColumn() < 0)
					return;
				String nVal = table.getValueAt(e.getLastRow(), e.getColumn())
						.toString();
				// ����ɵ�ֵ ���µ�ֵһ����ֱ�� ����
				if (nVal.equals(oldValue)) {
					return;
				}
				// �жϵ�ǰ�༭�ĵ�Ԫ���Ƿ���������
				if (e.getColumn() == 0) {
					// ��ԭ�ɵ�ֵ
					table.setValueAt(oldValue, e.getLastRow(), e.getColumn());
					return;
				}
				// ��������
				int ticketid = Integer.valueOf(table.getValueAt(e.getLastRow(),
						0).toString());
				String station_arrival = table.getValueAt(e.getLastRow(), 1).toString();
				String station_depart = table.getValueAt(e.getLastRow(), 2).toString();
				String depart_date = table.getValueAt(e.getLastRow(), 3).toString();
				String depart_time = table.getValueAt(e.getLastRow(), 4).toString();
				int ticket_number = Integer.valueOf(table.getValueAt(e.getLastRow(),
						5).toString());
				String seattype  = table.getValueAt(e.getLastRow(), 6).toString();
				String tickettype = table.getValueAt(e.getLastRow(), 7).toString();
				
				int tickets_left = Integer.valueOf(table.getValueAt(e.getLastRow(),
						8).toString());
				String fares = table.getValueAt(e.getLastRow(), 9).toString();
				String ticket_office = table.getValueAt(e.getLastRow(), 10).toString();
				Ticket ticket = new Ticket(ticketid, station_arrival, station_depart,
						depart_date, depart_time, ticket_number, seattype, tickettype,
						tickets_left, fares, ticket_office);
				try {
					ticketDao.update(ticket);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					loadData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	public  void loadData() throws SQLException {
		// ����ɵ�����
		model.getDataVector().clear();
		ticketDao = new TicketImpl();
		Inqurie_sg iqs = new Inqurie_sg();
		List<Ticket> list = ticketDao.quetida(iqs.getStation_arrival00(), iqs.getStation_depart00(), iqs.getDepart_date00());
		// ����ÿһ�����ݣ���ӵ�model��
		for (Ticket ticket : list) {
			// ��� ������
		//	cob.setSelectedItem(new Tickettype(ticket.getTicketid()));
			model.addRow(new Object[] { ticket.getTicketid(),ticket.getStation_arrival(),ticket.getStation_depart(),
					ticket.getDepart_date(),ticket.getDepart_time(),ticket.getTicket_number(),ticket.getSeattypeid(),
					ticket.getTickettypeid(),ticket.getTickets_left(),ticket.getFares(),
					ticket.getTicket_office()
					 });
		}
	}
/**
 * ��Ʊ����
 * @throws Exception
 */
		public void buy() throws Exception {
				if (table.getSelectedRowCount() <= 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ����ĳ�Ʊ");
					return;
				}
				System.out.println(table.getSelectedColumn());
				int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ����ó�Ʊ");
				// �ж��û��Ƿ���
				if (result == JOptionPane.OK_OPTION) {
					int ticketidd = Integer.valueOf(table.getValueAt(
							table.getSelectedRow(), 0).toString());
					
					Userlogin_db dg = new Userlogin_db();
					int usd = dg.getUseridDl();
					System.out.println(usd+"////////////////");
					System.out.println(ticketidd+"()()()()("+usd);
					userticketdao = new UserTicketImpl();
					userdao = new UserDaoImpl();
					ticketim = new TicketImpl();
					int blance = userdao.selectbl(usd);
					int yuan = ticketim.fares(ticketidd);
					System.out.println(blance+"***"+yuan);
					if(blance>=yuan) {
						boolean falll =  userdao.reduBlance(usd, yuan);
						boolean fal = userticketdao.SelectUidTid(ticketidd, usd);
						boolean fall = userticketdao.Left(ticketidd);
						System.out.println(fal+"23421434234"+fall);
						if(falll) {
							if(fall) {
								if(fal) {
									boolean falg =  userticketdao.buyTicket(ticketidd, usd);
									boolean flag1 = userticketdao.buyTicketb(ticketidd, usd);
									JOptionPane.showMessageDialog(null, "����ɹ���");
									System.out.println(falg + "1"+flag1);
									System.out.println(usd);
									System.out.println(ticketidd);
									System.out.println();
									}else {
										JOptionPane.showMessageDialog(null, "�������ظ������Ʊ��");
									}
							} else {
								JOptionPane.showMessageDialog(null, "��Ʊ�Ѿ�������");
							}
						}else {
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "���㣡");
					}
					try {
						loadData();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
}
	
