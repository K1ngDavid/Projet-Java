package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Espece;
import Univers.General;
import Univers.Personnage;

public class NemesisDuChaos extends General {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public NemesisDuChaos(){
        super(Espece.DEMON);
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);

        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(500, 1500, 100);
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
