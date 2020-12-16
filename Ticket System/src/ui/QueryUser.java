 package ui;
/**
 * �û�����
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
	private DefaultTableModel model;// ���ڴ洢�������
	private UserDao userDao;
	private String oldValue = "";// ���浥Ԫ��༭ ǰ��ֵ

	/**
	 * Create the panel.
	 */
	public QueryUser() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setColumnHeaderView(table);
		// ��ʼ���洢������ݵĶ���
		model = new DefaultTableModel(new Object[][] {}, new String[] { "�û����",
				"�û���", "���֤������" ,"�˺�","����"});
		// �����ݰ󶨵�������
		table.setModel(model);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		userDao = new UserDaoImpl();
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
		// ����ɵ�����
		model.getDataVector().clear();
		// ��ѯ��������
		//TableColumnModel col = table.getColumnModel();
		// ��ȡ���ŵ��У����������Ϊ������������
		List<User> list;
		try {
			list = userDao.queryAll();
			// ����ÿһ�����ݣ���ӵ�model��
			for (User user : list) {
				// ��� ������
				model.addRow(new Object[] { user.getUserid(), user.getName(),
					 user.getIdentity_number(),user.getAccount(), user.getPassword() });
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			int userid = Integer.valueOf(table.getValueAt(
					table.getSelectedRow(), 0).toString());
			userDao.delete(userid);
			loadData();
		}
	}
	
	public void updata() {
		if (table.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�������");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ�޸�");
		// �ж��û��Ƿ���
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
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�������");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ��ֵ");
		// �ж��û��Ƿ���
		if (result == JOptionPane.OK_OPTION) {
			
			int userid = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
			top_up tu = new top_up(userid);
			tu.setVisible(true);
		}
	}
	
}
