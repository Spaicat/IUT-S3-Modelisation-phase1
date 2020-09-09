/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaminesimulateur;

/**
 *
 * @author tt685736
 */
public class TravailMine extends Etat {

    public TravailMine(Gimli gimli) {
        super(gimli);
        gimli.setTemps(gimli.getTemps() + 20);
    }

    @Override
    public Etat transition() {
        //Casse sa pioche
        if (Math.random()*(100-1) <= 15 + 8*this.getIA().getAlcool()) {
            return new Forgeron(this.getIA());
        }
        else {
            return new PauseMine(this.getIA());
        }
    }
    
}
