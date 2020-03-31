/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clans;

/**
 *
 * @author humeau
 */
public class Clans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	Joueur joueur_1 = new Joueur("joueur 1");
        Joueur joueur_2 = new Joueur("joueur 2");
        Jeu jeu = new Jeu();
        jeu.run(joueur_1, joueur_2, true);
    }
    
}
