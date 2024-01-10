
package ejercicio1;

/**
 *
 * @author Iván
 */
public class Padre extends Thread {
     public static final int INGRESO_HUCHA = 10;
    public static final int TIEMPO_ESPERA = 1000;
    private Hucha hucha;
    private int semana = 1;
    private boolean over;

    public Padre(Hucha hucha) {
        this.hucha = hucha;
        this.over = false;
    }
    
    
    
    @Override
    public void run() {
        while (!isOver()) {
            System.out.println("Semana " + this.semana);
            this.hucha.ingresar(INGRESO_HUCHA);
            this.semana++;
            try {
                Thread.sleep(TIEMPO_ESPERA);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        System.out.println("----- FIN -----\n" + 
                "Dinero restante " + this.hucha.getCantidad() + "€");
    }
    
    public void finish() {
        this.over = true;
    }
    
    public boolean isOver() {
        return this.over;
    }
    
}
