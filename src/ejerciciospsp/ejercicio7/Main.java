
package ejerciciospsp.ejercicio7;

import java.util.ArrayList;

/**
 *
 * @author MIV
 */
public class Main {
    public static final int NUM_EMPLEADOS = 10;
    
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Bote bote = new Bote();
        
        for (int i = 0; i < NUM_EMPLEADOS; i++) {
            Empleado emp = new Empleado(i, bote);
            empleados.add(emp);
            emp.start();
        }
        
        Apuesta resultado = Apuesta.getResultado();
        
        // TODO wait for now till every thread is finished
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        
        // Mostrar resultado partido
        System.out.println(resultado);
        
        // Mostrar total € ingresados (n apuestas)
        System.out.println("Total bote: " + bote.getAmount() + "€ (" + bote.getNumApuestas() + " apuestas)");
        System.out.println(bote.getNumApuestas() == (NUM_EMPLEADOS * Empleado.NUM_APUESTAS));
        
        // Mostrar empleados que ganaron la porra
        System.out.println("Ganadores:");
        for (Empleado emp : empleados) {
            if (emp.getApuestas().contains(resultado)) {
                System.out.println("Empleado " + emp.getIdEmp() + " (Aposto " 
                        + emp.getApuestas().get(emp.getApuestas().indexOf(resultado)).getCantidad()
                        + "€)");
            }
        }
        
        // Mostrar cuanto le toca a cada uno
        // TODO improve this
        System.out.println("Ganancias:");
        int total = 0;
        for (Empleado emp : empleados) {
            if (emp.getApuestas().contains(resultado)) {
                total += emp.getApuestas().get(emp.getApuestas().indexOf(resultado)).getCantidad();
            }
        }
        
        for (Empleado emp : empleados) {
            if (emp.getApuestas().contains(resultado)) {
                double porcentaje = ((emp.getApuestas().get(emp.getApuestas().indexOf(resultado)).getCantidad() * 100) / total);
                
                System.out.println("Empleado " + emp.getIdEmp() + " gana " 
                        + (porcentaje * bote.getAmount())/100
                        + "€)");
            }
        }
    }
    
}
