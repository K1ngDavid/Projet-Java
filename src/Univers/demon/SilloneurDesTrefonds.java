package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;
import Univers.empereur.GestionnaireArmeeEmpereur;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class SilloneurDesTrefonds extends Capitaine {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;

    /**
     * Crée un sillonneur des tréfonds avec notamment ses statistiques et son armée (i.e gestionnaireArmeeDemons)
     */
    public SilloneurDesTrefonds(){
        super(Espece.DEMON);
        image = "src/Images/sillonneur_des_trefonds.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(90, 180, 60);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    /**
     * Renvoie une description textuelle d'un sillonneur des tréfonds
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
