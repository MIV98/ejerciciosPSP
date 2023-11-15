
package ejercicio1;

import java.util.Random;

/**
 *
 * @author Iván
 */
public class Hijo extends Thread {
    private static final int NUM_RETIRADAS = 10;
    private static final int MIN_ESPERA = 100;
    private static final int MAX_ESPERA = 500;
    
    private Hucha hucha;
    private int retiradas;
    private int currCant;
    private int oldCant; // ??

    public Hijo(String name, Hucha hucha) {
        super(name);
        this.hucha = hucha;
        this.retiradas = 0;
        this.currCant = 1;
        this.oldCant = 0;
    }

    @Override
    public void run() {
        while (retiradas < NUM_RETIRADAS) {
            try {
                Thread.sleep(new Random().nextInt(MIN_ESPERA, MAX_ESPERA + 1));
                
                if (hucha.retirar(currCant)) {
                    System.out.println(this.getName() + " coge " + currCant + "€");
                    // TODO fib
                    int aux = oldCant;
                    this.oldCant = currCant;
                    this.currCant = currCant + aux;
                    this.retiradas++;
                } 
                
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        System.out.println(this.getName() + " HA MADURADO");
    }
    
}
