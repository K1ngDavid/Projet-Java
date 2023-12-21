package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class Silvios extends Capitaine {

    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    /**
     * Crée un silvios avec notamment ses statistiques et son armée (i.e gestionnaireArmeeEmpereur)
     */
    public Silvios(){
        super(Espece.EMPEREUR);
        image = "src/Images/silvios.png";
        //this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        //this.gestionnaireArmeeEmpereur= GestionnaireArmeeEmpereur.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeEmpereur.setArmee(this));
        this.setStatistiques(80, 160, 80);
    }

    /*
    public GestionnaireArmeeEmpereur getGestionnaireArmeeEmpereur(){
        return this.gestionnaireArmeeEmpereur;
    }

     */

    /**
     * Renvoie une description textuelle d'un silvios
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }

}
