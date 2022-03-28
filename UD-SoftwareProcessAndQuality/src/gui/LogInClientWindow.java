package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import util.JPasswordFieldRedondo;
import util.JTextFieldRedondo;
import javax.swing.JTextPane;
import java.awt.Color;

public class LogInClientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUser;
	private JTextField jtfPassword;
	private JButton jbSingUp, jbLogIn;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LogInClientWindow frame = new LogInClientWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LogInClientWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jpNorth = new JPanel();
		contentPane.add(jpNorth, BorderLayout.NORTH);
		
		JLabel jlLogo = new JLabel("LOGO");
		jpNorth.add(jlLogo);
		
		JPanel jpCenter = new JPanel();
		contentPane.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel jpCNorth = new JPanel();
		jpCenter.add(jpCNorth);
		
		jtfUser = new JTextFieldRedondo("User");
		jpCNorth.add(jtfUser);
		jtfUser.setColumns(10);
		
		JPanel jpCCenter = new JPanel();
		jpCenter.add(jpCCenter);
		
		jtfPassword = new JPasswordFieldRedondo("Password");
		jpCCenter.add(jtfPassword);
		jtfPassword.setColumns(10);
		
		JPanel jpCSouth = new JPanel();
		jpCenter.add(jpCSouth);
		
		jbLogIn = new JButton("Sign In");
		jpCSouth.add(jbLogIn);
		
		JPanel jpSouth = new JPanel();
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		
		JTextPane jtpSingUp = new JTextPane();
		jpSouth.add(jtpSingUp);
		jtpSingUp.setText("Don\u00B4t have an account?");
		
		jbSingUp = new JButton("Sign up here");
		jpSouth.add(jbSingUp);
		jbSingUp.setBackground(new Color(240, 240, 240));
		
		jbSingUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SingUpClientWindow singUpWindow = new SingUpClientWindow();
				singUpWindow.setVisible(true);
				
			}
		});
		
		jbLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountClientWindow accountClientWindow = new AccountClientWindow();
				accountClientWindow.setVisible(true);
				
			}
		});
	}


}
