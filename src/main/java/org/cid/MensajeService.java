package org.cid;

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

        MensajesDAO.crearMensajeDB(mensajeObject);
    }

    public static void listarMensajes(){

    }

    public static void borrarMensaje(){

    }

    public static void editarMensaje(){

    }
}
