package univers.empereur;

import univers.Capitaine;

public class Silvios extends Capitaine {

    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Silvios(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(10);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(10);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(10);
        this.setStatistiques(80, 160, 80);
    }
}
