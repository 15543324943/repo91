 package ui;
/**
 * 用户查找
 */
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import entity.User;

public class QueryUser extends JPanel {
	private JTable table;
	private DefaultTableModel model;// 用于存储表格数据
	private UserDao userDao;
	private String oldValue = "";// 保存单元格编辑 前的值

	/**
	 * Create the panel.
	 */
	public QueryUser() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setColumnHeaderView(table);
		// 初始化存储表格数据的对象
		model = new DefaultTableModel(new Object[][] {}, new String[] { "用户编号",
				"用户名", "身份证件号码" ,"账号","密码"});
		// 将数据绑定到对象中
		table.setModel(model);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		userDao = new UserDaoImpl();
		loadData();
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
					
				int userid = Integer.valueOf(table.getValueAt(e.getLastRow(),0).toString());
				String name = table.getValueAt(e.getLastRow(), 1).toString();
				String identity_number = table.getValueAt(e.getLastRow(),2).toString();
				String account = table.getValueAt(e.getLastRow(), 3).toString();
				String password = table.getValueAt(e.getLastRow(), 4).toString();
				User user = new User(userid, name, identity_number, account, password);
				try {
					userDao.update(user);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void loadData() {
		// 清除旧的数据
		model.getDataVector().clear();
		// 查询部门数据
		//TableColumnModel col = table.getColumnModel();
		// 获取部门的列，设置这个列为下拉框列类型
		List<User> list;
		try {
			list = userDao.queryAll();
			// 遍历每一条数据，添加到model中
			for (User user : list) {
				// 添加 行数据
				model.addRow(new Object[] { user.getUserid(), user.getName(),
					 user.getIdentity_number(),user.getAccount(), user.getPassword() });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void del() throws SQLException {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要删除的数据行");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");
		// 判断用户是否点击
		if (result == JOptionPane.OK_OPTION) {
			int userid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 0).toString());
			userDao.delete(userid);
			loadData();
		}
	}
	
	public void updata() {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据行");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定要修改");
		// 判断用户是否点击
		if (result == JOptionPane.OK_OPTION) {
			
			int userid = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
			String name = table.getValueAt(table.getSelectedRow(), 1).toString();
			String identity_number = table.getValueAt(table.getSelectedRow(), 2).toString();
			String account = table.getValueAt(table.getSelectedRow(), 3).toString();
			String password = table.getValueAt(table.getSelectedRow(), 4).toString();
			User user = new User(userid, name, identity_number, account, password);
			UpdataUser upd = new UpdataUser(user);
			upd.setVisible(true);
		}
	}
	
	public void chongzhi() {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据行");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定要充值");
		// 判断用户是否点击
		if (result == JOptionPane.OK_OPTION) {
			
			int userid = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
			top_up tu = new top_up(userid);
			tu.setVisible(true);
		}
	}
	
}
