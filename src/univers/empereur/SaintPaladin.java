package univers.empereur;

import univers.General;

public class SaintPaladin extends General {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public SaintPaladin(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(1000);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(1000);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(1000);

        this.gestionnaireArmeeEmpereur.updateNombreSilvios(20);
        this.gestionnaireArmeeEmpereur.updateNomrbreTank(20);
        this.gestionnaireArmeeEmpereur.updateNombreEpeiste(20);

        this.setStatistiques(80, 320, 0);
    }
}
