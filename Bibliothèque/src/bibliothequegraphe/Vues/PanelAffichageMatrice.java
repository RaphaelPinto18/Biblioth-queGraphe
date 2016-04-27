/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Vues;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author simonetma
 */
public class PanelAffichageMatrice extends JPanel {
    private Fenetre fenetre;
    private JLabel labelMatrice;
    
    public PanelAffichageMatrice(Fenetre _fenetre) {
        this.fenetre = _fenetre;
        
        //parametrage du panel
        this.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.black));
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        
        //gestion de la zone d'affichage de la matrice
        this.labelMatrice = new JLabel("Pas de graphe");
        this.add(this.labelMatrice);
        
    } 
    
    //fonction d'initialisation lors de la demande d'affichage d'un nouveau graphe
    public void initialisation() {
        this.labelMatrice.setText(fenetre.getGraphe().matriceAdjacence());
    }
    
}
