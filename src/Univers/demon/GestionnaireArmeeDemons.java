package Univers.demon;

import Univers.Espece;
import Univers.GestionnaireArmee;
import Univers.Personnage;

public class GestionnaireArmeeDemons extends GestionnaireArmee {
    private int nombreDieuDemon;
    private int nombreSilloneurDesTrefonds;
    private int nombreAntechrist;

    private DieuDemon troupeDieuDemon;
    private SilloneurDesTrefonds troupeSilloneurDesTrefonds;
    private Antechrist troupeAntechrist;

    public GestionnaireArmeeDemons(){
        super();

        this.nombreDieuDemon = 0;
        this.nombreSilloneurDesTrefonds = 0;
        this.nombreAntechrist = 0;
    }

    public void initTroupes(){
        super.initTroupes(Espece.DEMON);
        //this.troupeDieuDemon = new DieuDemon();
        //this.troupeSilloneurDesTrefonds = new SilloneurDesTrefonds();
        //this.troupeAntechrist = new Antechrist();
    }

    public static GestionnaireArmeeDemons setArmee(Personnage personnage){
        GestionnaireArmeeDemons gestionnaireArmeeDemons = new GestionnaireArmeeDemons();
        gestionnaireArmeeDemons.initTroupes();
        if(personnage.isDemon()){
            if(personnage instanceof SilloneurDesTrefonds){
                gestionnaireArmeeDemons.updateNombreArchers(5);
                gestionnaireArmeeDemons.updateNombreCavaliers(15);
                gestionnaireArmeeDemons.updateNombreFantassins(5);

                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(5, 5, 5);
            }
            else if(personnage instanceof Antechrist){
                gestionnaireArmeeDemons.updateNombreArchers(15);
                gestionnaireArmeeDemons.updateNombreCavaliers(5);
                gestionnaireArmeeDemons.updateNombreFantassins(5);

                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(5, 5, 5);
            }
            else if(personnage instanceof DieuDemon){
                gestionnaireArmeeDemons.updateNombreArchers(5);
                gestionnaireArmeeDemons.updateNombreCavaliers(5);
                gestionnaireArmeeDemons.updateNombreFantassins(15);

                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(10, 10, 10);
            }
            else if(personnage instanceof NemesisDuChaos){
                gestionnaireArmeeDemons.updateNombreArchers(1000);
                gestionnaireArmeeDemons.updateNombreCavaliers(1000);
                gestionnaireArmeeDemons.updateNombreFantassins(1000);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(5, 5, 5);

                /*
                gestionnaireArmeeDemons.updateNombreDieuDemon(20);
                gestionnaireArmeeDemons.updateNombreSilloneurDesTrefonds(20);
                gestionnaireArmeeDemons.updateNombreAntechrist(20);
                gestionnaireArmeeDemons.setCaractéristiquesDieuDemon(80, 160, 80);
                gestionnaireArmeeDemons.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
                gestionnaireArmeeDemons.setCaractéristiquesAntechrist(90, 120, 70);

                 */
            }
            else if(personnage instanceof Necromancien){
                gestionnaireArmeeDemons.updateNombreArchers(1000);
                gestionnaireArmeeDemons.updateNombreCavaliers(1000);
                gestionnaireArmeeDemons.updateNombreFantassins(1000);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(5, 5, 5);

                /*
                gestionnaireArmeeDemons.updateNombreDieuDemon(20);
                gestionnaireArmeeDemons.updateNombreSilloneurDesTrefonds(20);
                gestionnaireArmeeDemons.updateNombreAntechrist(20);
                gestionnaireArmeeDemons.setCaractéristiquesDieuDemon(80, 160, 80);
                gestionnaireArmeeDemons.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
                gestionnaireArmeeDemons.setCaractéristiquesAntechrist(90, 120, 70);

                 */
            }
            else if (personnage instanceof CavalierDuNeant){
                gestionnaireArmeeDemons.updateNombreArchers(1000);
                gestionnaireArmeeDemons.updateNombreCavaliers(1000);
                gestionnaireArmeeDemons.updateNombreFantassins(1000);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeDemons.setCaractéristiquesTroupesFantassins(5, 5, 5);

                /*
                gestionnaireArmeeDemons.updateNombreDieuDemon(20);
                gestionnaireArmeeDemons.updateNombreSilloneurDesTrefonds(20);
                gestionnaireArmeeDemons.updateNombreAntechrist(20);
                gestionnaireArmeeDemons.setCaractéristiquesDieuDemon(80, 160, 80);
                gestionnaireArmeeDemons.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
                gestionnaireArmeeDemons.setCaractéristiquesAntechrist(90, 120, 70);

                 */
            }
        }
        return gestionnaireArmeeDemons;
    }

    public void updateNombreDieuDemon(int nombreDieuDemon){
        this.nombreDieuDemon = nombreDieuDemon;
    }

    public void updateNombreSilloneurDesTrefonds(int nombreSilloneurDesTrefonds){
        this.nombreSilloneurDesTrefonds = nombreSilloneurDesTrefonds;
    }

    public void updateNombreAntechrist(int nombreAntechrist){
        this.nombreAntechrist = nombreAntechrist;
    }

    public void perteDieuDemon(int perte){
        this.nombreDieuDemon-=perte;
    }

    public void perteSilloneurDesTrefonds(int perte){
        this.nombreSilloneurDesTrefonds-=perte;
    }

    public void perteAntechrist(int perte){
        this.nombreAntechrist-=perte;
    }


    public void setCaractéristiquesDieuDemon(int force, int pointDeVie, int mana){
        this.troupeDieuDemon.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesSilloneurDesTrefonds(int force, int pointDeVie, int mana){
        this.troupeSilloneurDesTrefonds.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesAntechrist(int force, int pointDeVie, int mana){
        this.troupeAntechrist.setStatistiques(force, pointDeVie, mana);
    }
}
