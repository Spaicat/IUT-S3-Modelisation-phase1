/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alamine.Etats;

import alamine.Gimli;

/**
 *
 * @author Thibault
 */
public class Mine extends Etat {    
    
    public Mine(Gimli gimli) {
        super(gimli);
        getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
    }

    @Override
    public Etat transition() {
        //Probabilité de 0.074
        if ((Math.random()*101) <= (7.4)) {
            return new Taverne(this.getIA());
        }
        else if ((Math.random()*100) <= (7.4)+(0.0001)) {
            return new Lit(this.getIA());
        }
        else {
            getIA().setTemps(getIA().getTemps() + getuTime()); //Ajout du temps
            return new Mine(this.getIA());
        }
    }
}
