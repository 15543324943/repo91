package ui;
/**
 * 管理员操作界面
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

public class Ticketmanagement_ui extends JFrame implements ActionListener{
		
		 JPanel contentPane4;
		 JPanel contentPane;
		 JPanel panelBottom;	
		private JButton tzyh;
		private JButton btnQue;
		private JButton btnDel;
		private JButton btnAdd;
		private JButton tuichu;
		private JButton btnUpd;
		private AddTicket add;
		private QueryTicket query;
	
	public Ticketmanagement_ui() {
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(500, 100, 800, 800);
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.NORTH);
			
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//流式居中
			
		
			btnQue = new JButton("查看车票信息");
			panel.add(btnQue);
			btnQue.setActionCommand("que");
			
			btnDel = new JButton("删除所选");
			panel.add(btnDel);
			btnDel.setActionCommand("del");
			
			btnAdd = new JButton("添加车票");
			panel.add(btnAdd);
			btnAdd.setActionCommand("add");
			
			btnUpd = new JButton("修改车票");
			panel.add(btnUpd);
			btnUpd.setActionCommand("upd");
			
			tzyh = new JButton("用户管理");
			panel.add(tzyh);
			
			tuichu = new JButton("退出");
			panel.add(tuichu);
			tuichu.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ){ 
					dispose();
				}
				
			}); 
			
		
	
			tzyh.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Usermanagement_ui yhgl = new Usermanagement_ui();
					yhgl.setVisible(true);
				}
			});
			
			panelBottom = new JPanel();
			contentPane.add(panelBottom, BorderLayout.CENTER);
			panelBottom.setLayout(new BorderLayout(0,0));
			
			btnQue.addActionListener(this);
			btnDel.addActionListener(this);
			btnAdd.addActionListener(this);
			btnUpd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		System.out.println(command);
		if(command.equals("add")){
			panelBottom.removeAll();
			try {
				add=new AddTicket();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelBottom.add(add,BorderLayout.CENTER);
			panelBottom.updateUI();
		}else if(command.equals("que")){
			panelBottom.removeAll();
			try {
				query=new QueryTicket();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelBottom.add(query,BorderLayout.CENTER);
			panelBottom.updateUI();
		}else if(command.equals("upd")){
			if(query==null){
				JOptionPane.showMessageDialog(null, "没有数据");
				return;
			}
			try {
				query.updata();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(command.equals("del")){
			if(query==null){
				JOptionPane.showMessageDialog(null, "没有数据");
				return;
			}
			try {
				query.del();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ticketmanagement_ui sss = new Ticketmanagement_ui();
		sss.setVisible(true);
	}
}
