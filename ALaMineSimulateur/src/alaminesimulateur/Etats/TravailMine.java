package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 * Etat Travail à la Mine
 * @author Thibault, Alexandre
 */
public class TravailMine extends Etat {
    public TravailMine(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.15); //Diminution alcool -> Travail
    }

    @Override
    public Etat transition() {
        //S'il casse sa pioche (15% + 8%*GrammeAlcool de chance)
        if ((int)(Math.random()*101) <= (15 + 8*this.getIA().getAlcool())) {
            return new Forgeron(this.getIA());
        }
        //Sinon il retourne à la mine
        else {
            getIA().setprobaMineMine(1);
            return new PauseMine(this.getIA());
        }
    }

}
