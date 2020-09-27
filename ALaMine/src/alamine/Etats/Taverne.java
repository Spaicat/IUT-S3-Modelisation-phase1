package alamine.Etats;

import alamine.Gimli;

/**
 *
 * @author Thibault
 */
public class Taverne extends Etat {

    public Taverne(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1);
    }

    @Override
    public Etat transition() {
        //S'il se bat (5% + 15%*GrammeAlcool de chance)
        if ((int)(Math.random()*100) <= (5 + 15*this.getIA().getAlcool())) {
            return new TravailMine(this.getIA());
        }
        else {
            getIA().boitBiere((int)(Math.random()*7)); // nombre de bières que Gimli prnd a la taverne
            //S'il a trop bu
            if (getIA().getAlcool() > 8) {
                return new Lit(this.getIA());
            }
            else {
                return new Taverne(this.getIA());
            }
        }
    }

}