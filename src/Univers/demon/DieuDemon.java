package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class DieuDemon extends Capitaine {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée un dieu démon avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public DieuDemon(){
        super(Espece.DEMON);
        image = "src/Images/dieu_demon.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(70, 140, 100);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'un dieu démon
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
