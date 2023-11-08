
package ejerciciospsp.ejercicio7;

/**
 *
 * @author MIV
 */
class Bote {
    private int amount;
    private int numApuestas;
    
    public Bote() {
        this.amount = 0;
        this.numApuestas = 0;
    }
    
    public synchronized void increaseAmount(int add) {
        this.amount += add;
        this.numApuestas++;
    }

    public synchronized int getAmount() {
        return amount;
    }

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNumApuestas() {
        return numApuestas;
    }

    public void setNumApuestas(int numApuestas) {
        this.numApuestas = numApuestas;
    }
    
}
