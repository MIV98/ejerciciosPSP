
package ejerciciospsp.ejercicio7;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MIV
 */
public class Empleado extends Thread {
    public static final int NUM_APUESTAS = 5;
    public static final int MIN_WAIT = 100;
    public static final int MAX_WAIT = 300;
    
    private int id;
    private ArrayList<Apuesta> apuestas;
    private Bote bote;
    private int currAmount;

    public Empleado(int id, Bote bote) {
        this.id = id;
        this.apuestas = new ArrayList<>();
        this.bote = bote;
        this.currAmount = 1;
    }

    @Override
    public void run() {
        Random rand = new Random();
        
        for (int i = 0; i < NUM_APUESTAS; i++) {
            try {
                this.bote.getAmount();
                Thread.sleep(rand.nextInt(MIN_WAIT, MAX_WAIT + 1));
                this.apuestas.add(Apuesta.getRandomApuesta(this));
                this.currAmount++;
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public int getIdEmp() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Bote getBote() {
        return bote;
    }

    public void setBote(Bote bote) {
        this.bote = bote;
    }

    public int getCurrAmount() {
        return currAmount;
    }

    public void setCurrAmount(int currAmount) {
        this.currAmount = currAmount;
    }
    
    
    
}
