package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class CavalierDuNeant extends General {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public CavalierDuNeant(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(1000);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(1000);
        this.gestionnaireArmeeDemon.updateNombreFantassins(1000);

        this.gestionnaireArmeeDemon.updateNombreDieuDemon(20);
        this.gestionnaireArmeeDemon.updateNombreSilloneurDesTrefonds(20);
        this.gestionnaireArmeeDemon.updateNombreAntechrist(20);

        this.setStatistiques(450, 1350, 500);
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
