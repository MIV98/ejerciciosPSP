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
    
    public void leerLinea() {
        synchronized (file) {
            if (file.hasNext()) {
                try {
                    System.out.println(file.nextLine());
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            } else {
                this.isOver = true;
            }

            file.notify();

            try {
                file.wait();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public synchronized boolean isOver() {
        return this.isOver;
    }
    
}
