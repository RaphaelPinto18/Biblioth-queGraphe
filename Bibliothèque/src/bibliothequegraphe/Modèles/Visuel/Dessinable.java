/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Modèles.Visuel;

/**
 *
 * @author simonetma
 */
public abstract class Dessinable {
    
    private boolean visible;                                                    //gère la visibilité de l'objet
    
    
    public Dessinable() {
        this.visible = false;
    }
    //Gestion de la visibilité
    public void setVisible(boolean b) {
        this.visible = b;
    }
    
    public boolean isVisible() {
        return this.visible;
    }
}
