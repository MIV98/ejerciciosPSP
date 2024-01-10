
package ejercicio2;

/**
 *
 * @author Iván
 */
public class Venta {
    // Esta clase es innecesaria en teoría
    // Solo existe para hacerme la vida más fácil al mostrar el registro de ventas
    
    public Producto p;
    public Cliente c;
    public int stockRestante;

    public Venta(Producto p, Cliente c, int stockRestante) {
        this.p = p;
        this.c = c;
        this.stockRestante = stockRestante;
    }

    @Override
    public String toString() {
        return p + "-" + c + "-" + stockRestante;
    }
    
    
    
}
