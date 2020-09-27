package alaminesimulateur;

/**
 *
 * @author Thibault
 */
public class ALaMineSimulateur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gimli gimli = new Gimli();
        gimli.start();
        /*int min = 100;
        int max = 0;
        for (int i = 0; i < 1000; i++) {
            int oui = (int)(Math.random()*3);
            System.out.println(oui);
            if (oui < min)
                min = oui;
            if (oui > max)
                max = oui;
        }
        System.out.println("Max=" + max + " | Min=" + min);*/
    }

}
