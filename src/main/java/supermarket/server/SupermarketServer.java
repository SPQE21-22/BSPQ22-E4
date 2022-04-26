package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.db.Db;
import supermarket.domain.Order;
import supermarket.domain.User;

import javax.swing.*;


public class SupermarketServer {
    private  Db db= new Db();
    protected List<User> listUser = new ArrayList<>();
    protected User user1 = new User("sergio", "1234", "1234", "1234", "1234", "1234" ,"1234", "1234", new ArrayList<Order>());
    protected User user2 = new User("pablo", "1234", "1234", "1234", "1234","1234" ,"1234", "1234", new ArrayList<Order>());

    public boolean login(String username, String password) {
        System.out.println("ENTRA LOGIN METHO DE SERVER(SQL)");
        //sql part
        List<User> users = new ArrayList<User>();
        db.connect();
        users = db.getAllUsers();
        //List < Producto > productos = db.getTodosProductos();
        int numeroUsuarios = users.size();
        int usuariosComprobados = 0;

        System.out.println("antes del for de leer users");
        for (User user: users) {
            System.out.println("Usuario de bd: " + user.toString());
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return true;
                //esta bien logeado
            } else {
                usuariosComprobados = usuariosComprobados + 1;
            }
        }

        if (usuariosComprobados == numeroUsuarios) { // si se han comprobado todos ---> avisamos
            JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario");
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
        return userList;
    }

    public User getUser(String username) {
        User user = db.getUser(username);
        if (user != null) {
            return user;
        }
        System.out.println("The user is null");
        return null;
    }
    
    public boolean addOrder(String username, Order order) {
        
        return false;
    }
}