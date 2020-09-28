package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 * Etat Lit
 * @author Thibault
 */
public class Lit extends Etat {

    public Lit(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + 3*getuTime()); //Ajout du temps (1h)
        getIA().setprobaReposRepos(3);
        getIA().changeAlcool(-getIA().getAlcool()); //On remet le taux d'alcool à 0
    }

    @Override
    public Etat transition() {
        //Il va automatiquement à la Mine après un repos
        getIA().setprobaReposMine(1);
        return new TravailMine(this.getIA());
    }
}
