/*
 * Classe modélisant une représentation graphique d'un graphe
 */
package bibliothequegraphe.Modèles;

import java.util.ArrayList;

/**
 *
 * @author simonetma
 */
public class GrapheVisuel {
    private Graphe graphe;                                                      //graphe réel
    private ArrayList<SommetVisuel> sommets;                                    //liste des sommets visuels
    private ArrayList<ArcVisuel> arcs;
    
    //constructeur
    public GrapheVisuel(Graphe g) {
        this.graphe = g;
        this.sommets = new ArrayList<>();
        this.arcs = new ArrayList<>();
    }
    
    //initialise le dessin du graphe
   public void initialisation() {
       //suppression du précedent dessin
       this.sommets.clear();            
       this.arcs.clear();
       
       //création des sommets
       for(int i=1;i<=this.graphe.getNbSommet();i++) {
           SommetVisuel nouveauSommet = new SommetVisuel(String.valueOf(i));
           this.sommets.add(nouveauSommet);
       }
       //création des arcs
       for(int i=1;i<=this.graphe.getNbSommet();i++) {
           for(int j=1;j<=this.graphe.getNbSommet();j++) {
               if(this.graphe.getMatrice(i, j)!=0) {
                   if(this.graphe.getOrientation() || i<j) {                    //si le graphe est orienté ou si on regarde une arrete pour la première fois
                       ArcVisuel nouvelArc = new ArcVisuel(String.valueOf(this.graphe.getMatrice(i, j)),this.sommets.get(i-1),this.sommets.get(j-1),this.graphe.getOrientation());
                       this.arcs.add(nouvelArc);
                   }
               }
           }
       }
   }
   
    //getteur des sommets et arcs
    public ArrayList<SommetVisuel> getSommets() {
        return this.sommets;
    }
    public ArrayList<ArcVisuel> getArcs() {
        return this.arcs;
    }
    
    //orientation
    public boolean isOrienté() {
        return this.graphe.getOrientation();
    }
   
   //affichage de la matrice du graphe réel
   public String matriceAdjacence() {
       return this.graphe.toString();
   }
}
