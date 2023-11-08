/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio7;

import java.util.Random;

/**
 *
 * @author MIV
 */
class Apuesta {
    private static final int MAX_GOLES = 4;
    private Empleado emp; // might not need this buuuut...
    private int golesDM2;
    private int golesPRF;
    private int cantidad;

    private Apuesta(Empleado emp, int golesDM2, int golesPRF, int cantidad) {
        this.emp = emp;
        this.golesDM2 = golesDM2;
        this.golesPRF = golesPRF;
        this.cantidad = cantidad;
    }
    
    public static Apuesta getRandomApuesta(Empleado emp) {
        Random rand = new Random();
        
        int dm2 = rand.nextInt(MAX_GOLES + 1);
        int prf = rand.nextInt(MAX_GOLES + 1);
        
        emp.getBote().increaseAmount(emp.getCurrAmount());
        
        return new Apuesta(emp, dm2, prf, emp.getCurrAmount());
    }

    public static Apuesta getResultado() {
        Random rand = new Random();
        
        int dm2 = rand.nextInt(MAX_GOLES + 1);
        int prf = rand.nextInt(MAX_GOLES + 1);
        
        return new Apuesta(null, dm2, prf, 0);
    }
    
    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public int getGolesDM2() {
        return golesDM2;
    }

    public void setGolesDM2(int golesDM2) {
        this.golesDM2 = golesDM2;
    }

    public int getGolesPRF() {
        return golesPRF;
    }

    public void setGolesPRF(int golesPRF) {
        this.golesPRF = golesPRF;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.golesDM2;
        hash = 23 * hash + this.golesPRF;
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
        final Apuesta other = (Apuesta) obj;
        if (this.golesDM2 != other.golesDM2) {
            return false;
        }
        return this.golesPRF == other.golesPRF;
    }

    @Override
    public String toString() {
        return golesDM2 + " - " + golesPRF;
    }
    
}
