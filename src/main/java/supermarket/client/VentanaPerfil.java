package supermarket.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import supermarket.domain.User;

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

	public VentanaPerfil(JFrame ventanaAnterior, User user) {
		setTitle("Profile");
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
