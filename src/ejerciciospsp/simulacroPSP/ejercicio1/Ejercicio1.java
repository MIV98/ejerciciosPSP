
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author Iván
 */
public class Ejercicio1 {
    public static final int NUM_HIJOS = 5;

    public static void main(String[] args) {
        Hucha hucha = new Hucha();
        Padre p = new Padre(hucha);
        
        ArrayList<Hijo> hijos = new ArrayList<>();
        
        p.start();
        
        for (int i = 1; i <= NUM_HIJOS; i++) {
            Hijo hijo = new Hijo("Hijo " + i, hucha);
            hijos.add(hijo);
            hijo.start();
        }
        
        for (Hijo h : hijos) {
            try {
                h.join();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        p.finish();
        
    }
    
}
