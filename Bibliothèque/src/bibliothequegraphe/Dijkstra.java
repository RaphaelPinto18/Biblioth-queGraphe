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
    
    private ArrayList<Integer> sommets=null;
    private ArrayList<Boolean> mark=null;
    private ArrayList<Integer> distances=null;
    private ArrayList<Integer> antecedents=null;
    private Graphe graphe=null;
    
    public Dijkstra(Graphe g){
        this.sommets = new ArrayList();
        this.mark = new ArrayList();
        this.distances = new ArrayList();
        this.antecedents = new ArrayList();
        this.graphe = g;
    }
    
    public int infini(){
        int res = 0;
        for(int i = 1; i <= this.graphe.getNbSommet(); i++){
            for(int j = 1; j <= this.graphe.getNbSommet(); j++){
            res+= this.graphe.getMatrice(i, j);
            }
        }
        
        return res+1;
        
    }
    
    public void intitialisation() {
        
        for(int i=0;i<graphe.getNbSommet();i++) {
            
            this.sommets.add(i+1);
            this.mark.add(Boolean.FALSE);
            this.distances.add(this.infini());
            this.antecedents.add(-1);
            
        }
    }
    
    public void afficheTableaux(){
        for(int e : this.sommets){
            System.out.print(e + " ");
        }
        System.out.println("\n");
        for(boolean e : this.mark){
            System.out.print(e + " ");
        }
        System.out.println("\n");
        for(int e : this.distances){
            System.out.print(e + " ");
        }
        System.out.println("\n");
        for(int e : this.antecedents){
            System.out.print(e + " ");
        }
    }
    
}
