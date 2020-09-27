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
public class ALaMine {

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
