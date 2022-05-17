package supermarket.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import supermarket.domain.User;

<<<<<<< HEAD
public class VentanaPerfil extends JFrame {


	private JTable jTable;
	private String[][] tableData = {{"01", "Adam", "1986"},
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

=======
public class VentanaPerfil extends JFrame {

	JPanel pnlCentral;
	JLabel fProfile;
	JTextField lastName;
	JPasswordField password;
	JTextField email;
	JLabel llastName;
	JLabel lpassword;
	JLabel lid;
	JLabel e;
	JLabel editar;
	JTextField id;
	JTextField phone;
	JTextField name;
	JButton guardar;
	JButton cerrar;
	JButton borrar;
	JButton backbutton;
>>>>>>> b63362e643a9bbbf1e6484412251ad2cc3172454

	public VentanaPerfil(JFrame ventanaAnterior, User user) {
		//Characteristics of the main window
		setTitle("Profile");
<<<<<<< HEAD
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

		jlUserID = new JLabel(String.valueOf("   " +user.getId()));
		jpCenterRight.add(jlUserID);

		jlUserEmail = new JLabel("   " +user.getEmail());
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

		jbReturn.addActionListener(new ActionListener() {
=======
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);

		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		pnlCentral = new JPanel();
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		pnlCentral.setLayout(null);

		pnlCentral.setBackground(Color.WHITE);

		// Labels

		llastName = new JLabel();
		llastName.setText("Last Name");
		llastName.setBounds(460, 100, 120, 120);
		llastName.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(llastName);

		lpassword = new JLabel();
		lpassword.setText("Password");
		lpassword.setBounds(460, 150, 120, 120);
		lpassword.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(lpassword);

		lid = new JLabel();
		lid.setText("User id");
		lid.setBounds(460, 200, 120, 120);
		lid.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(lid);

		e = new JLabel();
		e.setText("Email");
		e.setBounds(460, 250, 120, 120);
		e.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(e);

		fProfile = new JLabel();
		fProfile.setIcon(new ImageIcon("src/main/java/supermarket/client/images/userFoto.png"));
		fProfile.setBounds(400, 0, 120, 120);
		pnlCentral.add(fProfile);

		// Combobox
		lastName = new JTextField(user.getLastName());
		lastName.setEditable(false);
		lastName.setBounds(580, 150, 102, 30);
		pnlCentral.add(lastName);

		password = new JPasswordField(user.getPassword());
		password.setEditable(false);
		password.setBounds(580, 200, 102, 30);
		pnlCentral.add(password);

		email = new JTextField(user.getEmail());
		email.setEditable(false);
		email.setBounds(580, 300, 180, 30);
		pnlCentral.add(email);

		// Textfields
		id = new JTextField();
		id.setEditable(false);
		id.setText(String.valueOf(user.getId()));
		id.setBounds(580, 250, 102, 30);
		pnlCentral.add(id);

		phone = new JTextField();
		phone.setText("@" + user.getUsername());
		phone.setEditable(false);
		phone.setBounds(580, 80, 180, 30);
		pnlCentral.add(phone);

		name = new JTextField();
		Font fuente = new Font("Dialog", Font.BOLD, 26);
		name.setFont(fuente);
		name.setText(user.getName());
		name.setEditable(false);
		name.setBounds(580, 20, 240, 50);
		pnlCentral.add(name);

		// Botones

		backbutton = new JButton();
		backbutton.setText("Go back");
		backbutton.setBounds(40, 410, 140, 30);
		pnlCentral.add(backbutton);
>>>>>>> b63362e643a9bbbf1e6484412251ad2cc3172454

		backbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});

		setVisible(true);
	}


}
