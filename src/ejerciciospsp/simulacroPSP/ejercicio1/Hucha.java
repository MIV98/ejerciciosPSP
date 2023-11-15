
package ejercicio1;

/**
 *
 * @author Iván
 */
public class Hucha {
    public int cantidad;
    
    public synchronized void ingresar(int cantidad) {
        this.cantidad += cantidad;
    }
    
    public synchronized boolean retirar(int cantidad) {
        if (this.cantidad < cantidad) {
            return false;
        } else {
            this.cantidad -= cantidad;
        }
        this.notifyAll();
        return true;
    }

    public int getCantidad() {
        return cantidad;
    }

}
