package org.cid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url = "jdbc:mysql://localhost:3306/mensajes_app";
    private String user = "cidesgon";
    private String pass = "Emmanuel";

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            if (connection != null){
                System.out.println("Successfully Connected");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  connection;
    }
}
