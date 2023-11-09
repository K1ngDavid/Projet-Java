package univers.demon;

import univers.ActionsPersonnage;
import univers.General;
import univers.Personnage;

public class Necromancien extends General {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public Necromancien(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(1000);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(1000);
        this.gestionnaireArmeeDemon.updateNombreFantassins(1000);

        this.gestionnaireArmeeDemon.updateNombreDieuDemon(20);
        this.gestionnaireArmeeDemon.updateNombreSilloneurDesTrefonds(20);
        this.gestionnaireArmeeDemon.updateNombreAntechrist(20);

        this.setStatistiques(30, 500, 700);
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
