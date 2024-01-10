
package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Iván
 */
public class Tienda {
    public static final int NUM_CHOLLOS = 10;
    
    public ArrayList<Producto> chollos;
    public ArrayList<Venta> ventas;

    public Tienda() {
        ArrayList<Producto> listaChollos = new ArrayList<>();
        
        for (int i = 1; i <= NUM_CHOLLOS; i++) {
            listaChollos.add(new Producto("Producto_" + i));
        }
        
        this.chollos = listaChollos;
        this.ventas = new ArrayList<>();
    }
    
    public synchronized void comprar(Producto p) {
        // TODO refactor (readability)
        int indice = this.chollos.indexOf(p);
        
        this.chollos.get(indice).comprar();
        System.out.println("Vendido producto " + p.getName());
        
        if (!this.chollos.get(indice).hasStock()) {
            this.chollos.remove(p);
        }
    }
    
    public synchronized Producto getRandomChollo() {
        if (this.chollos.isEmpty()) return null;
        return this.chollos.get(new Random().nextInt(this.chollos.size()));
    }
    
    public synchronized void addVenta(Producto p, Cliente c) {
        // resto 1 porque este método tiene que ser llamado antes de comprar(p)
        // La solución sería integrar este método en comprar(p, c) ig y
        // hacerlo privado
        this.ventas.add(new Venta(p, c, 
            this.chollos.get(this.chollos.indexOf(p)).getCurrStock() - 1));
    }
    
}
