package univers.empereur;

import univers.Capitaine;

public class Tank extends Capitaine {
    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;
    public Tank(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(10);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(10);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(10);
        this.setStatistiques(80, 160, 50);
    }
}
