package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 * Etat Pause à la Mine
 * @author Thibault, Alexandre
 */
public class PauseMine extends Etat {

    public PauseMine(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1); //Diminution alcool -> !Travail
        getIA().boitBiere(1); //Boit 1 bière pendant la pause
    }

    @Override
    public Etat transition() {
        //S'il a trop bu, il va au lit (car boit 1 bière)
        if (getIA().getAlcool() > 8) {
            getIA().setprobaMineRepos(1);
            return new Lit(this.getIA());
        }
        //Sinon il retourne à la Mine
        else {
            getIA().setprobaMineMine(1);
            return new TravailMine(this.getIA());
        }
    }
}
