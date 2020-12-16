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
	private DefaultTableModel model;// 用于存储表格数据
	private String oldValue = "";// 保存单元格编辑 前的值
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
		// 初始化存储表格数据的对象
		model = new DefaultTableModel(new Object[][] {}, new String[] { "车票编号",
				"到达站", "出发站", "发车日期","发车时间", "车次", "座位类型","机车类型","余票","票价","售票站"});
		// 将数据绑定到对象中
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
		// 为表格绑定修改值后的事件
		model.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getColumn() < 0)
					return;
				String nVal = table.getValueAt(e.getLastRow(), e.getColumn())
						.toString();
				// 如果旧的值 和新的值一样，直接 返回
				if (nVal.equals(oldValue)) {
					return;
				}
				// 判断当前编辑的单元格是否是主键列
				if (e.getColumn() == 0) {
					// 还原旧的值
					table.setValueAt(oldValue, e.getLastRow(), e.getColumn());
					return;
				}
				// 更新数据
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
		// 清除旧的数据
		model.getDataVector().clear();
		ticketDao = new TicketImpl();
		Inqurie_sg iqs = new Inqurie_sg();
		List<Ticket> list = ticketDao.quetida(iqs.getStation_arrival00(), iqs.getStation_depart00(), iqs.getDepart_date00());
		// 遍历每一条数据，添加到model中
		for (Ticket ticket : list) {
			// 添加 行数据
		//	cob.setSelectedItem(new Tickettype(ticket.getTicketid()));
			model.addRow(new Object[] { ticket.getTicketid(),ticket.getStation_arrival(),ticket.getStation_depart(),
					ticket.getDepart_date(),ticket.getDepart_time(),ticket.getTicket_number(),ticket.getSeattypeid(),
					ticket.getTickettypeid(),ticket.getTickets_left(),ticket.getFares(),
					ticket.getTicket_office()
					 });
		}
	}
/**
 * 购票方法
 * @throws Exception
 */
		public void buy() throws Exception {
				if (table.getSelectedRowCount() <= 0) {
					JOptionPane.showMessageDialog(null, "请选择要购买的车票");
					return;
				}
				System.out.println(table.getSelectedColumn());
				int result = JOptionPane.showConfirmDialog(null, "是否确定要购买该车票");
				// 判断用户是否点击
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
									JOptionPane.showMessageDialog(null, "购买成功！");
									System.out.println(falg + "1"+flag1);
									System.out.println(usd);
									System.out.println(ticketidd);
									System.out.println();
									}else {
										JOptionPane.showMessageDialog(null, "您不能重复购买该票！");
									}
							} else {
								JOptionPane.showMessageDialog(null, "该票已经售罄！");
							}
						}else {
							JOptionPane.showMessageDialog(null, "购买失败！");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "余额不足！");
					}
					try {
						loadData();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
}
	
