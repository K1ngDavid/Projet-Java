package univers.demon;

import univers.ActionsPersonnage;
import univers.Capitaine;
import univers.Personnage;

public class Antechrist extends Capitaine {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public Antechrist(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(10);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(10);
        this.gestionnaireArmeeDemon.updateNombreFantassins(10);
        this.setStatistiques(85, 170, 70);
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
