package univers.demon;

import univers.Capitaine;

public class SilloneurDesTrefonds extends Capitaine {
    private GestionnaireArmeeDemons gestionnaireArmeeDemon;
    public SilloneurDesTrefonds(){
        this.gestionnaireArmeeDemon = new GestionnaireArmeeDemons();
        this.gestionnaireArmeeDemon.updateNombreArchers(10);
        this.gestionnaireArmeeDemon.updateNombreCavaliers(10);
        this.gestionnaireArmeeDemon.updateNombreFantassins(10);
        this.setStatistiques(90, 180, 60);
    }
}
