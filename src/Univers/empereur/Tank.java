package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Personnage;

public class Tank extends Capitaine {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public Tank(){
        this.gestionnaireArmeeEmpereur= this.gestionnaireArmeeEmpereur.setArmee(this);
        this.setStatistiques(80, 160, 50);
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
