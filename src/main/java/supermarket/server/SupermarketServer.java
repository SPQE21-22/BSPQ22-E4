package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.db.Db;
import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;

import javax.swing.*;

public class SupermarketServer {
    private  Db db= new Db();

    public boolean login(String username, String password) {
        //sql part
        List<User> users = new ArrayList<User>();
        db.connect();
        users = db.getAllUsers();
        //List < Producto > productos = db.getTodosProductos();
        int numeroUsuarios = users.size();
        int usuariosComprobados = 0;
        //change for 1 user
        for (User user: users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return true;
                //esta bien logeado
            } else {
                usuariosComprobados = usuariosComprobados + 1;
            }
        }

        if (usuariosComprobados == numeroUsuarios) { // si se han comprobado todos ---> avisamos
            JOptionPane.showMessageDialog(null, "User is not registered");
        }
        db.disconnect();
        return false;
    }

    public boolean register(User user) {
        db.connect();
        boolean checkRegister = db.addUser(user);
        if (checkRegister) {
            return true;
        }
        return false;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        userList = db.getAllUsers();
        if(userList != null) {
            return userList;    
        }
        return null;
    }

    public User getUser(String username) {
        User user = db.getUser(username);
        if (user != null) {
            return user;
        }
        return null;
    }

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList = db.getProductList();
        if (productList != null){
            return productList;
        }
        return null;
    }
    
    public boolean addOrder(String userId, Order order) {
        db.connect();
        boolean checkOrder = db.addOrder(userId, order);
        if (checkOrder){
            return true;
        }
        return false;
    }
}