package alamine;

import alamine.Etats.*;

/**
 *
 * @author Thibault
 */
public class Gimli {
    //Temps en minutes
    private int temps;
    private Etat etatCourant;
    private double tempsLit;
    private double tempsMine;
    private double tempsTaverne;

    public int getTemps() {
        return temps;
    }

    public void ajoutTemps(int temps) {
        if (this.etatCourant instanceof Lit) {
            this.tempsLit += temps;
        }
        else if (this.etatCourant instanceof Mine) {
            this.tempsMine += temps;
        }
        else {
            this.tempsTaverne += temps;
        }
        this.temps += temps;
    }

    public Gimli() {
        this.temps = 0;
        this.etatCourant = new Mine(this);
    }

    public void start() {
        for (int i = 0;i<1000000;i++){ 
            etatCourant = etatCourant.transition();
        }
        double tempsMoyenneLit = (tempsLit / ((tempsLit+tempsMine+tempsTaverne)/1440));
        double tempsMoyenneMine = (tempsMine / ((tempsLit+tempsMine+tempsTaverne)/1440));
        double tempsMoyenneTaverne = (tempsTaverne / ((tempsLit+tempsMine+tempsTaverne)/1440));
        System.out.println("Activité de Gimli étudié sur " + (int)((tempsLit+tempsMine+tempsTaverne)/1440) + " jours");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneLit + " minutes (~" + (int)(tempsMoyenneLit/60) + "h " + (int)(tempsMoyenneLit%60) + "m " + (int)(((tempsMoyenneLit%60)*60)%60) + "s) au lit par jour");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneMine + " minutes (~" + (int)(tempsMoyenneMine/60) + "h " + (int)(tempsMoyenneMine%60) + "m " + (int)(((tempsMoyenneMine%60)*60)%60) + "s) à la mine par jour");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneTaverne + " minutes (~" + (int)(tempsMoyenneTaverne/60) + "h " + (int)(tempsMoyenneTaverne%60) + "m " + (int)(((tempsMoyenneTaverne%60)*60)%60) + "s) à la taverne par jour");
    }
}