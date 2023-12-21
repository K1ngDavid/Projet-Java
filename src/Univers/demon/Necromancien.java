package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class Necromancien extends General {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée un nécromancien avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public Necromancien(){
        super(Espece.DEMON);
        image = "src/Images/necromancien.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(30, 500, 700);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'un nécromancien
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
