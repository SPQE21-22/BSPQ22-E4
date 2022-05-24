package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.db.Db;
import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;

import javax.swing.*;

/**
 * It's a server that listens for incoming connections on a given port, and when
 * a connection is made,
 * it creates a new thread to handle the connection
 */
public class SupermarketServer {
    // It's creating a new instance of the Db class.
    private Db db = new Db();

    /**
     * It connects to the database, gets all the users, checks if the username and
     * password match any
     * of the users, and returns true if they do
     * 
     * @param username The username of the user.
     * @param password The password to be checked and encrypted.
     * @return A boolean value.
     */
    public boolean login(String username, String password) {
        // sql part
        List<User> users = new ArrayList<User>();
        db.connect();
        users = db.getAllUsers();
        // List < Producto > productos = db.getTodosProductos();
        int numeroUsuarios = users.size();
        int usuariosComprobados = 0;
        // change for 1 user
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return true;
                // esta bien logeado
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

    /**
     * > The function `register` connects to the database, adds a user, and then
     * disconnects from the
     * database
     * 
     * @param user The user object that contains the user's information.
     * @return A boolean value.
     */
    public boolean register(User user) {
        db.connect();
        boolean checkRegister = db.addUser(user);
        if (checkRegister) {
            db.disconnect();
            return true;
        }
        db.disconnect();
        return false;
    }

    /**
     * "Connect to the database, get a list of users, disconnect from the database,
     * and return the list
     * of users."
     * 
     * The problem with this function is that it's not very readable. It's hard to
     * tell what's going
     * on. It's also not very maintainable. If you wanted to add a new step to the
     * function, you'd have
     * to add it in the middle of the function
     * 
     * @return A list of users
     */
    public List<User> getUserList() {
        db.connect();
        List<User> userList = new ArrayList<User>();
        userList = db.getAllUsers();
        if (userList != null) {
            db.disconnect();
            return userList;
        }
        db.disconnect();
        return null;
    }

    /**
     * "Get a user from the database, if the user exists, return it, otherwise
     * return null."
     * 
     * The problem with this function is that it's hard to read. It's hard to read
     * because it's hard to
     * follow the flow of the function. The flow of the function is not linear. It's
     * not linear because
     * the function has multiple return statements
     * 
     * @param username The username of the user you want to get.
     * @return A user object
     */
    public User getUser(String username) {
        db.connect();
        User user = db.getUser(username);
        if (user != null) {
            db.disconnect();
            return user;
        }
        db.disconnect();
        return null;
    }

    /**
     * "Connect to the database, get the product list, disconnect from the database,
     * and return the
     * product list."
     * 
     * The problem with this function is that it's not very readable. It's hard to
     * tell what's going
     * on. It's also not very maintainable. If you wanted to add a new step to the
     * function, you'd have
     * to add it to the middle of the function
     * 
     * @return A list of products
     */
    public List<Product> getProductList() {
        db.connect();

        List<Product> productList = new ArrayList<>();
        productList = db.getProductList();
        if (productList != null) {
            db.disconnect();
            return productList;
        }
        db.disconnect();
        return null;

    }

    /**
     * "This function connects to the database, gets a list of products from the
     * database, disconnects
     * from the database, and returns the list of products."
     * 
     * The problem with this function is that it's doing too much. It's doing the
     * following:
     * 
     * * Connecting to the database
     * * Getting a list of products from the database
     * * Disconnecting from the database
     * * Returning the list of products
     * 
     * The function should only be doing one thing, which is getting a list of
     * products from the
     * database. The other three things should be done by other functions
     * 
     * @param category The category of the product you want to search for.
     * @return A list of products that are in the category that is passed in.
     */
    public List<Product> getProductListByCategory(String category) {
        db.connect();

        List<Product> productList = new ArrayList<>();
        productList = db.getProductListByCategory(category);
        if (productList != null) {
            db.disconnect();
            return productList;
        }
        db.disconnect();
        return null;

    }

    /**
     * This function adds an order to the database
     * 
     * @param user The user who is making the order.
     * @return A boolean value.
     */
    public boolean addOrder(User user) {
        db.connect();
        List<Order> orderList = new ArrayList<>();
        orderList = user.getOrderList();
        boolean checkOrder = db.addOrder(user.getId(), orderList.get(orderList.size() - 1));
        if (checkOrder) {
            db.disconnect();
            return true;
        }
        db.disconnect();
        return false;
    }
}