package univers.empereur;

import univers.Capitaine;

public class Epeiste extends Capitaine {

    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Epeiste(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(10);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(10);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(10);
        this.setStatistiques(90, 120, 70);
    }
}
