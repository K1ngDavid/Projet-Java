package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

public class SaintPaladin extends General {
    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
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

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
