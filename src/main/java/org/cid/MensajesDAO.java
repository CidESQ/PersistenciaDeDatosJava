package org.cid;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MensajesDAO {

    /*
    *   GESTIONA LAS OPERACIONES CRUD RELACIONADAS CON LA TABLA DE mensajes
    */

    public static void crearMensajeDB(Mensaje mensaje){

        try(Connection connection = ConnectDatabase.getConnection()){
            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) VALUES (?, ?, CURRENT_DATE())";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, mensaje.getMensaje());
            preparedStatement.setString(2,mensaje.getAutorMensaje());
            preparedStatement.executeUpdate();
            System.out.println("El mensaje fue creado correctamente");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerMensajeDB(){

    }

    public static void borrarMensaje(int idMensaje){

    }

    public static void actualizarMensajeDB(Mensaje mensaje){

    }
}
