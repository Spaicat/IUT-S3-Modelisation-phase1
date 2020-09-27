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
        getIA().ajoutTemps(getuTime()); //Ajout du temps
    }

    @Override
    public Etat transition() {
        //On "pioche" un nombre entre 0 et 100
        double probChoisie = Math.random()*100;
        //Probabilité de 0.10921 qu'il aille à la Taverne depuis la Mine
        if (probChoisie <= (10.921)) {
            return new Taverne(this.getIA());
        }
        //Probabilité de 0.00002 qu'il aille au Lit depuis la Mine
        else if (probChoisie <= (10.921)+(0.002)) {
            return new Lit(this.getIA());
        }
        //Probabilité de 0.89077 qu'il aille à la Mine depuis la Mine
        else {
            getIA().ajoutTemps(getuTime()); //Ajout du temps (pour simuler la pause)
            return new Mine(this.getIA());
        }
    }
}
