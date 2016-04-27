/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliothequegraphe;

import bibliothequegraphe.Modèles.Graphe;
import java.util.ArrayList;

/**
 *
 * @author bp818669
 */
public class Dijkstra {
    
    private ArrayList<Integer> sommets;
    private ArrayList<Boolean> mark;
    private ArrayList<Integer> distances;
    private ArrayList<Integer> antecedents;
    private Graphe graphe;
    
    public Dijkstra(Graphe g){
        this.sommets = new ArrayList();
        this.mark = new ArrayList();
        this.distances = new ArrayList();
        this.antecedents = new ArrayList();
        this.graphe = g;
    }
    
}
