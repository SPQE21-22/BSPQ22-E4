package gui;

import java.awt.BorderLayout;
import util.JTextFieldRedondo;
import util.JPasswordFieldRedondo;
import util.JButtonRedondo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SingUpClientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtfMail;
	private JTextField jtfNick;
	private JTextField jtfPassword;
	private JTextField jtfPhoneNumber;
	private JTextField jtfAddress;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SingUpClientWindow frame = new SingUpClientWindow();
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
	public SingUpClientWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jpNorth = new JPanel();
		contentPane.add(jpNorth, BorderLayout.NORTH);
		
		JLabel jlSingIn = new JLabel("SING UP");
		jpNorth.add(jlSingIn);
		
		JPanel jpSouth = new JPanel();
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		
		JButton jbContinue = new JButtonRedondo();
		jbContinue.setText("Continue");
		jpSouth.add(jbContinue);
		
		JPanel jpCenter = new JPanel();
		contentPane.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel jpCMail = new JPanel();
		jpCenter.add(jpCMail);
		
		jtfMail = new JTextFieldRedondo("mail");
		jpCMail.add(jtfMail);
		jtfMail.setColumns(10);
		
		JPanel jpCNick = new JPanel();
		jpCenter.add(jpCNick);
		
		jtfNick = new JTextFieldRedondo("User");
		jpCNick.add(jtfNick);
		jtfNick.setColumns(10);
		
		JPanel jpCPassword = new JPanel();
		jpCenter.add(jpCPassword);
		
		jtfPassword = new JTextFieldRedondo("Password");
		jpCPassword.add(jtfPassword);
		jtfPassword.setColumns(10);
		
		JPanel jpCPhone = new JPanel();
		jpCenter.add(jpCPhone);
		
		jtfPhoneNumber = new JTextFieldRedondo("Phone number");
		jpCPhone.add(jtfPhoneNumber);
		jtfPhoneNumber.setColumns(10);
		
		JPanel jpCAddress = new JPanel();
		jpCenter.add(jpCAddress);
		
		jtfAddress = new JTextFieldRedondo("Address");
		jpCAddress.add(jtfAddress);
		jtfAddress.setColumns(10);
		
		jbContinue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountClientWindow accountWindow = new AccountClientWindow();
				accountWindow.setVisible(true);
			}
		});
	}

}
