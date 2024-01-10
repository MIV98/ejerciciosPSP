
package sockets.ejercicio2.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MIV
 */
public class ThreadedSocket extends Thread {

    private Socket socket;
    private ServerSocket server;
    
    public static final String FIN = "fin";
    public static final String SHUTDOWN = "shutdown";

    public ThreadedSocket(ServerSocket server) {
        this.server = server;
    }
    
    @Override
    public void run() {
        
    }
    
}
