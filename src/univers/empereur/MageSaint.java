package univers.empereur;

import univers.General;

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
}

