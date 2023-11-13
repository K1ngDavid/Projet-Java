package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.General;
import Univers.Personnage;

public class NemesisDuChaos extends General {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public NemesisDuChaos(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(1000);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(1000);
        this.gestionnaireArmeeDemon.updateNombreFantassins(1000);

        this.gestionnaireArmeeDemon.updateNombreDieuDemon(20);
        this.gestionnaireArmeeDemon.updateNombreSilloneurDesTrefonds(20);
        this.gestionnaireArmeeDemon.updateNombreAntechrist(20);

        this.setStatistiques(500, 1500, 100);
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
