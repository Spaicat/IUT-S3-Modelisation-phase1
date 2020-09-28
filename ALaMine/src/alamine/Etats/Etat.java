package alamine.Etats;

import alamine.Gimli;

/**
 * Classe abstraite des différents etats
 * @author Thibault
 */
public abstract class Etat {
    private Gimli gimli;
    private int uTime = 20; //Transition du temps, ici 20 minutes

    public Etat(Gimli gimli) {
        this.gimli = gimli;
    }

    public Gimli getIA() {
        return this.gimli;
    }

    public int getuTime() {
        return this.uTime;
    }

    /**
     * Fonction de transition de l'IA d'un etat à un autre
     * @return 
     */
    public abstract Etat transition();
}
