
package ejercicio2;

import java.util.Objects;

/**
 *
 * @author Iván
 */
public class Producto {
    public static final int STOCK = 10;
    public int currStock;
    public String name;
    
    public Producto(String name) {
        this.name = name;
        this.currStock = STOCK;
    }
    
    public synchronized void comprar() {
        if (this.hasStock()) {
            this.currStock--;
        }
    }
    
    public synchronized boolean hasStock() {
        return this.currStock > 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.name, other.name);
    }

    public int getCurrStock() {
        return currStock;
    }

    public void setCurrStock(int currStock) {
        this.currStock = currStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
