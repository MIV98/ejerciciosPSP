
package ejercicio1;

/**
 *
 * @author Iván
 */
public class Hucha {
    public int cantidad;
    
    public synchronized void ingresar(int cantidad) {
        this.cantidad += cantidad;
        notifyAll();
    }
    
    public synchronized boolean retirar(int cantidad) {
        while (this.cantidad < cantidad) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        this.cantidad -= cantidad;
        return true;
    }

    public int getCantidad() {
        return cantidad;
    }

}
