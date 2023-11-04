package univers.demon;

import univers.Capitaine;

public class DieuDemon extends Capitaine {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public DieuDemon(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(10);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(10);
        this.gestionnaireArmeeDemon.updateNombreFantassins(10);
        this.setStatistiques(70, 140, 100);
    }
}
