package alamine;

/**
 *
 * @author tt685736
 */
public class Gimli {
    //Alcoolémie en g/L
    private double alcool;
    //Temps en minutes
    private int temps;

    public double getAlcool() {
        return alcool;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public Gimli() {
        this.alcool = 0;
        this.temps = 0;
    }
    
    public void start() {
        boolean timeUnder24h = false;
        while (!timeUnder24h) {
            
        }
    }
}
