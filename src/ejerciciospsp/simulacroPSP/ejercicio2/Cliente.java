
package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Iván
 */
public class Cliente extends Thread {
    public static final int MIN_ESPERA = 10;
    public static final int MAX_ESPERA = 500;
    public static final int PORCENTAJE_COMPRA = 30;
    
    private ArrayList<Producto> productos;
    private Tienda tienda;

    public Cliente(String name, Tienda tienda) {
        super(name);
        this.productos = new ArrayList<>();
        this.tienda = tienda;
    }

    @Override
    public void run() {
        Random rand = new Random();
        
        while (!tienda.chollos.isEmpty()) {
            try {
                Thread.sleep(rand.nextInt(MIN_ESPERA, MAX_ESPERA + 1));
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            
            // null checks are necessary because of how getRandomChollo() is implemented
            Producto p = this.tienda.getRandomChollo();
            
            while (this.productos.contains(p)) {
                p = this.tienda.getRandomChollo();
                if (p == null) break; // safety check or else it breaks?
            }
            
            // ??
            
            if (p != null && p.getCurrStock() <= Producto.STOCK/2) {
                this.tienda.addVenta(p, this);
                this.tienda.comprar(p);
                this.productos.add(p);
            } else {
                if (rand.nextInt(100) < 30 && p != null) {
                    // Tengo que registrar la venta antes de eliminar el producto, duh!
                    this.tienda.addVenta(p, this);
                    this.tienda.comprar(p);
                    this.productos.add(p);
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}
