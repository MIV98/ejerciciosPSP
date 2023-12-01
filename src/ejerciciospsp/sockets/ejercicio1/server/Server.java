
package sockets.ejercicio1.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author MIV
 */
public class Server {
    
    public static final String IP = "10.0.2.15";
    public static final int PORT = 7;
    public static final String FIN = "fin";
    
    public static void main(String[] args) {

        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try (ServerSocket server = new ServerSocket(PORT);) { 
            
            System.out.println("Server escuchando en puerto " + PORT);
            
            socket = server.accept();
            
            System.out.println("Conexion establecida con " + socket.getInetAddress());
            
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            
            String msg = "";
            
            while (!msg.equalsIgnoreCase(FIN)) {
                msg = in.readUTF();
                System.out.println("SERVER recibe > " + msg);
                out.writeUTF(msg);
            }
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (socket != null) socket.close();
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            
            System.out.println("Server se cierra.");
        }
        
    }
    
}
