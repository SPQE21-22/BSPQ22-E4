package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.db.db;
import supermarket.domain.Order;
import supermarket.domain.User;

import javax.swing.*;


public class SupermarketServer {

    protected List<User> listUser = new ArrayList<>();
    protected User user1 = new User("sergio", "1234", "1234", "1234", "1234", "1234" ,"1234", "1234", new ArrayList<Order>());
    protected User user2 = new User("pablo", "1234", "1234", "1234", "1234","1234" ,"1234", "1234", new ArrayList<Order>());

    public boolean login(String username, String password) {
        //sql part


        return true;
    }

    public User getUserInfo() {
        User user = new User();
        user.setUsername("sergio");
        return user;
    }
}