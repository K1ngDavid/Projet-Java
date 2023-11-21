package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

public class Epeiste extends Capitaine {

    //private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Epeiste(){
        super(Espece.EMPEREUR);
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

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
