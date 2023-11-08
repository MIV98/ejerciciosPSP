/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio6;


/**
 *
 * @author MIV
 */
public class Persona extends Thread {
    
    private String id;
    private Conversacion conv;
    
    public Persona(String id, Conversacion conv) {
        this.id = id;
        this.conv = conv;
    }

    @Override
    public void run() {
        while (!conv.isOver()) {
            conv.leerLinea();
        }
    }
    
    
    
}
