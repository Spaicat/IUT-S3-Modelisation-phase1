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
    //Poids de Gimli en kg
    private double poids;
    //Temps en minutes
    private int temps;
    private Etat etatCourant;
    private float probaMineTaverne; 
    private float probaMineRepos;
    private float probaMineMine;
    private float probaTaverneMine; 
    private float probaTaverneTaverne;
    private float probaTaverneRepos;
    private float probaReposRepos;
    private float probaReposMine;
    private float ActionMine;
    private float ActionTaverne;
    private float ActionRepos;

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
        this.poids = 102 + (6*this.alcool)/1000;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
    
    public void setProbaMineTaverne( float probaT){
        this.probaMineTaverne += probaT; 
        this.ActionMine += probaT;
        
    }
    public void setprobaMineRepos( float probaT){
        this.probaMineRepos += probaT; 
        this.ActionMine += probaT;
    }
    public void setprobaMineMine( float probaT){
        this.probaMineMine += probaT;
        this.ActionMine += probaT;
    }
    public void setprobaTaverneMine( float probaT){
        this.probaTaverneMine += probaT; 
        this.ActionTaverne += probaT;
    }
    public void setprobaTaverneTaverne( float probaT){
        this.probaTaverneTaverne += probaT; 
        this.ActionTaverne += probaT;
    }
    public void setprobaTaverneRepos( float probaT){
        this.probaTaverneRepos += probaT; 
        this.ActionTaverne += probaT;
    }
    public void setprobaReposRepos( float probaT){
        this.probaReposRepos += probaT; 
        this.ActionRepos += probaT;
    }
    public void setprobaReposMine( float probaT){
        this.probaReposMine += probaT; 
        this.ActionRepos += probaT;
    }    
    

    public Gimli() {
        this.alcool = 0;
        this.poids = 102;
        this.temps = 0;
        this.etatCourant = new TravailMine(this);
        this.ActionMine = 1;
        this.ActionRepos = 1;
        this.ActionTaverne = 1;
    }

    public void start() {
        //while (temps < 1440*366) {
        for (int i = 0;i<1000000;i++){ 
            /*String messageReponse = "";
            while(messageReponse.equals("")) {
                etatCourant = etatCourant.transition();
            }*/
            //System.out.println(etatCourant.getClass().getSimpleName() + " | Alcoolémie : " + alcool);
            etatCourant = etatCourant.transition();
        }
        //System.out.println(etatCourant.getClass().getSimpleName() + " | " + alcool);
        System.out.println("La probabilité que Gimli aille a la taverne depuis la mine est de "+ this.probaMineTaverne / this.ActionMine);
        System.out.println("La probabilité que Gimli aille au repos depuis la mine est de "+ this.probaMineRepos / this.ActionMine);
        System.out.println("La probabilité que Gimli aille a la mine depuis la mine est de "+ this.probaMineMine / this.ActionMine);
        System.out.println("La probabilité que Gimli aille a la mine depuis la taverne est de "+ this.probaTaverneMine / this.ActionTaverne);
        System.out.println("La probabilité que Gimli aille au repos depuis la taverne est de "+ this.probaTaverneRepos / this.ActionTaverne);
        System.out.println("La probabilité que Gimli aille a la taverne depuis la taverne est de "+ this.probaTaverneTaverne / this.ActionTaverne);
        System.out.println("La probabilité que Gimli aille au repos depuis le repos est de "+ this.probaReposRepos / this.ActionRepos);
        System.out.println("La probabilité que Gimli aille a la mine depuis le repos est de "+ this.probaReposMine / this.ActionRepos);
        System.out.println("proba general : "+(this.probaMineTaverne+this.probaMineRepos+this.probaMineMine+this.probaTaverneMine+this.probaTaverneTaverne+ this.probaTaverneRepos+this.probaReposRepos+this.probaReposMine ) / (this.ActionMine+this.ActionRepos+this.ActionTaverne));
        System.out.println("proba qu'il parte de la taverne : "+(this.probaTaverneMine+this.probaTaverneRepos+this.probaTaverneTaverne)/this.ActionTaverne);
        System.out.println("proba qu'il parte du repos : "+(this.probaReposMine+this.probaReposRepos)/this.ActionRepos);
        System.out.println("proba qu'il parte de la mine : "+(this.probaMineMine+this.probaMineRepos+this.probaMineTaverne)/this.ActionMine);
    
    }

    /**
     * Gimli boit une bière
     * @param nbBiere nombre de bière qu'il boit
     */
    public void boitBiere(int nbBiere) {
        this.alcool += ((500 * 0.07 * 0.8)/(0.7 * poids)*nbBiere); // Calcul du nombre de gramme dans le sang injecter a chaque bière naine :
                                                                 // (Volume de la bière(ml) * degré d'alcool * 0.8)/ (coef diffusion (0.7 pour gimli) * le poids de Gimli (102kg)) 
    }
}
