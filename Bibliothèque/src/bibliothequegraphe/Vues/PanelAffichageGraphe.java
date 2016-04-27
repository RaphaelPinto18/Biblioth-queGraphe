/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothequegraphe.Vues;

import bibliothequegraphe.Controleurs.ControleurPanelGraphe;
import bibliothequegraphe.Modèles.ArcVisuel;
import bibliothequegraphe.Modèles.Couple;
import bibliothequegraphe.Modèles.SommetVisuel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author simonetma
 */
public class PanelAffichageGraphe extends JPanel {
    private Fenetre fenetre;
    private ArrayList<PanelSommet> panelSommetsNonAffiche;
    private ArrayList<PanelSommet> panelSommetsAffiche;
    private int Taille = 60;
    private PanelSommet sommetSelectionné;
    
    public PanelAffichageGraphe(Fenetre _fenetre) {
        this.fenetre = _fenetre;
        this.panelSommetsAffiche = new ArrayList<>();
        this.panelSommetsNonAffiche = new ArrayList<>();
        this.sommetSelectionné = null;
        //parametrage du panel
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.addMouseListener(new ControleurPanelGraphe(this));
    } 
    
     //fonction d'initialisation lors de la demande d'affichage d'un nouveau graphe
    public void initialisation() {
        //suppression de l'existant 
        this.removeAll();
        this.panelSommetsNonAffiche.clear();
        this.panelSommetsAffiche.clear();
        
        //creation des panels des sommets
        for(SommetVisuel s:this.fenetre.getGraphe().getSommets()) {
            s.setVisible(false);
            PanelSommet newPanel = new PanelSommet(this,s);
            this.panelSommetsNonAffiche.add(newPanel);
        }
    }
    
    //renvoie la taille d'un sommet
    public int getTailleSommet() {
        return Taille;
    }
    
    //ajout d'un sommet dans le graphe lors d'un clique
    public void ajouteSommet(Point c) {
        if(!this.panelSommetsNonAffiche.isEmpty()) {
            //on récupère le premier sommet non afficher
            PanelSommet panelAafficher = this.panelSommetsNonAffiche.get(0);
            //on l'enlève des sommets à afficher
            this.panelSommetsNonAffiche.remove(panelAafficher);
            //on l'ajoute aux components
            this.add(panelAafficher);
            //on le positionne
            panelAafficher.setCenter(c);
            panelAafficher.setBounds((int) c.getX()-Taille/2,(int) c.getY()-Taille/2, Taille, Taille);
            //on l'ajoute à la liste des sommets affichés
            this.panelSommetsAffiche.add(panelAafficher);
            //on l'informe de sa visibilité
            panelAafficher.setSommetVisible(true);
            panelAafficher.validate();
            this.repaint();
        }
    }
    
    //faire bouger le sommet selectionner
    public void bougerSelectedSommet(Point c) {
        //on le positionne
        sommetSelectionné.setCenter(c);
        sommetSelectionné.setBounds((int) c.getX()-Taille/2,(int) c.getY()-Taille/2, Taille, Taille);
        this.selectSommet(sommetSelectionné);
    }
    
    //dessin d'un arc
    public void paintArc(ArcVisuel arc, Graphics g) {
        if(this.fenetre.getGraphe().isOrienté()) {
            //récupère les centres des deux sommets
            Couple CentreSommetDepart = arc.SommetDebut.getCenter();
            Couple CentreSommetFin = arc.SommetFin.getCenter();
            //calcul du vecteur direction
            Couple direction = CentreSommetFin.difference(CentreSommetDepart);
            //calcul du vecteur perpendiculaire normalisé et grossi de Taille/6
            Couple vecteurP = direction.perpendiculaire().normalisation(Taille/6);
            //calcul du vecteur de sortie du node
            Couple vecteurS = direction.normalisation(Taille*5/9);
            //calcul du point de départ et d'arrivée de la flèche
            Couple départ = CentreSommetDepart.decalage(vecteurP).decalage(vecteurS);
            Couple fin = CentreSommetFin.decalage(vecteurP).difference(vecteurS);
            //trace la flèche
            this.paintFleche(départ,fin,g);
        }
        else {
            //récupère le départ et l'arrivée du trait
            Couple départ = arc.SommetDebut.getCenter();
            Couple fin = arc.SommetFin.getCenter();
            //trace le trait
            this.paintTrait(départ, fin, g);
        }
        
    }
    
    //tracage d'un trait
    public void paintTrait(Couple départ, Couple fin, Graphics g) {
        g.drawLine(départ.getX(), départ.getY(), fin.getX(), fin.getY());
    }
    
    //traçage d'une flèche
    public void paintFleche(Couple départ,Couple fin, Graphics g) {
        g.drawLine(départ.getX(), départ.getY(), fin.getX(), fin.getY());
        Couple SommetFleche1 = fin.sommetFleche(départ,1);
        Couple SommetFleche2 = fin.sommetFleche(départ,2);
        g.drawLine(fin.getX(), fin.getY(), SommetFleche1.getX(), SommetFleche1.getY());
        g.drawLine(fin.getX(), fin.getY(), SommetFleche2.getX(), SommetFleche2.getY());
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //antialiasing
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
        
        //affichage des arcs
        if(this.fenetre.getGraphe() != null) {
            for(ArcVisuel arc : this.fenetre.getGraphe().getArcs()) {
                if(arc.isVisible()) {
                    this.paintArc(arc,g);
                }
            }
        }
    }
    
    //gere la selection d'un sommet
    public void selectSommet(PanelSommet panelSommet) {
        if(panelSommet != this.sommetSelectionné) {
            if(this.sommetSelectionné != null) {
                this.sommetSelectionné.changeCouleur();
            }
            this.sommetSelectionné = panelSommet;
        }
        else {
            this.sommetSelectionné = null;
        }
        panelSommet.changeCouleur();
        this.repaint();
    }
    
    //y a t il un sommet sélectionné ?
    public Boolean isSelectedSommet() {
        return (this.sommetSelectionné != null);
    }
    
    
}
