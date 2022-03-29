package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class AccountClientWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application2345.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountClientWindow frame = new AccountClientWindow();
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
	public AccountClientWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jpNorth = new JPanel();
		contentPane.add(jpNorth, BorderLayout.NORTH);
		jpNorth.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel jpNLeft = new JPanel();
		jpNorth.add(jpNLeft);
		
		JButton jbLogo = new JButton("LOGO");
		jpNLeft.add(jbLogo);
		
		JPanel jpNCenter = new JPanel();
		jpNorth.add(jpNCenter);
		
		JButton jbShop = new JButton("Shop");
		jpNCenter.add(jbShop);
		
		JPanel jpNRight = new JPanel();
		jpNorth.add(jpNRight);
		
		JButton jbLogOut = new JButton("Log Out");
		jpNRight.add(jbLogOut);
		
		JPanel jpCenter = new JPanel();
		contentPane.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel jpCNorth = new JPanel();
		jpCenter.add(jpCNorth);
		
		JLabel jlNameUser = new JLabel("User nick");
		jpCNorth.add(jlNameUser);
		
		JPanel jpCSouth = new JPanel();
		jpCenter.add(jpCSouth);
		
		jbShop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CatalogClientWindow catalogWindow = new CatalogClientWindow();
				catalogWindow.setVisible(true);
				
			}
		});
		
		jbLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	
	}

}
