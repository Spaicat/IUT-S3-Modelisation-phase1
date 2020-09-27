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
    }

    @Override
    public Etat transition() {
        //S'il se bat (5% + 15%*GrammeAlcool de chance)
        if ((int)(Math.random()*101) <= (5 + 15*this.getIA().getAlcool())) {
            //System.out.println(5 + 15*this.getIA().getAlcool());
            getIA().setprobaTaverneMine(1);
            return new TravailMine(this.getIA());
        }
        else {

            getIA().boitBiere((int)(Math.random()*7)); // nombre de bières que Gimli prend a la taverne
            //S'il a trop bu
            if (getIA().getAlcool() > 8) {
                getIA().setprobaTaverneRepos(1);                
                return new Lit(this.getIA());
            }                   
            else {
                getIA().setprobaTaverneTaverne(1);
                return new Taverne(this.getIA());
            }
        }
    }

}
