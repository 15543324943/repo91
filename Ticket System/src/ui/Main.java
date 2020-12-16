package ui;
/**
 * 程序入口
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login_Register.AdministratorLogin;
import Login_Register.Userlogin;
import Login_Register.Userregister;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main extends JFrame  {

	 
	 JPanel contentPane2;
	 
	 JPanel paneldenglu;
	
	private JButton button1;
	private JButton button2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 534, 240);
		
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane2);
		
		JPanel panela = new JPanel();
		panela.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
		contentPane2.add(panela, BorderLayout.CENTER);
		
         button1 = new JButton("我是管理员");
         panela.add(button1);
         button1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 EventQueue.invokeLater(new Runnable() {
 					public void run() {
 						try {
 							Login_Register.AdministratorLogin gldl = new AdministratorLogin();
 							gldl.setVisible(true);
 						} catch (Exception e) {
 							e.printStackTrace();
 						}
 					}
 				});
             }
         });
         
         button2 = new JButton("我是旅客");
         button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login_Register.Userlogin yhdl = new Userlogin();
							yhdl.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
         panela.add(button2);
	
	}
}
