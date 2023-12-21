package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class Epeiste extends Capitaine {

    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    /**
     * Crée un épéiste avec notamment ses statistiques et son armée (i.e gestionnaireArmeeEmpereur)
     */
    public Epeiste(){
        super(Espece.EMPEREUR);
        image = "src/Images/epeiste.png";
        //this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        //this.gestionnaireArmeeEmpereur= GestionnaireArmeeEmpereur.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeEmpereur.setArmee(this));
        this.setStatistiques(90, 120, 70);
    }

    /*
    public GestionnaireArmeeEmpereur getGestionnaireArmeeEmpereur(){
        return this.gestionnaireArmeeEmpereur;
    }

     */

    /**
     * Renvoie une description textuelle d'un épéiste
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
