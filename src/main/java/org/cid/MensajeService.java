package org.cid;

import java.util.List;
import java.util.Scanner;
//TODO: * listarMensajes() * borrarMensajes() * editarMensajes()
public class MensajeService {

    /*
    * ACTUA COMO INTERMEDIARIO ENTRE LA CAPA DE PRESENTACION (main) Y LA CAPA DE DATOS (MensajeDAO)
    */

    public static void crearMensaje(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el mensaje:");
        String mensaje = scanner.nextLine();

        System.out.println("Escribe tu nombre:");
        String autor = scanner.nextLine();

        Mensaje mensajeObject = new Mensaje();
        mensajeObject.setMensaje(mensaje);
        mensajeObject.setAutorMensaje(autor);

        try{
            MensajesDAO.crearMensajeDB(mensajeObject);
            System.out.println("Mensaje creado correctamente! ");
        }catch (Exception e){
            System.out.println("No se pudo crear el mensaje: " + e.getMessage());
        }
    }

    public static void listarMensajes(){
        try{
            List<Mensaje> mensaje = MensajesDAO.leerMensajes();
            if (mensaje.isEmpty()){
                System.out.println("No hay mensajes!");
            }else{
                mensaje.forEach(System.out::println);
            }
        }catch (Exception e){
            System.err.println("Ocurrio un error en listar los mensajes: " + e.getMessage());
        }
    }

    public static void borrarMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el id del mensaje a eliminar: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        try{
            MensajesDAO.borrarMensaje(deleteId);
            System.out.println("Mensaje con id=" + deleteId + " borrado exitosamente.");
        }catch (Exception e){
            System.err.println("No se ha podido eliminar un mensaje con id=" + deleteId);
        }
    }

    public static void editarMensaje(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("---Actualizar un mensaje---");
        System.out.println("Ingresa el id del mensaje a actualizar: ");
        String idMensaje = scanner.nextLine();
        System.out.println("Ingresa el mensaje nuevo: ");
        String mensaje = scanner.nextLine();
        System.out.println("Ingresa el autor del mensaje: ");
        String autor = scanner.nextLine();
        Mensaje msj = new Mensaje();
        msj.setIdMensaje(idMensaje);
        msj.setMensaje(mensaje);
        msj.setAutorMensaje(autor);
        try{
            MensajesDAO.actualizarMensajeDB(msj);
            System.out.println("Mensaje actualizado!");
        }catch (Exception e){
            System.err.println("Error al actualizar el mensaje: " + e.getMessage());
        }
    }
}
