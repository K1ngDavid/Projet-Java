package Univers;

import Univers.demon.CavalierDuNeant;
import Univers.demon.Necromancien;
import Univers.demon.NemesisDuChaos;
import Univers.empereur.BerserkerDeLApocalyspse;
import Univers.empereur.MageSaint;
import Univers.empereur.SaintPaladin;

public abstract class General extends Personnage{

    public General(Espece espece){
        super(espece);
    }

    public static General faculteSpeciale(Personnage personnage){
        if(personnage instanceof BerserkerDeLApocalyspse){
            personnage.getGestionnaireArmee().getTroupeFantassins().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeFantassins().getForce(),
                    personnage.getGestionnaireArmee().getTroupeFantassins().getPointDeVie()+200,
                    personnage.getGestionnaireArmee().getTroupeFantassins().getMana()
            );
        }
        else if(personnage instanceof MageSaint){
            personnage.getGestionnaireArmee().getTroupeArchers().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeArchers().getForce(),
                    personnage.getGestionnaireArmee().getTroupeArchers().getPointDeVie(),
                    personnage.getGestionnaireArmee().getTroupeArchers().getMana()+200
            );

        }
        else if(personnage instanceof SaintPaladin){
            personnage.getGestionnaireArmee().getTroupeCavaliers().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getForce()+200,
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getPointDeVie(),
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getMana()
            );
        }

        else if(personnage instanceof NemesisDuChaos){
            personnage.getGestionnaireArmee().getTroupeFantassins().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeFantassins().getForce() + personnage.getForce()/10,
                    personnage.getGestionnaireArmee().getTroupeFantassins().getPointDeVie(),
                    personnage.getGestionnaireArmee().getTroupeFantassins().getMana()
            );
        }
        else if(personnage instanceof Necromancien){
            personnage.getGestionnaireArmee().getTroupeFantassins().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeFantassins().getForce(),
                    personnage.getGestionnaireArmee().getTroupeFantassins().getPointDeVie()*2,
                    personnage.getGestionnaireArmee().getTroupeFantassins().getMana()
            );
            personnage.getGestionnaireArmee().getTroupeArchers().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeArchers().getForce(),
                    personnage.getGestionnaireArmee().getTroupeArchers().getPointDeVie()*2,
                    personnage.getGestionnaireArmee().getTroupeArchers().getMana()
            );
            personnage.getGestionnaireArmee().getTroupeCavaliers().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getForce(),
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getPointDeVie()*2,
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getMana()
            );
        }
        else if(personnage instanceof CavalierDuNeant){
            personnage.getGestionnaireArmee().getTroupeCavaliers().setStatistiques(
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getPointDeVie()+ personnage.getPointDeVie()/10,
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getPointDeVie(),
                    personnage.getGestionnaireArmee().getTroupeCavaliers().getMana()
            );
        }
        return (General) personnage;
    }
}
