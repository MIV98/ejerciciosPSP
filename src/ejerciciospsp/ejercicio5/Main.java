/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio5;

import java.util.Random;

/**
 *
 * @author MIV
 */
public class Main {
    
    public static final int MAX_TIEMPO_ESPERA = 50;
    public static final int NUM_EMPLEADOS = 100;
    
    public static void main(String[] args) {
        Random rand = new Random();
        Oficina oficina = new Oficina();
        Jefe jefe = null;

        int espera = rand.nextInt(MAX_TIEMPO_ESPERA + 1);
        
        for (int numEmpl = 0; numEmpl < NUM_EMPLEADOS; numEmpl++) {
            if (numEmpl > espera && jefe == null) {
                jefe = new Jefe(oficina);
                jefe.start();
            } else {
                Empleado emp = new Empleado("Empleado " + numEmpl, oficina);
                emp.start();
            }
        }
    }
}
