package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class SaintPaladin extends General {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public SaintPaladin(){
        this.gestionnaireArmeeEmpereur= this.gestionnaireArmeeEmpereur.setArmee(this);
        this.setStatistiques(80, 320, 0);
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
