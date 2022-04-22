package supermarket.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supermarket.domain.Order;
import supermarket.domain.User;
import supermarket.sql.ConnectionSQL;

import javax.swing.*;


public class SupermarketServer {

    protected List<User> listUser = new ArrayList<>();
    protected User user1 = new User("sergio", "1234", "1234", "1234", "1234", "1234" ,"1234", "1234", new ArrayList<Order>());
    protected User user2 = new User("pablo", "1234", "1234", "1234", "1234","1234" ,"1234", "1234", new ArrayList<Order>());

    //here is proccessed info on methods
    //sql pending
    public boolean login(String username, String password) {
        synchronized(this) {
                System.out.println("entered in donation collector login method");
                //falta chequear sql
                String bases="";
                try {
                    Statement sql = ConnectionSQL.getConnection().createStatement();
                    String query="SELECT name FROM master.dbo.sysdatabases";
                    ResultSet result = sql.executeQuery(query);

                    while (result.next()){
                        bases += result.getString(1) + "\n" ;
                    }

                    JOptionPane.showMessageDialog(null,bases);

                } catch (SQLException e) {
                    System.out.println("ERROR LANZANDO QUERY -->" + e.toString());
                }
            return true;
        }
    }

    public User getUserInfo() {
        User user = new User();
        user.setUsername("sergio");
        return user;
    }
}