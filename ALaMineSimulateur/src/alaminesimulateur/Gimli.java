package alaminesimulateur;

import alaminesimulateur.Etats.Etat;
import alaminesimulateur.Etats.TravailMine;

/**
 *
 * @author Thibault
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

    /**
     * Change le taux d'alcool
     * @param alcool Alcool à ajouter (ou soustraire)
     */
    public void changeAlcool(double alcool) {
        this.alcool = this.alcool + alcool; //Erreur de précision
        if(this.alcool < 0){ //Si alcool négatif -> remettre à 0
            this.alcool = 0;
        }
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
            System.out.println(etatCourant.getClass().getSimpleName() + " | " + alcool);
            etatCourant = etatCourant.transition();
        }
        System.out.println(etatCourant.getClass().getSimpleName() + " | " + alcool);
    }

    /**
     * Gimli boit une bière
     * @param nbBiere nombre de bière qu'il boit
     */
    public void boitBiere(int nbBiere) {
        this.alcool += (0.25*nbBiere);
    }
}
