package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.db.Db;
import supermarket.domain.Order;
import supermarket.domain.User;

import javax.swing.*;


public class SupermarketServer {

    protected List<User> listUser = new ArrayList<>();
    protected User user1 = new User("sergio", "1234", "1234", "1234", "1234", "1234" ,"1234", "1234", new ArrayList<Order>());
    protected User user2 = new User("pablo", "1234", "1234", "1234", "1234","1234" ,"1234", "1234", new ArrayList<Order>());

    public boolean login(String username, String password) {
        //sql part
        List<User> users = new ArrayList<User>();
        Db db= new Db();
        db.connect();
        users = db.getAllUsers();
        //List < Producto > productos = db.getTodosProductos();
        int numeroUsuarios = users.size();
        int usuariosComprobados = 0;


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
            JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario");
        }
        db.disconnect();
        return false;
    }

    public User getUserInfo() {
        User user = new User();
        user.setUsername("sergio");
        return user;
    }
}