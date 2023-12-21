package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class BerserkerDeLApocalyspse extends General {
    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    /**
     * Crée un berserker avec notamment ses statistiques et son armée (i.e gestionnaireArmeeEmpereur)
     */
    public BerserkerDeLApocalyspse(){
        super(Espece.EMPEREUR);
        image = "src/Images/berserker.png";
        //this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        //this.gestionnaireArmeeEmpereur= GestionnaireArmeeEmpereur.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeEmpereur.setArmee(this));
        this.setStatistiques(350, 1300, 300);
    }

    /*
    public GestionnaireArmeeEmpereur getGestionnaireArmeeEmpereur(){
        return this.gestionnaireArmeeEmpereur;
    }

     */

    /**
     * Renvoie une description textuelle d'un berserker
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
