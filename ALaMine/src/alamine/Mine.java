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
public class Mine extends Etat {
    
    private Etat stt;
    private boolean pick;
    
    
    public Mine(Gimli gimli) {
        super(gimli);
        this.pick=false;                                            //pioche pas cassée
        getGimli().setAlcool(getGimli().getAlcool()-0.15);          //diminution alcool -> travail
        if(getGimli().getAlcool()<0){                               // test si alcool négatif -> remmetre 0
            getGimli().setAlcool(0.00);      
        }
        getGimli().setTemps(getGimli().getTemps()+20);              //ajout temps
    }

    @Override
    public Etat transition() {
        
    }
}
