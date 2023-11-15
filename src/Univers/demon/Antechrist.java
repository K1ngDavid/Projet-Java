package Univers.demon;

import Univers.ActionsPersonnage;
import Univers.Capitaine;
import Univers.Personnage;

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
