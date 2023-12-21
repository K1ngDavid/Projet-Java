package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class CavalierDuNeant extends General {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée un cavalier du néant avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public CavalierDuNeant(){
        super(Espece.DEMON);
        image = "src/Images/cavalier_du_neant.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(450, 1350, 500);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'un cavalier du néant
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
