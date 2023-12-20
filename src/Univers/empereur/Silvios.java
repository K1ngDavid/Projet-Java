package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

public class Silvios extends Capitaine {

    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

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

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }

}
