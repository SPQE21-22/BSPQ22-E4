package supermarket.client;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

//problemas imports con libs externas
import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import supermarket.domain.*;
import supermarket.db.Db;
import supermarket.util.SupermarketException;


public class FinalVentana extends JFrame {
    JPanel pnlCentral;
    JPanel pnlCentralIzq;
    JPanel pnlCentralDer;
    JPanel pnlCentralCent;
    JLabel p;
    JLabel p1;
    JButton cash;
    JButton card;
    JButton invoice;
    ImageIcon imagenEfectivo;
    Image image2;
    Image newImg2;

    private WebTarget webTarget;
    private Client client;

    ImageIcon imagenTarjeta;
    Image image3;
    Image newImg3;

    Product Pizza1;

    String ruta = "src/factura.txt";
    String contenido = "prueba";
    File file = new File(ruta);

    public FinalVentana(Order order, User user) {
        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", "127.0.0.1", "8080"));
        // para test de ventana
        List<Product> productList = new ArrayList<Product>();

        Pizza1 = new Product();
        // a�adir datos con sets a este producto

        productList.add(Pizza1);

        setTitle("Perfil");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(1150, 505);

        pnlCentral = new JPanel();

        pnlCentralIzq = new JPanel();
        pnlCentralDer = new JPanel();
        pnlCentralCent = new JPanel();

        GridLayout gridLayout1 = new GridLayout();

        gridLayout1.setRows(1);
        gridLayout1.setHgap(30);
        gridLayout1.setVgap(30);
        gridLayout1.setColumns(3);

        GridLayout gridLayout2 = new GridLayout();
        gridLayout2.setRows(3);
        gridLayout2.setHgap(30);
        gridLayout2.setColumns(1);

        pnlCentral.setLayout(gridLayout1);

        pnlCentral.setBackground(Color.WHITE);

        p = new JLabel();
        p.setText("TOTAL TO BE PAID:  \n" + order.getPrice());
        p.setFont(new Font("Arial", Font.BOLD, 15));

        p1 = new JLabel();
        p1.setText("SELECT PAYMENT METHOD --->");
        p1.setFont(new Font("Arial", Font.BOLD, 15));

        cash = new JButton();
        cash.setText("CASH \n");
        cash.setFont(new Font("Arial", Font.BOLD, 15));
        //FIX ROUTE IMAGE
        ImageIcon imagenEfectivo = new ImageIcon("src/main/java/supermarket/client/images/cash.png");
        Image image2 = imagenEfectivo.getImage();
        Image newImg2 = image2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        imagenEfectivo = new ImageIcon(newImg2);
        cash.setIcon(imagenEfectivo);

        card = new JButton();
        card.setText("TARJETA");
        card.setFont(new Font("Arial", Font.BOLD, 15));

        //FIX ROUTE IMAGE
        ImageIcon imagenTarjeta = new ImageIcon("src/main/java/supermarket/client/images/cc.png");
        Image image3 = imagenTarjeta.getImage();
        Image newImg3 = image3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        imagenTarjeta = new ImageIcon(newImg3);
        card.setIcon(imagenTarjeta);

        invoice = new JButton();
        invoice.setFont(new Font("Arial", Font.BOLD, 15));


        //FIX ROUTE IMAGE
        ImageIcon imagenFactura = new ImageIcon("src/main/java/supermarket/client/images/factura.png");
        Image image4 = imagenFactura.getImage();
        Image newImg4 = image4.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        imagenFactura = new ImageIcon(newImg4);
        invoice.setIcon(imagenFactura);

        JRadioButton checkPdf = new JRadioButton(".pdf");
        ButtonGroup group = new ButtonGroup();
        group.add(checkPdf);

        pnlCentralIzq.setLayout(gridLayout2);
        pnlCentralIzq.add(p);
        pnlCentralIzq.add(checkPdf);
        pnlCentralIzq.add(invoice);
        JButton finalizar = new JButton("PAY AND END");
        pnlCentralIzq.add(finalizar);

        pnlCentral.add(pnlCentralIzq);
        pnlCentral.add(cash);
        pnlCentral.add(card);
        add(pnlCentral);
        setVisible(true);

        cash.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "PAYMENT BY CASH");
            }
        });

        card.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "PAYMENT BY CARD");
            }
        });

        finalizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Db db = new Db();
                try {
                    db.connect();
                    db.addOrder(user.getId(), order);
                    db.disconnect();
                } catch (Exception e2) {
                    // TODO: handle exception
                }

                dispose();

            }
        });

        invoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Invoice invoice = new Invoice();
                if (checkPdf.isSelected()) {
                    //logger
                    try {
                        invoice.crearFacturaPdf(order);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "SELECT PDF OR TXT");
                }

            }
        });

    }


    public boolean addOrder(String userId,Order order) throws SupermarketException {
        //connection
        Boolean bool=false;
        WebTarget supermarketWebTarget = webTarget.path("server/order");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(userId, MediaType.APPLICATION_JSON));

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new SupermarketException("Exception" + response.getStatus());
        } else {
            bool = response.readEntity(Boolean.class);

        }
        return bool;
    }
}






