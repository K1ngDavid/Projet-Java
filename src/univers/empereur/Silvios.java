package univers.empereur;

import univers.ActionsPersonnage;
import univers.Capitaine;
import univers.Personnage;

public class Silvios extends Capitaine {

    private GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur;

    public Silvios(){
        this.gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        this.gestionnaireArmeeEmpereur.updateNombreArchers(10);
        this.gestionnaireArmeeEmpereur.updateNombreCavaliers(10);
        this.gestionnaireArmeeEmpereur.updateNombreFantassins(10);
        this.setStatistiques(80, 160, 80);
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
