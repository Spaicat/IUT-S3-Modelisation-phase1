package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author tt685736
 */
public class Taverne extends Etat {

    public Taverne(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1);
        getIA().boitBiere(3);
    }

    @Override
    public Etat transition() {
        //S'il a trop bu
        if (getIA().getAlcool() > 8) {
            return new Lit(this.getIA());
        }
        //S'il se bat (5% + 15%*GrammeAlcool de chance)
        else if ((int)(Math.random()*100+1) <= (5 + 15*this.getIA().getAlcool())) {
            return new TravailMine(this.getIA());
        }
        else {
            return new Taverne(this.getIA());
        }
    }

}
