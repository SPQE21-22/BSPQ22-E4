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
    private static boolean LOGGING = true;

    // METODO PARA CONECTAR CON LA BASE DE DATOS
    public void connect() {
        try {
            String url = "jdbc:sqlite:sqlite/main.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

           /* ScriptRunner sr = new ScriptRunner(conn);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader("script2.sql"));
            //Running the script
            sr.runScript(reader);*/

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
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
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
        String sql = "INSERT INTO user (user_id, email, username, password, name, lastName, address, cardNumber, phoneNumber) VALUES (?,?,?,?,?,?,?,?,?);";
        try (Statement stmt = conn.createStatement()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.valueOf(user.getId()));
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getUsername());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getName());
            pst.setString(6, user.getLastName());
            pst.setString(7, user.getAddress());
            pst.setString(8, user.getCardNumber());
            pst.setString(9, user.getPhoneNumber());
            pst.executeUpdate();
            pst.close();

            return true;
        } catch (SQLException | DateTimeParseException e) {
            System.out.println("ERROR Obteniendo los users en DB");
        }
        return false;
    }
    
    public User getUser(String username) {
        User user = new User();

        String sql = "SELECT * FROM USER WHERE username = '" + username + "';";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
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
            e.printStackTrace();
        }
    
        List<Order> orderList = new ArrayList<Order>();
        try (Statement stmt2 = conn.createStatement()) {
            String sql2 = "SELECT * FROM cashOrder WHERE user_id = '" + user.getId() + "'";
            ResultSet rs2 = stmt2.executeQuery(sql2);
            while (rs2.next()) {
                Order order = new Order();
                order.setId(rs2.getString("cashOrder_id"));
                order.setDate(Date.valueOf(rs2.getString("date")));
                order.setPrice(rs2.getFloat("price"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (Order order : orderList) {
            List<String> productIdList = new ArrayList<String>();
            List<Product> productList = new ArrayList<Product>();
            
            try (Statement stmt3 = conn.createStatement()) {
                String sql3 = "SELECT * FROM relationship WHERE cashOrder_id = '" + order.getId() + "'";
                ResultSet rs3 = stmt3.executeQuery(sql3);
                while (rs3.next()) {
                    productIdList.add(rs3.getString("product_id"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            for (String productId : productIdList) {
                try (Statement stmt4 = conn.createStatement()) {
                    String sql4 = "SELECT * FROM product WHERE product_id = '" + String.valueOf(productId) + "'";
                    ResultSet rs4 = stmt4.executeQuery(sql4);
                    while (rs4.next()) {
                        Product product = new Product();
                        product.setId(rs4.getString("product_id"));
                        product.setCategory(rs4.getString("category"));
                        product.setName(rs4.getString("name"));
                        product.setBrand(rs4.getString("brand"));
                        product.setStock(rs4.getInt("stock"));
                        product.setExpirationDate(rs4.getDate("expirationDate"));
                        product.setDiscountPercentage(rs4.getFloat("discountPercentage"));
                        product.setPrice(rs4.getFloat("price"));
                        productList.add(product);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            order.setProductList(productList);
            orderList.add(order);
        }
        user.setOrderList(orderList);
        return user;
    }

    public boolean addOrder(Order order, String username) {
        return false;
    }
}