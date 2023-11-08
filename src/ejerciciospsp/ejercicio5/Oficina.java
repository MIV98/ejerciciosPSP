/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio5;

import java.util.ArrayList;

/**
 *
 * @author MIV
 */
public class Oficina {
    
    private boolean llegoJefe;

    public Oficina() {}

    
    public synchronized boolean llegoJefe() {
        return this.llegoJefe;
    }
    
    public synchronized void setLlegoJefe(boolean llegoJefe) {
        this.llegoJefe = llegoJefe;
    }
    
    public synchronized void llegarJefe() {
        System.out.println("¡EL JEFE HA LLEGADO!");
        this.setLlegoJefe(true);
        notifyAll();
    }
    
    public synchronized void llegarEmpleado(Empleado empl) {
        if (!this.llegoJefe()) {
            try {
                System.out.println(empl.getNombre() + " ha llegado. ZZZZZZ");
                wait();
                System.out.println("(" + empl.getNombre() + " desperezándose) Buenos días jefe, aquí estoy trabajando.");
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            System.out.println(empl.getNombre() + " ha llegado. ¡Hola jefe! Me pongo a trabajar...");
        }
    }
    
}
