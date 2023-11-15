package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class BerserkerDeLApocalyspse extends General {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public BerserkerDeLApocalyspse(){
        this.gestionnaireArmeeEmpereur= this.gestionnaireArmeeEmpereur.setArmee(this);
        this.setStatistiques(350, 1300, 300);
    }

    /**
     * @param personnage
     */
    @Override
    public void attaquer(ActionsPersonnage personnage) {

    }

    /**
     * @param perte
     */
    @Override
    public void perdrePV(int perte) {

    }

    /**
     * @return
     */
    @Override
    public Personnage evoluerGrade() {
        return null;
    }
}
