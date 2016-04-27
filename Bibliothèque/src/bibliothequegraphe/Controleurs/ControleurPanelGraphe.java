/*
 * Controleur du panel Graphe
 */
package bibliothequegraphe.Controleurs;

import bibliothequegraphe.Vues.PanelAffichageGraphe;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author simonetma
 */
public class ControleurPanelGraphe implements MouseListener {
    private PanelAffichageGraphe vue;

    
    public ControleurPanelGraphe(PanelAffichageGraphe _vue) {
        this.vue = _vue;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(this.vue.isSelectedSommet()) {
            this.vue.bougerSelectedSommet(me.getPoint());
        }
        else {
            this.vue.ajouteSommet(me.getPoint());
        }
    }

    
    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
    
}
