package supermarket.db;


import java.sql.*;
import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.jdbc.ScriptRunner;


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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        String SQL="";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT ID_USER, FIRST_NAME, LAST_NAME, PASSWORD,ADDRESS, CARD_NUMBER, PHONE_NUMBER, USER_NAME FROM USER");
            while(rs.next()) {
                User user = new User();
                user.setId("ID_USER");
                user.setName("FIRST_NAME");
                user.setLastName("LAST_NAME");
                user.setPassword("PASSWORD");
                user.setAddress("ADDRESS");
                user.setCardNumber("CARD_NUMBER");
                user.setPhoneNumber("PHONE_NUMBER");
                user.setUsername("USER_NAME");
                users.add(user);
            }
            return users;
        } catch (SQLException | DateTimeParseException e) {
            System.out.println("ERROR Obteniendo los users en DB");

        }
        return users;
    }



}