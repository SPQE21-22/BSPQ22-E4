package supermarket.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:sqlite/main.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}