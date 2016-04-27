/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Modèles;

import bibliothequegraphe.Modèles.Visuel.Dessinable;
import java.awt.Point;

/**
 *
 * @author simonetma
 */
public class SommetVisuel extends Dessinable {
    
    public String nom;
    public Couple Center;
    
    //constructeur
    public SommetVisuel(String _nom) {
        //construction du dessinable
        super(); 
        //initialisation du sommet
        this.nom = _nom;
        this.Center = new Couple(0,0);
    }
    
    
    public String getNom() {
        return this.nom;
    }
    
    public void setCenter(Couple c) {
        this.Center = c;
    }
    
    public Couple getCenter() {
        return this.Center;
    }

}
