package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class SaintPaladin extends General {
    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    /**
     * Crée un saint paladin avec notamment ses statistiques et son armée (i.e gestionnaireArmeeEmpereur)
     */
    public SaintPaladin(){
        super(Espece.EMPEREUR);
        image = "src/Images/saint_paladin.png";
        //this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        //this.gestionnaireArmeeEmpereur= GestionnaireArmeeEmpereur.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeEmpereur.setArmee(this));
        this.setStatistiques(80, 320, 0);
    }

    /*
    public GestionnaireArmeeEmpereur getGestionnaireArmeeEmpereur(){
        return this.gestionnaireArmeeEmpereur;
    }

     */

    /**
     * Renvoie une description textuelle d'un saint paladin
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
