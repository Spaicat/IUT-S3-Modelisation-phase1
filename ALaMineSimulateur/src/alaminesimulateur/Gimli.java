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
    private float probaT; 
    private float nombreAction;

    public double getAlcool() {
        return alcool;
    }

    /**
     * Change le taux d'alcool
     * @param alcool Alcool à ajouter (ou soustraire)
     */
    public void changeAlcool(double alcool) {
        this.alcool =this.alcool + alcool; //Erreur de précision
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
    
    public void setProbaT( float probaT){
        this.probaT = probaT; 
    }
    
    public float getProbaT(){
        return probaT;
    }

    public Gimli() {
        this.alcool = 0;
        this.temps = 0;
        this.etatCourant = new TravailMine(this);
        this.nombreAction = 1;
    }

    public void start() {
        //while (temps < 1440*366) {
        for (int i = 0;i<10000;i++){ 
            /*String messageReponse = "";
            while(messageReponse.equals("")) {
                etatCourant = etatCourant.transition();
            }*/
            System.out.println(etatCourant.getClass().getSimpleName() + " | " + alcool);
            etatCourant = etatCourant.transition();
            this.nombreAction += 1;
        }
        //System.out.println(etatCourant.getClass().getSimpleName() + " | " + alcool);
        System.out.println("La probabilité que Gimli aille a la taverne est de "+this.probaT / this.nombreAction);
    }

    /**
     * Gimli boit une bière
     * @param nbBiere nombre de bière qu'il boit
     */
    public void boitBiere(int nbBiere) {
        this.alcool += ((500 * 0.07 * 0.8)/(0.7 * 102)*nbBiere); // Calcul du nombre de gramme dans le sang injecter a chaque bière naine :
                                                                 // (Volume de la bière(ml) * degré d'alcool * 0.8)/ (coef diffusion (0.7 pour gimli) * le poids de Gimli (102kg))  
    }
    
   
}
