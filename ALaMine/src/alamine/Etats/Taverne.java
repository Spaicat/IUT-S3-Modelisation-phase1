package alamine.Etats;

import alamine.Gimli;

/**
 *
 * @author Thibault
 */
public class Taverne extends Etat {

    public Taverne(Gimli gimli) {
        super(gimli);
        getIA().ajoutTemps(getuTime()); //Ajout du temps
    }

    @Override
    public Etat transition() {
        //On "pioche" un nombre entre 0 et 100
        double probChoisie = Math.random()*100;
        //Probabilité de 0.71407 qu'il aille à la Mine depuis la Taverne
        if (probChoisie <= (71.407)) {
            return new Mine(this.getIA());
        }
        //Probabilité de 0.00112 qu'il aille au Lit depuis la Taverne
        else if (probChoisie <= (71.407)+(0.112)) {
            return new Lit(this.getIA());
        }
        //Probabilité de 0.28481 qu'il aille à la Taverne depuis la Taverne
        else {
            return new Taverne(this.getIA());
        }
    }

}