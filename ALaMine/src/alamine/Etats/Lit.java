package alamine.Etats;

import alamine.Gimli;

/**
 *
 * @author Thibault
 */
public class Lit extends Etat {

    public Lit(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + 3*getuTime()); //Ajout du temps (1h)
        getIA().changeAlcool(-getIA().getAlcool());
    }

    @Override
    public Etat transition() {
        return new Mine(this.getIA());
    }
}