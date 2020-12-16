package ui;
/**
 * 管理员UI
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Administrator_ui extends JFrame {
	 JPanel contentPane4;
	 JPanel contentPane; 
	 JPanel panelBottom;
	private JButton button3;
	private JButton button4;	
	public Administrator_ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 500, 200);
			
			
		contentPane4 = new JPanel();
		contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane4.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane4);
		
		JPanel paneld = new JPanel();
		contentPane4.add(paneld, BorderLayout.CENTER);
		
		paneld.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
	
		button3 = new JButton("车票管理");
		paneld.add(button3);
		button3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Ticketmanagement_ui cpgl = new Ticketmanagement_ui();
				cpgl.setVisible(true);
				
			}
		});
		
		button4 = new JButton("用户管理");
		paneld.add(button4);
		button4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Usermanagement_ui yhgl = new Usermanagement_ui();
				yhgl.setVisible(true);
				
			}
		});
         
	}
}
