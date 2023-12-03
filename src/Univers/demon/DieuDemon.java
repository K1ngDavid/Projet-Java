package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;

public class DieuDemon extends Capitaine {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public DieuDemon(){
        super(Espece.DEMON);
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(70, 140, 100);
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
