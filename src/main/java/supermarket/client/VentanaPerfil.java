package supermarket.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import supermarket.domain.User;

public class VentanaPerfil extends JFrame {


	private JTable jTable;
	private String[][] tableData =
			{{"01", "Adam", "1986"},
			{"02", "John", "1990"},
			{"03", "Sam", "1989"},
			{"04", "Derek", "1991"},
			{"05", "Ben", "1981"},
			{"06", "Alice", "1981"},
			{"07", "Harry", "1981"},
			{"08", "Bob", "1981"}};
	private String[] tableColumn = {"Order ID", "Date", "Amount spended"};
	//private JScrollPane jScrollPane;


	private JPanel contentPane, jpCenter, jpCenterLeft, jpCenterRight, jpSouth, jpButton;
	private JTable jtOrderRecord;
	private JLabel jlPhoto, jlName, jlSurName, jlID, jlEmail, jlNick, jlUserName, jlUserSurName, jlUserID, jlUserEmail, jlTable;
	private JButton jbReturn;



		public void VentanaPerfil(JFrame ventanaAnterior, User user) {
			//Characteristics of the main window
			setTitle("Profile");

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 700, 900);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			//Panels

			jpCenter = new JPanel();
			contentPane.add(jpCenter, BorderLayout.CENTER);
			jpCenter.setLayout(new GridLayout(1, 2, 0, 0));

			jpCenterLeft = new JPanel();
			jpCenter.add(jpCenterLeft);
			jpCenterLeft.setLayout(new GridLayout(5, 1, 0, 0));

			jpSouth = new JPanel();
			contentPane.add(jpSouth, BorderLayout.SOUTH);
			jpSouth.setLayout(new GridLayout(3, 0, 0, 0));


			jpCenterRight = new JPanel();
			jpCenter.add(jpCenterRight);
			jpCenterRight.setLayout(new GridLayout(5, 0, 0, 0));

			//Labels

			jlPhoto = new JLabel();
			jlPhoto.setIcon(new ImageIcon("src/main/java/supermarket/client/images/userFoto.png"));
			jlPhoto.setHorizontalAlignment(SwingConstants.CENTER);
			jpCenterLeft.add(jlPhoto);

			jlName = new JLabel("Name");
			jlName.setHorizontalAlignment(SwingConstants.RIGHT);
			jpCenterLeft.add(jlName);

			jlSurName = new JLabel("Surname");
			jlSurName.setHorizontalAlignment(SwingConstants.RIGHT);
			jpCenterLeft.add(jlSurName);

			jlID = new JLabel("ID");
			jlID.setHorizontalAlignment(SwingConstants.RIGHT);
			jpCenterLeft.add(jlID);

			jlEmail = new JLabel("E-mail");
			jlEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			jpCenterLeft.add(jlEmail);

			jlNick = new JLabel("@" + user.getUsername());
			jpCenterRight.add(jlNick);

			jlUserName = new JLabel("   " + user.getName());
			jpCenterRight.add(jlUserName);

			jlUserSurName = new JLabel("   " + user.getLastName());
			jpCenterRight.add(jlUserSurName);

			jlUserID = new JLabel(String.valueOf("   " + user.getId()));
			jpCenterRight.add(jlUserID);

			jlUserEmail = new JLabel("   " + user.getEmail());
			jpCenterRight.add(jlUserEmail);

			jlTable = new JLabel("Client order records");
			jlTable.setHorizontalAlignment(SwingConstants.CENTER);
			jpSouth.add(jlTable);

			//Table

			jtOrderRecord = new JTable(tableData, tableColumn);
			//jScrollPane= new JScrollPane(jtOrderRecord);
			jpSouth.add(jtOrderRecord);

			//Buttons

			jpButton = new JPanel();
			jpSouth.add(jpButton);

			jbReturn = new JButton("Go back");
			jpButton.add(jbReturn);


			//ActionListeners


			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			setSize(1150, 505);

			setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout(0, 0));


			jbReturn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					setVisible(false);
				}
			});

			setVisible(true);
		}


	}
