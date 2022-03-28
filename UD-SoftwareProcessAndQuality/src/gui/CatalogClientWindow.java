package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogClientWindow extends JFrame {

	private JPanel contentPane;
	private JButton jbSingIn, jbShoppingCart, jbPay  ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogClientWindow frame = new CatalogClientWindow();
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
	public CatalogClientWindow() {
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
		
		jbSingIn = new JButton("Sing In");
		jpNCenter.add(jbSingIn);
		
		JPanel jpNSouth = new JPanel();
		jpNorth.add(jpNSouth);
		
		jbShoppingCart = new JButton("Shopping Cart");
		jpNSouth.add(jbShoppingCart);
		
		JScrollPane jspCenter = new JScrollPane();
		contentPane.add(jspCenter, BorderLayout.CENTER);
		
		JPanel jpSouth = new JPanel();
		contentPane.add(jpSouth, BorderLayout.SOUTH);
		
		jbPay = new JButton("New button");
		jpSouth.add(jbPay);
		
		jbSingIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogInClientWindow logInWindow = new LogInClientWindow();
				logInWindow.setVisible(true);
				
			}
		});
		
	}
	
}
