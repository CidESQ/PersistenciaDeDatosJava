package org.cid;

import javax.crypto.spec.PSource;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("----------Aplicación de mensajes---------------");
            System.out.println("(1) Crear un mensaje.");
            System.out.println("(2) Listar mensajes");
            System.out.println("(3) Editar un mensaje");
            System.out.println("(4) Eliminar un mensaje");
            System.out.println("(5) Salir");
            System.out.println("Ingresa una opción:");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> MensajeService.crearMensaje();
                case 2 -> MensajeService.listarMensajes();
                case 3 -> MensajeService.editarMensaje();
                case 4 -> MensajeService.borrarMensaje();
                default -> {
                }
            }
        }while(opcion != 5);
        ConnectDatabase.getConnection().close();
    }
}