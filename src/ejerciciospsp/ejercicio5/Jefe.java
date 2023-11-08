/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio5;

/**
 *
 * @author MIV
 */
class Jefe extends Thread {

    private Oficina oficina;
    
    public Jefe(Oficina oficina) {
        this.oficina = oficina;
    }
    
    @Override
    public void run() {
        oficina.llegarJefe();
    }
    
}
