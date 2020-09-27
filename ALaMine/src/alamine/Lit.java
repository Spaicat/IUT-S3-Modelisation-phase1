/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alamine;

/**
 *
 * @author tt685736
 */
public class Lit extends Etat {
    public Lit(Gimli gimli) {
        super(gimli);
    }

    @Override
    public Etat transition() {
        return new Mine(this.getIA());
    }
}
