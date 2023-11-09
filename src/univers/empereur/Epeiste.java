package univers.empereur;

import univers.ActionsPersonnage;
import univers.Capitaine;
import univers.Personnage;

public class Epeiste extends Capitaine {

    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Epeiste(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(10);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(10);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(10);
        this.setStatistiques(90, 120, 70);
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
