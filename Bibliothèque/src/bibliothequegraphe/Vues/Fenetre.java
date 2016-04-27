/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Vues;

import bibliothequegraphe.Modèles.Graphe;
import bibliothequegraphe.Modèles.GrapheVisuel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author simonetma
 */
public class Fenetre extends JFrame {
    //modèle
    private GrapheVisuel graphe;
    //structure
    private PanelAffichageGraphe panelAffichageGraphe;
    private PanelAffichageMatrice panelAffichageMatrice;
    
    //constructeur
    public Fenetre() {
        super("Graphes et Langages");
        this.setSize(new Dimension(1400,1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        
        //gestion du contenu
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        
        //panel d'affichage de graphe
        this.panelAffichageGraphe = new PanelAffichageGraphe(this);
        c.weightx = 0.71;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.getContentPane().add(this.panelAffichageGraphe,c);
        
        //panel d'affichage de la matrice
        this.panelAffichageMatrice = new PanelAffichageMatrice(this);
        c.weightx = 0.29;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.getContentPane().add(this.panelAffichageMatrice,c);
               
        //affichage
        this.setVisible(true);
    }
    
    //gestion du graphe
    public GrapheVisuel getGraphe() {
        return this.graphe;
    } 
    
    public void setGraphe(GrapheVisuel g) {
        this.graphe = g;
        this.initialisation();

    }
    
    //fonction d'initialisation lors de la demande d'affichage d'un nouveau graphe
    public void initialisation() {
        this.panelAffichageGraphe.initialisation();
        this.panelAffichageMatrice.initialisation();
    }
}

