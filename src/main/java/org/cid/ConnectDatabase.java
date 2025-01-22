package org.cid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String USER = "cidesgon";
    private static final String PASS = "Emmanuel";

    private static volatile Connection myConnection;

    //ConstrcutorPrivado para evitar instancias
    private ConnectDatabase(){}

    public static Connection getConnection(){
        if (myConnection == null){
            synchronized (ConnectDatabase.class){
                if (myConnection == null){ //Double check locking
                    try {
                        myConnection = DriverManager.getConnection(URL, USER, PASS);
                        System.out.println("Successfully Connected");
                    } catch (SQLException e) {
                        throw new RuntimeException("Error al conectar con la base de datos", e);
                    }
                }
            }
        }
        return  myConnection;
    }

    public static void closeConnection() {
        if (myConnection != null) {
            synchronized (ConnectDatabase.class) {
                if (myConnection != null) {
                    try {
                        myConnection.close();
                        myConnection = null; // Reiniciamos la conexión
                        System.out.println("Conexión cerrada exitosamente");
                    } catch (SQLException e) {
                        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
                    }
                }
            }
        }
    }
}
