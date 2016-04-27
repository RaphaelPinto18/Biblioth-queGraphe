/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Vues;

import bibliothequegraphe.Controleurs.ControleurPanelSommet;
import bibliothequegraphe.Modèles.Couple;
import bibliothequegraphe.Modèles.SommetVisuel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author simonetma
 */
public class PanelSommet extends JPanel {
    private PanelAffichageGraphe PanelParent;
    private JLabel labelNom;
    private Color couleur;
    private SommetVisuel sommetVisuel;
    
    public PanelSommet(PanelAffichageGraphe parent, SommetVisuel s) {
        //initialisation du panel
        this.sommetVisuel = s;
        this.couleur = Color.LIGHT_GRAY;
        this.PanelParent = parent;
        this.addMouseListener(new ControleurPanelSommet(this));
        
        //gestion du label du sommet
        this.setLayout(new BorderLayout());
        this.labelNom = new JLabel(this.sommetVisuel.getNom());
        this.labelNom.setFont(new Font(this.labelNom.getFont().getName(),this.labelNom.getFont().getStyle(),20));
        this.labelNom.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.labelNom,BorderLayout.CENTER);
        
    }
    
    @Override
    public void paintComponent( Graphics g ){
        //antialiasing
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
        //dessin du sommet
        g.setColor(this.couleur);
        g.fillOval(0, 0, PanelParent.getTailleSommet(), PanelParent.getTailleSommet());
    }
    
    //visibilité du sommet
    public boolean SommetVisible() {
        return this.sommetVisuel.isVisible();
    }
    
    public void setSommetVisible(boolean b) {
        this.sommetVisuel.setVisible(b);
    }
    
    public void setCenter(Point p) {
        this.sommetVisuel.setCenter(new Couple(p));
    }
    
    public Point getCenter() {
        return this.sommetVisuel.getCenter().toPoint();
    }
    
    //gestion de la selection
    public void select() {
        this.PanelParent.selectSommet(this);
    }
    
    //changement de couleur
    public void changeCouleur() {
        //change sa couleur
        if(this.couleur == Color.LIGHT_GRAY) {
            this.couleur = Color.RED;
        }
        else {
            this.couleur = Color.LIGHT_GRAY;
        }
        
    }
}
