package alamine;

/**
 *
 * @author tt685736
 */
public abstract class Etat {
    private Gimli gimli;
    
    public Etat(Gimli gimli) {
        this.gimli = gimli;
    }
    
    public abstract Etat transition();
}
