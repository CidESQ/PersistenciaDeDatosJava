package org.cid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String user = "cidesgon";
    private static final String pass = "Emmanuel";

    private static Connection myConnection;

    public static Connection getConnection() throws SQLException {
        if (myConnection == null || myConnection.isClosed()){
            try{
                myConnection = DriverManager.getConnection(url, user, pass);
                if (myConnection != null){
                    System.out.println("Successfully Connected");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return  myConnection;
    }
}
