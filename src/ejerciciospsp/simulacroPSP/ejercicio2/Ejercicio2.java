
package ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author Iván
 */
public class Ejercicio2 {
    public static final int NUM_CLIENTES = 100;
    
    public static void main(String[] args) {
        Tienda t = new Tienda();
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            Cliente e = new Cliente("Cliente_" + i, t);
            clientes.add(e);
            e.start();
        }
        
        for (Cliente c : clientes) {
            try {
                c.join();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        System.out.println("NO QUEDAN EXISTENCIAS. REGISTRO DE VENTAS:");
        
        for (Venta v : t.ventas) {
            System.out.println(v);
        }
    }
}
