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
        /*int min = 100;
        int max = 0;
        int calcul1 = 0;
        int calcul2 = 0;
        int calcul3 = 0;
        for (int i = 0; i < 100000; i++) {
            double oui = (Math.random()*100);
            if(oui <= 20)
                calcul1+=1;
            else if(oui <= 20+30)
                calcul2+=1;
            else
                calcul3+=1;
        }
        System.out.println(calcul1);
        System.out.println(calcul2);
        System.out.println(calcul3);*/
        //System.out.println("Max=" + max + " | Min=" + min);
    }
}
