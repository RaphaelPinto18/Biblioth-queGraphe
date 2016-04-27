/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe;

import bibliothequegraphe.Modèles.Graphe;
import bibliothequegraphe.Modèles.GrapheVisuel;
import bibliothequegraphe.Vues.Fenetre;

/**
 *
 * @author simonetma
 */
public class BibliothequeGraphe {

    private static Fenetre fenetre;
    
    public static void afficher(Graphe g) {
       //création du GrapheVisuel
       GrapheVisuel grapheVisuel = new GrapheVisuel(g);
       grapheVisuel.initialisation();
       //affichage du grapheVisuel dans la fenetre
       fenetre.setGraphe(grapheVisuel);
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        
        //lance l'IHM
        fenetre = new Fenetre();
        
        //Un exemple de définition de graphe
        Graphe monGraphe = new Graphe();        //on construit le graphe
        monGraphe.setNbSommet(7);               //on fixe le nombre sommets
        monGraphe.setOrientation(true);         //on indique qu'il est orienté
        
        monGraphe.modifierMatrice(1, 2, 1);     //on définit la matrice d'adjacence
        monGraphe.modifierMatrice(2, 3, 1);
        monGraphe.modifierMatrice(3, 2, 1);
        monGraphe.modifierMatrice(3, 5, 1);
        monGraphe.modifierMatrice(4, 5, 1);
        monGraphe.modifierMatrice(6, 2, 2);
        monGraphe.modifierMatrice(7, 5, 1);
        monGraphe.modifierMatrice(3, 6, 1);
        monGraphe.modifierMatrice(3, 7, 3);
        monGraphe.modifierMatrice(7, 6, 1);
        monGraphe.modifierMatrice(7, 4, 1);
        monGraphe.modifierMatrice(1, 5, 1);
        monGraphe.modifierMatrice(5, 1, 1);
        
        afficher(monGraphe);                    //on l'affiche
        
    }
    
}
