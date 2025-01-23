package org.cid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MensajesDAO {

    /*
    *   GESTIONA LAS OPERACIONES CRUD RELACIONADAS CON LA TABLA DE mensajes
    */

    private static Connection getConnection(){
        return ConnectDatabase.getConnection();
    }

    public static void crearMensajeDB(Mensaje mensaje){

        String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) VALUES (?, ?, CURRENT_DATE())";
        Connection connection = getConnection();
        try(
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ){
            preparedStatement.setString(1, mensaje.getMensaje());
            preparedStatement.setString(2,mensaje.getAutorMensaje());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al insertar el mensaje en la base de datos. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<Mensaje> leerMensajes(){

        List<Mensaje> listaDeMensajes = new ArrayList<>();

        String query = "SELECT * FROM mensajes";
        Connection connection = ConnectDatabase.getConnection();
        try(
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                Mensaje mensaje = new Mensaje();
                mensaje.setIdMensaje(String.valueOf(resultSet.getInt("id_mensaje")));
                mensaje.setMensaje(resultSet.getString("mensaje"));
                mensaje.setAutorMensaje(resultSet.getString("autor_mensaje"));
                mensaje.setFechaMensaje(resultSet.getString("fecha_mensaje"));
                listaDeMensajes.add(mensaje);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer mensajes en la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return listaDeMensajes;
    }

    public static void borrarMensaje(int idMensaje){

        Connection connection = ConnectDatabase.getConnection();
        String query = "DELETE FROM mensajes WHERE id_mensaje = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, idMensaje);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.println("Error al eliminar el mensaje en la base de datos: " + e.getMessage());
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){

        Connection connection = ConnectDatabase.getConnection();
        String query = "UPDATE mensajes SET mensaje = ?, autor_mensaje = ?, fecha_mensaje = CURRENT_DATE() WHERE id_mensaje = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, mensaje.getMensaje());
            preparedStatement.setString(2, mensaje.getAutorMensaje());
            preparedStatement.setInt(3, Integer.parseInt(mensaje.getIdMensaje()));
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            System.err.println("Error al actualizar en la base de datos: " + sqlException.getMessage());
        }
    }
}
