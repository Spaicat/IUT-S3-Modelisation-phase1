package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author Thibault
 */
public class Lit extends Etat {

    public Lit(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + 3*getuTime()); //Ajout du temps (1h)
        getIA().setprobaReposRepos(3);
        getIA().changeAlcool(-getIA().getAlcool());
    }

    @Override
    public Etat transition() {
        getIA().setprobaReposMine(1);
        return new TravailMine(this.getIA());
    }
}
