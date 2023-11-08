/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio6;

import java.util.Scanner;

/**
 *
 * @author MIV
 */
class Conversacion {
    private Scanner file;
    private boolean isOver = false;

    public Conversacion(Scanner file) {
        this.file = file;
    }
    
    public synchronized void leerLinea() {
        if (file.hasNext()) {
            System.out.println(file.nextLine());
        } else {
            this.isOver = true;
        }
        
        file.notify();
        
        if (!this.isOver) try {
            file.wait();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public synchronized boolean isOver() {
        return this.isOver;
    }
    
}
