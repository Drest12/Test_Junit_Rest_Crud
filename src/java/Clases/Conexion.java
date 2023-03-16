
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
 public static Connection conex() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3309/idat";
        Connection cnn = DriverManager.getConnection(url,"root","");
        return cnn;
    } 
}
