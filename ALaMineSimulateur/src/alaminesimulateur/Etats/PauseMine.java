package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author Thibault
 */
public class PauseMine extends Etat {

    public PauseMine(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1);
        getIA().boitBiere(1); //Boit 1 bière pendant la pause
    }

    @Override
    public Etat transition() {
        //S'il a trop bu
        if (getIA().getAlcool() > 8) {
            getIA().setprobaMineRepos(1);
            return new Lit(this.getIA());
        }
        else {
            getIA().setprobaMineMine(1);
            return new TravailMine(this.getIA());
        }
    }
}
