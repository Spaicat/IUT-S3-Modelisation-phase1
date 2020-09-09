package alaminesimulateur;

/**
 *
 * @author tt685736
 */
public abstract class Etat {
    private Gimli gimli;
    
    public Etat(Gimli gimli) {
        this.gimli = gimli;
    }
    
    public Gimli getIA() {
        return this.gimli;
    }
    
    public abstract Etat transition();
}
