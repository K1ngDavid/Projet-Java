package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Espece;
import Univers.Personnage;
import Univers.empereur.GestionnaireArmeeEmpereur;

public class SilloneurDesTrefonds extends Capitaine {
    //private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public SilloneurDesTrefonds(){
        super(Espece.DEMON);
        image = "src/Images/sillonneur_des_trefonds.png";
        //this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        //this.gestionnaireArmeeDemon = GestionnaireArmeeDemons.setArmee(this);
        this.setGestionnaireArmee(GestionnaireArmeeDemons.setArmee(this));
        this.setStatistiques(90, 180, 60);
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
