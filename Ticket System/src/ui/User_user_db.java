package ui;
/**
 * 用户车票操作界面
 */
import java.awt.BorderLayout;
import java.sql.Connection;
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
import Dao.Impl.UserDaoImpl;
import Dao.Impl.UserTicketImpl;
import Login_Register.Userlogin_db;
import entity.GetUserid;
import entity.User;
import entity.UserTicket;

public class User_user_db extends JPanel{
	private JTable table;
	private DefaultTableModel model;// 用于存储表格数据
	private String oldValue = "";// 保存单元格编辑 前的值
	private UserTicketDao usertickrtdao;
	private UserDao userdao;
	private TickeDao ticketdao;
	 JPanel contentPane;
	 JPanel contentPane4;
	 JPanel panelBottom;	
	public String sql;
	Statement stmt;
	public User_user_db() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setColumnHeaderView(table);
		// 初始化存储表格数据的对象
		model = new DefaultTableModel(new Object[][] {}, new String[] {"编号", "票号","用户编号","姓名","身份证号",
				"到达站", "出发站", "发车日期","发车时间", "车次", "座位类型","机车类型","票价","售票站"});
		// 将数据绑定到对象中
		table.setModel(model);
		table.setRowHeight(30);

		scrollPane.setViewportView(table);

		try {
			loadData();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	public  void loadData() throws SQLException {
		
		// 清除旧的数据
		model.getDataVector().clear();
		usertickrtdao = new UserTicketImpl();
		Userlogin_db usd = new Userlogin_db();
		int dfdf = usd.getUseridDl();
		List<UserTicket> userticket =  usertickrtdao.QueryByuserticketuserid(dfdf);
		
		//List<Ticket> list = rs.queryAll();
		// 遍历每一条数据，添加到model中
		for (UserTicket b : userticket) {
			// 添加 行数据
			model.addRow(new Object[] { 
					b.getUserticketid(),b.getUserticketticketid(),b.getUserticketuserid(),b.getUserticketname(),b.getUserticketidentity_number(),
					b.getUserticketstation_arrival(),b.getUserticketstation_depart(),b.getUserticketdepart_date(),
					b.getUserticketdepart_time(),b.getUserticketidentity_number(),b.getUserticketseattype(),
					b.getUsertickettickettype(),b.getUserticketfares(),b.getUserticketticket_office()
					 });
		}
	}
	
	
	/**
	 * 退票
	 * @throws Exception
	 */
	public void refund() throws Exception {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要退的票");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定退掉该票");
		// 判断用户是否点击
		if (result == JOptionPane.OK_OPTION) {
			int userticketid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 0).toString());
			int userticketuserid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 2).toString());
			int userticketticketid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 1).toString());
			usertickrtdao = new UserTicketImpl();
			userdao = new UserDaoImpl();
			ticketdao = new TicketImpl();
			usertickrtdao.fundTicket(userticketid, userticketticketid);
			int yuan = ticketdao.fares(userticketticketid);
			System.out.println("票价"+yuan);
			userdao.addBlance(userticketuserid, yuan);
			try {
				loadData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
