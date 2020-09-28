package alamine;

import alamine.Etats.*;

/**
 * Classe de l'IA (Gimli)
 * @author Thibault
 */
public class Gimli {
    //Temps total en minutes
    private int temps;
    //Etat courant de Gimli
    private Etat etatCourant;
    //Temps que Gimli passe au lit (en minutes)
    private double tempsLit;
    //Temps que Gimli passe à la mine (en minutes)
    private double tempsMine;
    //Temps que Gimli passe à la taverne (en minutes)
    private double tempsTaverne;

    public int getTemps() {
        return temps;
    }

    /**
     * Fonction pour ajouter du temps (fais passer le temps)
     * @param temps nombre de minutes à ajouter au temps actuel
     */
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

    /**
     * Fonction pour démarrer l'IA
     */
    public void start() {
        //On fait un certain nombre d'actions (i est le nombre de transition faites par Gimli)
        for (int i = 0;i<100000;i++){ 
            etatCourant = etatCourant.transition();
        }
        //On affiche le temps moyen que passe Gimli pour chaque "activité" (états)
        double tempsMoyenneLit = (tempsLit / (temps/1440));
        double tempsMoyenneMine = (tempsMine / (temps/1440));
        double tempsMoyenneTaverne = (tempsTaverne / (temps/1440));
        System.out.println("Activité de Gimli étudié sur ~" + (int)(temps/1440) + " jours");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneLit + " minutes (~" + (int)(tempsMoyenneLit/60) + "h " + (int)(tempsMoyenneLit%60) + "m " + (int)(((tempsMoyenneLit%60)*60)%60) + "s) au lit par jour");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneMine + " minutes (~" + (int)(tempsMoyenneMine/60) + "h " + (int)(tempsMoyenneMine%60) + "m " + (int)(((tempsMoyenneMine%60)*60)%60) + "s) à la mine par jour");
        System.out.println("Gimli passe en moyenne " + tempsMoyenneTaverne + " minutes (~" + (int)(tempsMoyenneTaverne/60) + "h " + (int)(tempsMoyenneTaverne%60) + "m " + (int)(((tempsMoyenneTaverne%60)*60)%60) + "s) à la taverne par jour");
    }
}