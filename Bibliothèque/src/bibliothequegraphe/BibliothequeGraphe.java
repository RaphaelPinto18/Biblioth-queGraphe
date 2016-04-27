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
    
    public static Graphe test(int n){
        Graphe g = new Graphe();
        g.setNbSommet(n);
        for(int i = 1; i <= g.getNbSommet(); i++){
            for(int j = 1; j <= g.getNbSommet(); j++){
                g.ajouterArc(i, j, 1);
            }
        }
        afficher(g); 
        return g;
         
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        
        //lance l'IHM
        fenetre = new Fenetre();
        
        Dijkstra d = new Dijkstra(test(4));
        System.out.println(d.infini());
        d.intitialisation();
        d.afficheTableaux();
        
                           //on l'affiche
        
    }
    
}
