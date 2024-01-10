package sockets.ejercicio1.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import sockets.ejercicio1.server.Server;

/**
 *
 * @author MIV
 */
public class Client {
    
    public static void main(String[] args) {
        
        String msg = "";
        
        try (Socket socket = new Socket(Server.IP, Server.PORT);
                Scanner sc = new Scanner(System.in);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            
            System.out.println("Conexion establecida con " 
                    + Server.IP + ":" + Server.PORT);
            
            while (!msg.equalsIgnoreCase(Server.FIN)) {
                System.out.print("Mensaje > ");
                msg = sc.nextLine();
                out.writeUTF(msg);
                
                System.out.println("Server responde > " + in.readUTF());
            }
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
