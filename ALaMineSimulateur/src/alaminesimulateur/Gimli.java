package alaminesimulateur;

/**
 *
 * @author tt685736
 */
public class Gimli {
    //Alcoolémie en g/L
    private double alcool;
    //Temps en minutes
    private int temps;
    private Etat etatCourant;

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
        this.etatCourant = new TravailMine(this);
    }
    
    public void start() {
        while (temps < 3600) {
            /*String messageReponse = "";
            while(messageReponse.equals("")) {
                etatCourant = etatCourant.transition();
            }*/
            etatCourant = etatCourant.transition();
            System.out.println(etatCourant);
        }
    }
}
