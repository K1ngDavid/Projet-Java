package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class NemesisDuChaos extends General {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée une némésis du chaos avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public NemesisDuChaos(){
        super(Espece.DEMON);
        image = "src/Images/nemesis.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(500, 1500, 100);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'une némésis du chaos
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
