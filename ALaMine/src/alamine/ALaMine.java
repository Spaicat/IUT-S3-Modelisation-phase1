/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alamine;

/**
 * Classe du main
 * @author Thibault
 */
public class ALaMine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //On crée une nouvelle IA (Gimli)
        Gimli gimli = new Gimli();
        //On lance l'IA
        gimli.start();
    }
}
