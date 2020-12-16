package ui;
/**
 * ��Ʊ����
 */
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Dao.TickeDao;
import Dao.Impl.TicketImpl;
import Dao.Impl.TickettypeImpl;
import entity.Tickettype;
import entity.User;
import entity.Seattype;
import entity.Ticket;

public class QueryTicket extends JPanel {
	private JTable table;
	private DefaultTableModel model;// ���ڴ洢�������
	private TickeDao ticketDao;
	private TicketImpl ticketimpl;
	private TickettypeImpl tickettypeDao;
	private String oldValue = "";// ���浥Ԫ��༭ ǰ��ֵ

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public QueryTicket() throws SQLException {
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
		loadData();
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
				Ticket ticket = new Ticket(ticketid, station_arrival, station_depart, depart_date, depart_time, ticket_number
						, seattype, tickettype, tickets_left, fares, ticket_office);
				try {
					ticketimpl.update(ticket);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void loadData() throws SQLException {
		// ����ɵ�����
		model.getDataVector().clear();
		
		List<Ticket> list = ticketDao.queryAll();
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

	public void del() throws SQLException {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ����������");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫɾ��");
		// �ж��û��Ƿ���
		if (result == JOptionPane.OK_OPTION) {
			int ticketid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 0).toString());
			ticketDao.delete(ticketid);
			loadData();
		}
	}

	public void updata() throws SQLException {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�������");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ�޸�");
		// �ж��û��Ƿ���
		if (result == JOptionPane.OK_OPTION) {
			
			int ticketid = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
			String station_arrival = table.getValueAt(table.getSelectedRow(), 1).toString();
			String station_depart = table.getValueAt(table.getSelectedRow(), 2).toString();
			String depart_date = table.getValueAt(table.getSelectedRow(), 3).toString();
			String depart_time= table.getValueAt(table.getSelectedRow(), 4).toString();
			int ticket_number = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 5).toString());
			String seattypeid = table.getValueAt(table.getSelectedRow(), 6).toString();
			String tickettypeid = table.getValueAt(table.getSelectedRow(), 7).toString();
			int tickets_left = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 8).toString());
			String fares = table.getValueAt(table.getSelectedRow(), 9).toString();		
			String ticket_office = table.getValueAt(table.getSelectedRow(), 10).toString();
			Ticket ticket = new Ticket(ticketid, station_arrival, station_depart, depart_date, depart_time,
					ticket_number, seattypeid, tickettypeid, tickets_left, fares, ticket_office);
			UpdataTicket updataticket = new UpdataTicket(ticket);
			updataticket.setVisible(true);
		}
	}
	public void buyticket() throws SQLException {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ����ĳ�Ʊ");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ����");
		// �ж��û��Ƿ���
		if (result == JOptionPane.OK_OPTION) {
			
			int ticketid = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
			String station_arrival = table.getValueAt(table.getSelectedRow(), 1).toString();
			String station_depart = table.getValueAt(table.getSelectedRow(), 2).toString();
			String depart_date = table.getValueAt(table.getSelectedRow(), 3).toString();
			String depart_time= table.getValueAt(table.getSelectedRow(), 4).toString();
			int ticket_number = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 5).toString());
			String seattypeid = table.getValueAt(table.getSelectedRow(), 6).toString();
			String tickettypeid = table.getValueAt(table.getSelectedRow(), 7).toString();
			int tickets_left = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 8).toString());
			String fares = table.getValueAt(table.getSelectedRow(), 9).toString();		
			String ticket_office = table.getValueAt(table.getSelectedRow(), 10).toString();
			Ticket ticket = new Ticket(ticketid, station_arrival, station_depart, depart_date, depart_time,
					ticket_number, seattypeid, tickettypeid, tickets_left, fares, ticket_office);
			UpdataTicket updataticket = new UpdataTicket(ticket);
			updataticket.setVisible(true);
		}
	}
	
}
