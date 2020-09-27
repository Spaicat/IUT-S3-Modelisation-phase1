package alaminesimulateur.Etats;

import alaminesimulateur.Gimli;

/**
 *
 * @author Thibault
 */
public abstract class Etat {
    private Gimli gimli;
    private int uTime = 20; //Transition du temps, ici 20minutes

    public Etat(Gimli gimli) {
        this.gimli = gimli;
    }

    public Gimli getIA() {
        return this.gimli;
    }

    public int getuTime() {
        return this.uTime;
    }

    public abstract Etat transition();
}
