package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Personnage;

public class Epeiste extends Capitaine {

    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Epeiste(){
        this.gestionnaireArmeeEmpereur= this.gestionnaireArmeeEmpereur.setArmee(this);
        this.setStatistiques(90, 120, 70);
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
