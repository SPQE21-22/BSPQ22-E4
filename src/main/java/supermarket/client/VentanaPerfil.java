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
	JLabel fPerfil;
	JTextField apellido;
	JPasswordField contrasena;
	JTextField email;
	JLabel lapellido;
	JLabel lcontrasena;
	JLabel lid;
	JLabel e;
	JLabel editar;
	JTextField id;
	JTextField tel;
	JTextField nombre;
	JButton guardar;
	JButton cerrar;
	JButton borrar;
	JButton volver;

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

		lapellido = new JLabel();
		lapellido.setText("Apellido");
		lapellido.setBounds(460, 100, 120, 120);
		lapellido.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(lapellido);

		lcontrasena = new JLabel();
		lcontrasena.setText("Contrasena");
		lcontrasena.setBounds(460, 150, 120, 120);
		lcontrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(lcontrasena);

		lid = new JLabel();
		lid.setText("Id usuario");
		lid.setBounds(460, 200, 120, 120);
		lid.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(lid);

		e = new JLabel();
		e.setText("Email");
		e.setBounds(460, 250, 120, 120);
		e.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlCentral.add(e);

		fPerfil = new JLabel();
		fPerfil.setIcon(new ImageIcon("src/main/java/supermarket/client/images/userFoto.png"));
		fPerfil.setBounds(400, 0, 120, 120);
		pnlCentral.add(fPerfil);

		// Combobox
		apellido = new JTextField(user.getLastName());
		apellido.setEditable(false);
		apellido.setBounds(580, 150, 102, 30);
		pnlCentral.add(apellido);

		contrasena = new JPasswordField(user.getPassword());
		contrasena.setEditable(false);
		contrasena.setBounds(580, 200, 102, 30);
		pnlCentral.add(contrasena);

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

		tel = new JTextField();
		tel.setText("@" + user.getUsername());
		tel.setEditable(false);
		tel.setBounds(580, 80, 180, 30);
		pnlCentral.add(tel);

		nombre = new JTextField();
		Font fuente = new Font("Dialog", Font.BOLD, 26);
		nombre.setFont(fuente);
		nombre.setText(user.getName());
		nombre.setEditable(false);
		nombre.setBounds(580, 20, 240, 50);
		pnlCentral.add(nombre);

		// Botones

		volver = new JButton();
		volver.setText("Go back");
		volver.setBackground(Color.white);
		volver.setFont(new Font("Arial", Font.PLAIN, 12));
		volver.setBounds(40, 410, 140, 30);
		pnlCentral.add(volver);

		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();

			}
		});

		setVisible(true);
	}


}
