package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

public class Necromancien extends General {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public Necromancien(){
        super(Espece.DEMON);
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(30, 500, 700);
    }

    /*
    public GestionnaireArmeeDemons getGestionnaireArmeeDemon(){
        return this.gestionnaireArmeeDemon;
    }

     */

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getGestionnaireArmee();
    }
}
