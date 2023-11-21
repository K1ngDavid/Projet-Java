package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

public class BerserkerDeLApocalyspse extends General {
    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public BerserkerDeLApocalyspse(){
        super(Espece.EMPEREUR);
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

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
