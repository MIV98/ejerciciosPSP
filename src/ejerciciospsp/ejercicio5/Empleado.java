/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIV
 */
public class Empleado extends Thread {

    private String name;
    private Oficina oficina;

    public Empleado(String name, Oficina oficina) {
        this.name = name;
        this.oficina = oficina;
    }
    
    @Override
    public void run() {
        this.oficina.llegarEmpleado(this);
    }

    // can't be called getName() apparently -.-"
    public String getNombre() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "name=" + name + '}';
    }
    
}
