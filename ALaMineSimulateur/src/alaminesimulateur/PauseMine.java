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
public class PauseMine extends Etat {

    public PauseMine(Gimli gimli) {
        super(gimli);
        gimli.setTemps(gimli.getTemps() + 20);
    }

    @Override
    public Etat transition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
