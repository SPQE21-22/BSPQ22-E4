package supermarket.client;


import supermarket.domain.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.client.*;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.swing.*;

import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.domain.Order;

import supermarket.util.SupermarketException;

public class Shopping extends JFrame  {
    double precio = 0;
    Order actualOrder;

    private WebTarget webTarget;
    private Client client;
    JFrame thisFrame = this;
    JButton meat;
    JButton fruit;
    JButton breakfast;
    JButton dessert;
    JButton drinks;
    JButton profile;
    List<Product> todosProductos;


    public Shopping(User user) {
        super("super");

        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", "127.0.0.1", "8080"));
        setSize(1150, 505);
        setVisible(true);

        DecimalFormat df = new DecimalFormat("#.00");

        // PANEL GENERAL : parte izquierda y parte derecha
        JSplitPane panelGeneral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        panelGeneral.setBorder(null);
        panelGeneral.setResizeWeight(0.66); // Esto es el porcentaje de la parte de la izquierda ---> ajustar
        panelGeneral.setEnabled(false);
        panelGeneral.setDividerSize(0);

        // --------------------------------Panel
        // DERECHA-------------------------------------
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new GridLayout(6, 2));
        DefaultListModel modeloPedido = new DefaultListModel();

        ArrayList<Product> listaPedido = new ArrayList<Product>();

        JList jlistaProductos = new JList();
        JLabel nombrePedido = new JLabel("ACTUAL ORDER:");
        JButton delete = new JButton("DELETE");
        JButton pay = new JButton("PAY");
        JLabel precioActual = new JLabel("Actual price:");

        jlistaProductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    Object producto = (Object) jlistaProductos.getSelectedValue();

                }
            }
        });
        //Actionlistener de delete
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jlistaProductos.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Select a product to be deleted");

                } else {
                    String stringProductoOrMenu = (String) jlistaProductos.getSelectedValue();
                    int i = (int) jlistaProductos.getSelectedIndex();
                    modeloPedido.remove(i);

                    for (Product product : listaPedido) {
                        if (product.toText().equals(stringProductoOrMenu)) {
                            listaPedido.remove(product);
                            precio = precio - product.getPrice();
                            precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
                        }
                    }
                }

            }
        });

        //action listener

        // ----------------------------------------Panel
        // IZQUIERDA------------------------------------

        JSplitPane panelIzquierda = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        panelIzquierda.setBorder(null);
        panelIzquierda.setResizeWeight(0.15);
        panelIzquierda.setEnabled(false);
        panelIzquierda.setDividerSize(0);

        // PanelNombre
        JSplitPane panelIzquierdaArriba = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        panelIzquierdaArriba.setBorder(null);
        panelIzquierdaArriba.setResizeWeight(0.15);
        panelIzquierdaArriba.setEnabled(false);
        panelIzquierdaArriba.setDividerSize(0);

        Font font = new Font("Cooper Black", Font.BOLD, 40);

        panelIzquierdaArriba.setBackground(Color.white);

        // nombre panelIzquierdaArriba1
        JPanel panelIzquierdaArriba1 = new JPanel();
        panelIzquierdaArriba1.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("  PRODUCT CATALOG");
        titulo.setFont(font);

        JButton atras = new JButton(new ImageIcon("src/main/java/supermarket/client/images/logoAtras2.png"));

        panelIzquierdaArriba1.add(titulo, BorderLayout.CENTER);
        panelIzquierdaArriba1.add(atras, BorderLayout.WEST);

        // nombre panelIzquierdaArriba2
        JPanel panelIzquierdaArriba2 = new JPanel();
        panelIzquierdaArriba2.setLayout(new GridLayout(1, 6));

        meat = new JButton("MEAT");
        fruit = new JButton("FRUIT");
        breakfast = new JButton("BREAKFAST");
        dessert = new JButton("DESSERT");
        drinks = new JButton("DRINKS");
        profile = new JButton("Profile");


        JButton buscar = new JButton();
        ImageIcon fot = new ImageIcon("src/main/java/supermarket/client/images/key.png");
        buscar.setSize(40, 40);
        Icon icono = new ImageIcon(
                fot.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_DEFAULT));
        buscar.setIcon(icono);
        buscar.repaint();
        buscar.setOpaque(false);
        buscar.setContentAreaFilled(false);
        buscar.setBorderPainted(false);

        panelIzquierdaArriba2.add(meat);
        panelIzquierdaArriba2.add(fruit);
        panelIzquierdaArriba2.add(breakfast);
        panelIzquierdaArriba2.add(dessert);
        panelIzquierdaArriba2.add(drinks);
        panelIzquierdaArriba2.add(profile);

        panelIzquierdaArriba.add(panelIzquierdaArriba1);
        panelIzquierdaArriba.add(panelIzquierdaArriba2);

        panelIzquierda.add(panelIzquierdaArriba);

        // Panel izquierdaAbajo
        JPanel panelIzquierdaAbajo = new JPanel();
        panelIzquierdaAbajo.setLayout(new GridLayout(2, 4, 30, 30)); // meter separacion

        // PRODUCTOS DEL  EN PanelIzquierdaAbajo


        try {
            todosProductos =new ArrayList<Product>();

            todosProductos= getProductList();

            int numeroProductos = todosProductos.size(); // para el layout

            // Para cada producto se anade al panel de productos
            for (Product product : todosProductos) {
                JPanel panelProducto = new JPanel();
                panelProducto.setLayout(new BorderLayout());
                JLabel tnombreProducto = new JLabel(product.getName() + " " + product.getPrice());
                JButton banadir = new JButton("Add");

                banadir.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        listaPedido.add(product); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                        precio = precio + product.getPrice();
                        precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
                        modeloPedido.addElement(product.toText());

                    }
                });

                // Los ingredientes del producto
                JTextArea tingredientes = new JTextArea();
                tingredientes.setEditable(false);
                tingredientes.append("PRICE:" + "\n");


                tnombreProducto.setText(product.getName() + " " + product.getPrice());

                //add to panels
                panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                panelProducto.add(tingredientes, BorderLayout.CENTER);
                panelProducto.add(banadir, BorderLayout.SOUTH);


                panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                // Y finalmente anadimos el panel
                panelIzquierdaAbajo.add(panelProducto);
                //
            }
        } catch (Exception e) {
            System.out.println("ERROR --> " + e.toString());
        }


        //START FILTERSS


        // FILTRAR SOLO BEBIDAS
        drinks.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // ----Para quitar los productos que hay anadidos-----
                Component[] components = panelIzquierdaAbajo.getComponents();
                for (Component component : components) {
                    panelIzquierdaAbajo.remove(component);
                }
                panelIzquierdaAbajo.revalidate();
                panelIzquierdaAbajo.repaint();
                // -----------------------------------------------


                List<Product> todosProductos = null;
                try {

                    todosProductos = getProductListByCategory("drinks");
                    int numeroProductos = todosProductos.size(); // para el layout

                    // Para cada producto se anade al panel de productos
                    for (Product producto : todosProductos) {
                        JPanel panelProducto = new JPanel();
                        panelProducto.setLayout(new BorderLayout());
                        JLabel tnombreProducto = new JLabel(producto.getName() + " " + producto.getPrice());
                        JButton banadir = new JButton("Add");

                        banadir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                listaPedido.add(producto); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                                precio = precio + producto.getPrice();

                                precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "�");

                                modeloPedido.addElement(producto.toText());

                            }
                        });

                        //add image
                        ImageIcon imgThisImg = new ImageIcon("src/main/java/supermarket/client/images/drinks/" + producto.getName() + ".png");
                        JLabel labelImg = new JLabel();
                        labelImg.setIcon(imgThisImg);


                        panelProducto.add(banadir, BorderLayout.SOUTH);
                        panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                        panelProducto.add(labelImg, BorderLayout.CENTER);

                        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        // Y finalmente anadimos el panel
                        panelIzquierdaAbajo.add(panelProducto);


                    }
                } catch (Exception e1) {
                }

            }
        });

        // FILTRAR BREAKFAST
        breakfast.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // ----Para quitar los productos que hay anadidos-----
                Component[] components = panelIzquierdaAbajo.getComponents();
                for (Component component : components) {
                    panelIzquierdaAbajo.remove(component);
                }
                panelIzquierdaAbajo.revalidate();
                panelIzquierdaAbajo.repaint();
                // -----------------------------------------------
                List<Product> todosProductos = null;
                try {


                    todosProductos = getProductListByCategory("breakfast");


                    int numeroProductos = todosProductos.size(); // para el layout

                    // Para cada producto se anade al panel de productos
                    for (Product producto : todosProductos) {
                        JPanel panelProducto = new JPanel();
                        panelProducto.setLayout(new BorderLayout());
                        JLabel tnombreProducto = new JLabel(producto.getName() + " " + producto.getPrice());
                        JButton banadir = new JButton("Add");

                        banadir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                listaPedido.add(producto); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                                precio = precio + producto.getPrice();

                                precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "�");

                                modeloPedido.addElement(producto.toText());

                            }
                        });


                        ImageIcon imgThisImg = new ImageIcon("src/main/java/supermarket/client/images/breakfast/" + producto.getName() + ".png");
                        JLabel labelImg = new JLabel();
                        labelImg.setIcon(imgThisImg);

                        panelProducto.add(banadir, BorderLayout.SOUTH);
                        panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                        panelProducto.add(labelImg, BorderLayout.CENTER);

                        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        // Y finalmente anadimos el panel
                        panelIzquierdaAbajo.add(panelProducto);


                    }
                } catch (Exception e1) {
                }

            }
        });


        //FILTRO DESSERT
        dessert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // ----Para quitar los productos que hay anadidos-----
                Component[] components = panelIzquierdaAbajo.getComponents();
                for (Component component : components) {
                    panelIzquierdaAbajo.remove(component);
                }
                panelIzquierdaAbajo.revalidate();
                panelIzquierdaAbajo.repaint();
                // -----------------------------------------------
                List<Product> todosProductos = null;
                try {
                    todosProductos = getProductListByCategory("dessert");
                    int numeroProductos = todosProductos.size(); // para el layout

                    // Para cada producto se anade al panel de productos
                    for (Product producto : todosProductos) {
                        JPanel panelProducto = new JPanel();
                        panelProducto.setLayout(new BorderLayout());
                        JLabel tnombreProducto = new JLabel(producto.getName() + " " + producto.getPrice());
                        JButton banadir = new JButton("Add");

                        banadir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                listaPedido.add(producto); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                                precio = precio + producto.getPrice();

                                precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "�");

                                modeloPedido.addElement(producto.toText());

                            }
                        });

                        // Los ingredientes del producto
                        ImageIcon imgThisImg = new ImageIcon("src/main/java/supermarket/client/images/dessert/" + producto.getName() + ".png");

                        JLabel labelImg = new JLabel();
                        labelImg.setIcon(imgThisImg);

                        panelProducto.add(banadir, BorderLayout.SOUTH);
                        panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                        panelProducto.add(labelImg, BorderLayout.CENTER);

                        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        // Y finalmente anadimos el panel
                        panelIzquierdaAbajo.add(panelProducto);
                    }
                } catch (Exception e1) {

                }

            }
        });

        //FILTRO FRUIT
        fruit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ----Para quitar los productos que hay anadidos-----
                Component[] components = panelIzquierdaAbajo.getComponents();
                for (Component component : components) {
                    panelIzquierdaAbajo.remove(component);
                }
                panelIzquierdaAbajo.revalidate();
                panelIzquierdaAbajo.repaint();
                // -----------------------------------------------

                List<Product> todosProductos = null;
                try {
                    todosProductos = getProductListByCategory("fruit");

                    int numeroProductos = todosProductos.size(); // para el layout

                    // Para cada producto se anade al panel de productos
                    for (Product producto : todosProductos) {
                        JPanel panelProducto = new JPanel();
                        panelProducto.setLayout(new BorderLayout());
                        JLabel tnombreProducto = new JLabel(producto.getName() + " " + producto.getPrice());
                        JButton banadir = new JButton("Add");

                        banadir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                listaPedido.add(producto); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                                precio = precio + producto.getPrice();

                                precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "�");

                                modeloPedido.addElement(producto.toText());

                            }
                        });

                        // Los ingredientes del producto

                        ImageIcon imgThisImg = new ImageIcon("src/main/java/supermarket/client/images/fruit/" + producto.getName() + ".png");
                        JLabel labelImg = new JLabel();
                        labelImg.setIcon(imgThisImg);

                        panelProducto.add(banadir, BorderLayout.SOUTH);
                        panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                        panelProducto.add(labelImg, BorderLayout.CENTER);

                        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        // Y finalmente anadimos el panel
                        panelIzquierdaAbajo.add(panelProducto);
                    }
                } catch (Exception e1) {

                }

            }
        });

        //FILTRO MEAT

        meat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ----Para quitar los productos que hay anadidos-----
                Component[] components = panelIzquierdaAbajo.getComponents();
                for (Component component : components) {
                    panelIzquierdaAbajo.remove(component);
                }
                panelIzquierdaAbajo.revalidate();
                panelIzquierdaAbajo.repaint();
                // -----------------------------------------------

                List<Product> todosProductos = null;
                try {
                    todosProductos = getProductListByCategory("meat");


                    int numeroProductos = todosProductos.size(); // para el layout

                    // Para cada producto se anade al panel de productos
                    for (Product producto : todosProductos) {
                        JPanel panelProducto = new JPanel();
                        panelProducto.setLayout(new BorderLayout());
                        JLabel tnombreProducto = new JLabel(producto.getName() + " " + producto.getPrice());
                        JButton banadir = new JButton("Add");

                        banadir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                listaPedido.add(producto); // LISTA QUE UTILIZAREMOS PARA EL PEDIDO
                                precio = precio + producto.getPrice();

                                precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "�");

                                modeloPedido.addElement(producto.toText());

                            }
                        });

                        ImageIcon imgThisImg = new ImageIcon("src/main/java/supermarket/client/images/meat/" + producto.getName() + ".png");
                        JLabel labelImg = new JLabel();
                        labelImg.setIcon(imgThisImg);

                        panelProducto.add(banadir, BorderLayout.SOUTH);
                        panelProducto.add(tnombreProducto, BorderLayout.NORTH);
                        panelProducto.add(labelImg, BorderLayout.CENTER);

                        panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                        // Y finalmente anadimos el panel
                        panelIzquierdaAbajo.add(panelProducto);
                    }
                } catch (Exception e1) {

                }

            }
        });

        //SCROLLPANE
        JScrollPane scroll = new JScrollPane(panelIzquierdaAbajo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelIzquierda.add(scroll); // aqui se anade panelIzquierdaAbajo (el de los productos) metido en el scroll
        panelIzquierdaAbajo.setBackground(Color.white);
        panelGeneral.add(panelIzquierda);

        //PAGAR
        pay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!modeloPedido.isEmpty()) {
                    Order actualOrder = new Order();
                    actualOrder.setProductList(listaPedido);

                    //control de decimales
                    BigDecimal bdd = new BigDecimal(precio);
                    bdd = bdd.setScale(2, RoundingMode.HALF_UP);
                    actualOrder.setPrice((float) bdd.doubleValue());

                    //date del order
                    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                    actualOrder.setDate(timeStamp);

                    FinalVentana finalVentana = new FinalVentana(actualOrder,user);
                    System.out.println("ORDER >> " + actualOrder.toString());

                    //new VentanaPago(pedido, usuario);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona 1 producto o mas");

                }


            }
        });
        //ATRAS

        atras.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //ventanaAnterior.setVisible(true);
                System.out.println("ATRAS");
                dispose();

            }
        });

        profile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                VentanaPerfil ventanaPerfil = new VentanaPerfil(thisFrame, user);
                System.out.println("ATRAS");

            }
        });

        jlistaProductos.setModel(modeloPedido);
        panelDerecha.add(jlistaProductos, 1, 0);

        panelDerecha.add(delete, 2, 1);
        panelDerecha.add(pay, 2, 2);
        panelDerecha.add(precioActual, 2, 3);

        panelDerecha.add(nombrePedido, 3, 0);

        panelGeneral.add(panelDerecha);
        add(panelGeneral);


    }

    public List<Product> getProductListByCategory(String category) throws SupermarketException {
        WebTarget supermarketWebTarget = webTarget.path("server/productByCategory");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(category, MediaType.APPLICATION_JSON));
        List<Product> productList2 = new ArrayList<Product>();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new SupermarketException("Exception" + response.getStatus());

        } else {
            try {
                productList2=response.readEntity( new GenericType<List<Product>>() {});

            } catch (Exception e) {
                System.out.println("EXCEPTION" + e.toString());

            }
        }
        return productList2;
    }

    public List<Product> getProductList() throws SupermarketException {
        Boolean bool=true;
        WebTarget supermarketWebTarget = webTarget.path("server/product");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(bool,MediaType.APPLICATION_JSON));

        List<Product> productList = new ArrayList<Product>();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new SupermarketException("Exception" + response.getStatus());

        } else {
            try {
                productList=response.readEntity( new GenericType<List<Product>>() {});
            } catch (Exception e) {
                System.out.println("EXCEPTION" + e.toString());

            }
        }
        return productList;
    }



}
