package Univers.empereur;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class MageSaint extends General {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public MageSaint(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(1000);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(1000);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(1000);

        this.gestionnaireArmeeEmpereur.updateNombreSilvios(20);
        this.gestionnaireArmeeEmpereur.updateNomrbreTank(20);
        this.gestionnaireArmeeEmpereur.updateNombreEpeiste(20);

        this.setStatistiques(100, 400, 600);
    }

    /**
     * @param personnage
     */
    @Override
    public void attaquer(ActionsPersonnage personnage) {

    }

    /**
     * @param personnage
     */
    @Override
    public void perdrePV(ActionsPersonnage personnage) {

    }

    /**
     * @return
     */
    @Override
    public Personnage evoluerGrade() {
        return null;
    }
}

