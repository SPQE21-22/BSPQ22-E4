package supermarket.client;

import supermarket.domain.User;
import supermarket.util.SupermarketException;
import javax.ws.rs.client.WebTarget;

import javax.swing.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


public class Registration extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9;
    JTextField tf1, tf2, tf5, tf6, tf7,tf8;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    private WebTarget webTarget;

    Registration()
    {
        setVisible(true);
        setResizable(false);
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registratiosn Form ");
        l1 = new JLabel("REGISTER");
        l1.setForeground(Color.black);
        l2 = new JLabel("Name:");
        l3 = new JLabel("Last Name:");
        l4 = new JLabel("Create Password:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Adress:");
        l7 = new JLabel("Card No.:");
        l8 = new JLabel("Phone:");
        l9 = new JLabel("Username");
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        l9.setBounds(80, 350, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        tf8.setBounds(300, 350, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(l9);
        add(tf7);
        add(tf8);
        add(btn1);
        add(btn2);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1)
        {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            char[] s3 = p1.getPassword();
            char[] s4 = p2.getPassword();
            String s8 = new String(s3);
            String s9 = new String(s4);
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            String s10 = tf8.getText();
            if (s8.equals(s9))
            {
                try
                {
                    //lanzar register
                    User user = new User();
                    //fix non working methods to launch register
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            }
        }
        else{


            String hostname = "127.0.0.1";
            String port ="8080";
            Login login = new Login(hostname, port);
            setVisible(false);
        }
    }

    public boolean register() throws SupermarketException {
        WebTarget supermarketWebTarget = webTarget.path("server/register");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
        Boolean bool=false;
        User user = new User();

        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
        System.out.println("estado de response status " + response.getStatusInfo());
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new SupermarketException("" + response.getStatus());
        } else {
            bool = response.readEntity(Boolean.class);

        }
        return bool;
    }

}
