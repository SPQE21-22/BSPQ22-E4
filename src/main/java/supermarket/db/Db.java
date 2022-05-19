package supermarket.db;


import java.sql.*;
import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;

public class Db {
    Connection conn = null;
    Statement stmtGlobal;
    private static boolean LOGGING = true;

    // METODO PARA CONECTAR CON LA BASE DE DATOS
    public void connect() {
        try {
            String url = "jdbc:sqlite:sqlite/main.db";
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                stmtGlobal = conn.createStatement();
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    // METODO PARA DESCONECTAR CON LA BASE DE DATOS
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar sql base");
        }
    }

    // OBTENER TODOS LOS USUARIOS DE LA BASE DE DATOS
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM USER;";
        try {
            ResultSet rs = stmtGlobal.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setCardNumber(rs.getString("CARDNUMBER"));
                user.setPhoneNumber(rs.getString("PHONENUMBER"));
                users.add(user);
            }
        } catch (SQLException | DateTimeParseException e) {
            System.out.println("ERROR Obteniendo los users en DB" + e.toString());
        }
        return users;
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO user (email, username, password, name, lastName, address, cardNumber, phoneNumber) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getName());
            pst.setString(5, user.getLastName());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getCardNumber());
            pst.setString(8, user.getPhoneNumber());
            pst.executeUpdate();
            pst.close();

            return true;
        } catch (SQLException | DateTimeParseException e) {
            System.out.println("ERROR register DB" + e.toString());
        }
        return false;
    }
    //METHOD GETUSER
    public User getUser(String username) {
        User user = new User();
        String sql = "SELECT * FROM USER WHERE username = '" + username + "';";
        try {
            ResultSet rs = stmtGlobal.executeQuery(sql);
            while (rs.next()) {    
                user.setId(rs.getString("USER_ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setCardNumber(rs.getString("CARDNUMBER"));
                user.setPhoneNumber(rs.getString("PHONENUMBER"));
            }
        } catch (SQLException | DateTimeParseException e) {
            System.out.println("BD PARTE 1 USER -- >" + e.toString());
        }
    
        List<Order> orderListTemp = new ArrayList<Order>();
        List<Order> orderList = new ArrayList<Order>();
        String sql2 = "SELECT * FROM cashOrder WHERE user_id = '" + user.getId() + "'";
        try {
            Order order;
            ResultSet rs2 = stmtGlobal.executeQuery(sql2);
            while (rs2.next()) {
                order = new Order();
                order.setId(String.valueOf(rs2.getInt("cashOrder_id")));
                order.setDate(rs2.getString("date"));
                order.setPrice(rs2.getFloat("price"));
                order.setProductList(new ArrayList<Product>());
                System.out.println("ORDER EN DB"+ order.toString());
                orderListTemp.add(order);
            }
        } catch (Exception e) {
            System.out.println("BD PARTE 2 USER -- >" + e.toString());
        }
        System.out.println(orderListTemp.toString());
        System.out.println("ANTES DEL FOR 127");
        for (Order order : orderListTemp) {
            System.out.println("ENTRA FOR");
            System.out.println("ORDER EN EL FOR" + order.toString());
            List<String> productIdList = new ArrayList<String>();
            List<Product> productList = new ArrayList<Product>();
            String sql3 = "SELECT * FROM relationship WHERE cashOrder_id = '" + order.getId() + "'";

            try {
                System.out.println("primer try");
                ResultSet rs3 = stmtGlobal.executeQuery(sql3);
                while (rs3.next()) {
                    productIdList.add(String.valueOf(rs3.getInt("product_id")));
                    System.out.println("product id :" + String.valueOf(rs3.getInt("product_id")));
                }
            } catch (Exception e) {
                System.out.println("BD PARTE 3 USER -- >" + e.toString());
            }

            for (String productId : productIdList) {
                System.out.println("entra 2 For");
                String sql4 = "SELECT * FROM product WHERE product_id = '" + productId + "'";
                System.out.println("productId: " + productId);
                try {
                    System.out.println("segundo try");
                    ResultSet rs4 = stmtGlobal.executeQuery(sql4);
                    System.out.println("segundo try 2");
                    while (rs4.next()) {
                        System.out.println("segundo try 3");
                        Product product = new Product();
                        product.setId(String.valueOf(rs4.getInt("product_id")));
                        product.setCategory(rs4.getString("category"));
                        product.setName(rs4.getString("name"));
                        product.setBrand(rs4.getString("brand"));
                        product.setStock(rs4.getInt("stock"));
                        product.setExpirationDate(rs4.getString("expirationDate"));
                        product.setDiscountPercentage(rs4.getFloat("discountPercentage"));
                        product.setPrice(rs4.getFloat("price"));
                        System.out.println("producto: " + product.toString());
                        productList.add(product);
                    }
                } catch (Exception e) {
                    System.out.println("BD PARTE 4 USER -- >" + e.toString());
                }
            }
            order.setProductList(productList);
            System.out.println("order: " + order.toString());
            orderList.add(order);
        }
        System.out.println("orderList: " + orderList.toString());
        user.setOrderList(orderList);
        return user;
    }

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            ResultSet rs4 = stmtGlobal.executeQuery(sql);
            while (rs4.next()) {
                Product product = new Product();
                product.setId(String.valueOf(rs4.getInt("product_id")));
                product.setCategory(rs4.getString("category"));
                product.setName(rs4.getString("name"));
                product.setBrand(rs4.getString("brand"));
                product.setStock(rs4.getInt("stock"));
                //error con dates

                product.setExpirationDate(rs4.getString("expirationDate"));
                product.setDiscountPercentage(rs4.getFloat("discountPercentage"));
                product.setPrice(rs4.getFloat("price"));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("ERROR get products DB" + e.toString());
        }
        return productList;
    }

    public boolean addOrder(String userId, Order order) {
        List<Product> products = new ArrayList<>();
        products = order.getProductList();
        int productId = 0;
        int cashorderId = 0;
        String sql = "INSERT INTO cashorder (user_id, date, price) VALUES (?,?,?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(userId));
            pst.setString(2, order.getDate());
            pst.setFloat(3, order.getPrice());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println("ERROR ADDING ORDER 1 tryCatch: --> " + e.toString());
        }
        
        String sql2 = "SELECT cashorder_id FROM cashorder ORDER BY cashorder_id DESC LIMIT 1;";
            try {
                ResultSet rs = stmtGlobal.executeQuery(sql2);
                while (rs.next()) {
                    cashorderId = rs.getInt("cashorder_id");

                }
            } catch (SQLException e) {
                System.out.println("ERROR ADDING ORDER 2 tryCatch: --> " + e.toString());

            }

        //order added
        for (Product product : products) {
            String sql3 = "INSERT OR IGNORE INTO product (category, name, brand, stock, expirationDate, discountPercentage, price) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst3 = conn.prepareStatement(sql3);
                pst3.setString(1, product.getCategory());
                pst3.setString(3, product.getName());
                pst3.setString(3, product.getBrand());
                pst3.setInt(4, product.getStock());
                pst3.setString(5, product.getExpirationDate());
                pst3.setFloat(6, (float) product.getDiscountPercentage());
                pst3.setFloat(7, (float) product.getPrice());
                pst3.executeUpdate();
                pst3.close();
            } catch (SQLException e) {
                System.out.println("ERROR ADDING ORDER 3 tryCatch: --> "+ e.toString());

            }

            String sql4 = "SELECT product_id FROM product WHERE name = '" + product.getName() + "'";
            try {
                ResultSet rs = stmtGlobal.executeQuery(sql4);
                while (rs.next()) {
                    productId = rs.getInt("product_id");
                }
            } catch (SQLException e) {
                System.out.println("ERROR ADDING ORDER 4 tryCatch: --> " + e.toString());

            }

            try {

                String sql5 = "INSERT INTO relationship (cashOrder_id, product_id) VALUES (?,?)";
                PreparedStatement pst5 = conn.prepareStatement(sql5);

                pst5.setInt(1, cashorderId);
                pst5.setInt(2, productId);
                pst5.executeUpdate();
                pst5.close();
            } catch (SQLException e) {
                System.out.println("ERROR ADDING ORDER  --> "+ e.toString());
            }catch (Exception e){
                System.out.println("EXCEPTION" + e.toString());
            }
        }
        return true;
    }
}