package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class MageSaint extends General {
    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    /**
     * Crée un mage saint avec notamment ses statistiques et son armée (i.e gestionnaireArmeeEmpereur)
     */
    public MageSaint(){
        super(Espece.EMPEREUR);
        image = "src/Images/mage_saint.png";
        //this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        //this.gestionnaireArmeeEmpereur= GestionnaireArmeeEmpereur.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeEmpereur.setArmee(this));
        this.setStatistiques(100, 400, 600);
    }

    /*
    public GestionnaireArmeeEmpereur getGestionnaireArmeeEmpereur(){
        return this.gestionnaireArmeeEmpereur;
    }

     */

    /**
     * Renvoie une description textuelle d'un mage saint
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}

