package supermarket.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import supermarket.domain.User;
import supermarket.util.SupermarketException;

public class Login implements Runnable {
	private JFrame frame;
	private JButton buttonEnd;
	private JButton buttonLogin;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel message;
	private JTextField userText;

	private Client client;
	private WebTarget webTarget;

	private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);

	public Login(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));


		//buenoooo
		JFrame frame = new JFrame("Udeusto Login");
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);

		thread = new Thread(this);
		thread.start();
	}

	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		//mensaje
		JLabel message = new JLabel("Trying");
		message.setOpaque(true);
		message.setForeground(Color.yellow);
		message.setBackground(Color.gray);
		panel.add(message);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);

		//Login action listener
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Login !");
				try {
					String username=userText.getText();
					String password=String.valueOf(passwordText.getPassword());
					message.setText("Trying to login");
					try {
						if (login(username, password)){
							User user = new User();
							Home home = new Home(user);
							frame.dispose();
						}
					} catch (SupermarketException ex) {
						ex.printStackTrace();
					}
					message.setText("Login of  " + username +password+ " sent");
				} catch (NumberFormatException exc) {
					message.setText(" # Error login. Login must be strings");
				}
			}

		});
		panel.add(loginButton);

		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				Registration registration=new Registration();
				//System.exit(0);
			}

		});
		panel.add(registerButton);
	}
	
	public boolean login(String username, String password) throws SupermarketException {
		WebTarget supermarketWebTarget = webTarget.path("server/user");
		Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
		Boolean bool=false;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new SupermarketException("Exception" + response.getStatus());


		} else {
			bool = response.readEntity(Boolean.class);

		}
		return bool;
	}

	public User getUserInfo() throws SupermarketException {
		WebTarget supermarketWebTarget = webTarget.path("server/supermarket");
		Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			User user = response.readEntity(User.class);
			return user;
		} else {
			throw new SupermarketException("" + response.getStatus());
		}
	}

	public void run() {
		running.set(true);
		while(running.get()) {
			try { 
				Thread.sleep(2000);
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
		}
	}

	public void stop() {

		this.running.set(false);
	}

	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		Login login = new Login(hostname, port);
	}
}