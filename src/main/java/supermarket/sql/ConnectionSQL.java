package supermarket.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static Connection getConnection(){
        String connectionURL= "jdbc:sqlserver://localhost:1433"
                +"database=udeusto;"
                +"user=sa;"
                +"password=root;"
                +"loginTimeout=60;";
        try {
            Connection con= DriverManager.getConnection(connectionURL);
            return con;
        }catch (SQLException ex){
            System.out.println("ERROR DE CONEXION SQL --> " + ex.toString());
            return null;

        }

    }
}
