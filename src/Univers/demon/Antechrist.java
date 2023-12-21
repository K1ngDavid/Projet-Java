package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class Antechrist extends Capitaine {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée un antéchrist avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public Antechrist(){
        super(Espece.DEMON);
        image = "src/Images/antechrist.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(85, 170, 70);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'un cavalier d'un antéchrist
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
