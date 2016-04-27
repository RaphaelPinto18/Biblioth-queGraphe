/*
 * Controleur des panels sommets
 */
package bibliothequegraphe.Controleurs;

import bibliothequegraphe.Vues.PanelSommet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author simonetma
 */
public class ControleurPanelSommet implements MouseListener {
    private PanelSommet panelSommet;
    
    
    public ControleurPanelSommet(PanelSommet _panelSommet) {
        super();
        this.panelSommet = _panelSommet;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        this.panelSommet.select();
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
