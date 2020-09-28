package alamine.Etats;

import alamine.Gimli;

/**
 * Etat Lit
 * @author Thibault
 */
public class Lit extends Etat {

    public Lit(Gimli gimli) {
        super(gimli);
        getIA().ajoutTemps(getuTime()); //Ajout du temps --> pas 1h car pris en compte dans les probas
    }

    @Override
    public Etat transition() {
        //On "pioche" un nombre entre 0 et 100
        double probChoisie = Math.random()*100;
        //Probabilité de 0.25 qu'il aille à la Mine depuis le Lit
        if (probChoisie <= (25)) {
            return new Mine(this.getIA());
        }
        //Probabilité de 0.75 qu'il aille au Lit depuis le Lit
        else {
            return new Lit(this.getIA());
        }
        //Probabilité de 0 qu'il aille à la Taverne depuis le Lit
    }
}
