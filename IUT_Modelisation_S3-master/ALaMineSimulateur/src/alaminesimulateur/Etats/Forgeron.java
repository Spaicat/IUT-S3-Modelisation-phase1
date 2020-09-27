package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author Thibault
 */
public class Forgeron extends Etat {

    public Forgeron(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1);
    }

    @Override
    public Etat transition() {
        //Si les gardes ne le rattrapent pas (1 chance sur 3)
        if ((int)(Math.random()*3) == 0) {
            getIA().setProbaMineTaverne(1);
            return new Taverne(this.getIA());
        }
        else {
            getIA().setprobaMineMine(1);
            return new TravailMine(this.getIA());
        }
    }

}
