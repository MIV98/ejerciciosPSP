package sockets.ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cliente de echo. <br>
 * Utiliza sockets para enviar un mensaje al servidor.<br>
 * El programa finalizará cuando el servidor responda 'fin'.
 *
 * @author Samuel
 */
public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket servidor = new Socket(Conexion.SERVIDOR(), Conexion.PUERTO());
            DataInputStream in = new DataInputStream(servidor.getInputStream());
            DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
            String respuesta, mensaje;
            System.out.println("Bienvenido/a. Introduzca un nombre para su usuario");
            do {
                System.out.print("Nombre: ");
                mensaje = sc.nextLine();
                //Enviamos el nombre del cliente
                out.writeUTF(mensaje);
                //El servidor responde
                respuesta = in.readUTF();
                System.out.println(respuesta); // TODO filter out FIN_CONN_CLIENTE
            } while (!Conexion.FIN_CONN_CLIENTE.equalsIgnoreCase(respuesta));

            servidor.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexión cerrada");
    }

}
