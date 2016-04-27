/*
 * Classe modélisant un graphe
 */
package bibliothequegraphe.Modèles;

import java.util.HashMap;

/**
 *
 * @author simonetma
 */
public class Graphe {
    private int nbSommet;
    private HashMap<Couple,Integer> matrice;
    private Boolean orienté;
    
    //constructeur
    public Graphe() {
        this.nbSommet = 0;
        this.matrice = new HashMap<>();
        this.orienté = false;
    }
    
    
    //Gestion du nombre de sommet
    public void setNbSommet(int n) {
        this.nbSommet = n;
    }
    
    public int getNbSommet() {
        return this.nbSommet;
    }
    
    //*************** gestion de la matrice d'adjacence ***********************
    //Modifie la valeur (i,j) de la matrice d'adjacence du graphe
    public void modifierMatrice(int i,int j,int valeur) {
        if(i<=0 || j<=0) {
            System.err.println("Erreur ! La matrice d'adjacence ne possède pas de coefficient ("+i+","+j+") !");
        }
        else if(i>this.nbSommet || j>this.nbSommet) {
            System.err.println("Erreur ! La matrice d'adjacence ne possède pas de coefficient ("+i+","+j+") !");
        }
        else
        {
            Couple c = new Couple(i,j);
            this.matrice.put(c, valeur);
        }
    }
    
    //renvoie la valeur du coefficient (i,j) de la matrice d'adjacence (0 par défaut)
    public int getMatrice(int i,int j) {
        if(i<=0 || j<=0) {
            System.err.println("Erreur ! La matrice d'adjacence ne possède pas de coefficient ("+i+","+j+") !");
        }
        else if(i>this.nbSommet || j>this.nbSommet) {
            System.err.println("Erreur ! La matrice d'adjacence ne possède pas de coefficient ("+i+","+j+") !");
        }
        else {
            Couple c = new Couple(i,j);
            if(this.matrice.containsKey(c)) {
                return this.matrice.get(c);
            }
        }
        return 0;
    }
    
    //oriente ou non le graphe (false de base)
    public void setOrientation(boolean B) {
        this.orienté = B;
    }
    
    public boolean getOrientation() {
        return this.orienté;
    }
    
    public String toString() {
        String ret = "<html><center>Matrice du graphe :<br><br>";
        for(int i=1;i<=this.nbSommet;i++) {
            for(int j=1;j<=this.nbSommet;j++) {
                Couple c = new Couple(i,j);
                if(this.matrice.containsKey(c)) {
                    ret += this.matrice.get(c);
                }
                else {
                    ret += "0";
                }
                if(j<this.nbSommet) {
                    ret+= " ";
                }
            }
            if(i<this.nbSommet) {
                ret+="<br>";
            }
        }
        ret += "</center></html>";
        return ret;
    }
}
