/*
 * Classe gérant la représentation d'une arrête
 */
package bibliothequegraphe.Modèles;

import bibliothequegraphe.Modèles.Visuel.Dessinable;

/**
 *
 * @author simonetma
 */
public class ArcVisuel extends Dessinable {
      public String nom;
      public SommetVisuel SommetDebut; 
      public SommetVisuel SommetFin; 
      public boolean orienté;
      
      //constructeur
      public ArcVisuel(String _nom, SommetVisuel _depart, SommetVisuel _fin, boolean _orienté) {
          //construction du desssinable
          super();
          //initialisation de l'arc
          this.nom = _nom;
          this.SommetDebut = _depart;
          this.SommetFin = _fin;
          this.orienté = _orienté;
      }

      @Override
      public boolean isVisible() {
          return (this.SommetDebut.isVisible() && this.SommetFin.isVisible());
      }
}
