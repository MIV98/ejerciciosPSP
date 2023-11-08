/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospsp.ejercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author MIV
 */
public class Main {
    private static final String FILE_PATH = "pescadores.txt";
    
    public static void main(String[] args) {
        Scanner file = null;
        
        try {
            file = new Scanner(new File(FILE_PATH));
            Conversacion conv = new Conversacion(file);
            Persona p1 = new Persona("P1", conv);
            Persona p2 = new Persona("P2", conv);
            
            p1.start();
            p2.start();
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (file != null) file.close();
        }
    }
}
