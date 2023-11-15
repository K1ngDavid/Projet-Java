package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class MageSaint extends General {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public MageSaint(){
        this.gestionnaireArmeeEmpereur= this.gestionnaireArmeeEmpereur.setArmee(this);
        this.setStatistiques(100, 400, 600);
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

