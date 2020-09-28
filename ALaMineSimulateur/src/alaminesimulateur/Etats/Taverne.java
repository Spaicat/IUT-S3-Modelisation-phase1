package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author Grégoire
 */
public class Taverne extends Etat {

    public Taverne(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
        getIA().changeAlcool(-0.1); //Diminution alcool -> !Travail
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
            getIA().boitBiere((int)(Math.random()*7)); //Nombre de bières que Gimli prend à la taverne (En moyenne 3)
            //S'il a trop bu, il va au lit
            if (getIA().getAlcool() > 8) {
                getIA().setprobaTaverneRepos(1);                
                return new Lit(this.getIA());
            }
            //Sinon il recommande (réitère l'état Taverne)
            else {
                getIA().setprobaTaverneTaverne(1);
                return new Taverne(this.getIA());
            }
        }
    }

}
