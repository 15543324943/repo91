package ui;
/**
 * ����Ա�û�����UI
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

public class Usermanagement_ui extends JFrame implements ActionListener {
		JPanel panelBottom;
	 	JPanel contentPane;
	 	private JButton yhQue;
	 	private JButton yhDel;
		private JButton yhAdd;
		private JButton yhUpdata;
		private JButton yuchonfzhi;
		private JButton tuichu;
		private JButton tzcp;
		private AddUser add;
		private QueryUser query;
		private	UpdataUser updata;
		
	public Usermanagement_ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 800, 800);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//��ʽ����
		
		yhQue = new JButton("�鿴�û���Ϣ");
		panel.add(yhQue);
		yhQue.setActionCommand("que");
		

		yhDel = new JButton("ɾ����ѡ");
		panel.add(yhDel);
		yhDel.setActionCommand("del");
		
		yhAdd = new JButton("����û�");
		panel.add(yhAdd);
		yhAdd.setActionCommand("add");
		
		yhUpdata = new JButton("�޸��û�");
		panel.add(yhUpdata);
		yhUpdata.setActionCommand("updata");
		

		yuchonfzhi = new JButton("��ֵ");
		panel.add(yuchonfzhi);
		yuchonfzhi.setActionCommand("chongzhi");
		
		tzcp = new JButton("�û�����");
		panel.add(tzcp);
		
		tuichu = new JButton("�˳�");
		panel.add(tuichu);
		
		tuichu.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ){ 
				dispose();
			}
			
		}); 
		
		tzcp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Ticketmanagement_ui tic = new Ticketmanagement_ui();
				tic.setVisible(true);
			}
		});
		
		panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.CENTER);
		panelBottom.setLayout(new BorderLayout(0,0));
		
		yhDel.addActionListener(this);
		yhAdd.addActionListener(this);
		yhUpdata.addActionListener(this);
		yuchonfzhi.addActionListener(this);
		yhQue.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		System.out.println(command);
		if(command.equals("add")){
			panelBottom.removeAll();
			add=new AddUser();
			panelBottom.add(add,BorderLayout.CENTER);
			panelBottom.updateUI();
		}else if(command.equals("que")){
			panelBottom.removeAll();
			query=new QueryUser();
			panelBottom.add(query,BorderLayout.CENTER);
			panelBottom.updateUI();
		}else if(command.equals("updata")){
			if(query==null){
				JOptionPane.showMessageDialog(null, "û������");
				return;
			}
			query.updata();
			
		}else if(command.equals("chongzhi")){
			if(query==null){
				JOptionPane.showMessageDialog(null, "û������");
				return;
			}
			query.chongzhi();
			
		}else if(command.equals("del")){
			if(query==null){
				JOptionPane.showMessageDialog(null, "û������");
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
		Usermanagement_ui ss = new Usermanagement_ui();
		ss.setVisible(true);
	}
	
}


	