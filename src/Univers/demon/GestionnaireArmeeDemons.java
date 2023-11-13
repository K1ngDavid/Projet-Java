package Univers.demon;

import Univers.GestionnaireArmee;
import Univers.Personnage;
import Univers.empereur.*;

public class GestionnaireArmeeDemons extends GestionnaireArmee {
    private int nombreDieuDemon;
    private int nombreSilloneurDesTrefonds;
    private int nombreAntechrist;

    private DieuDemon dieuDemonType;
    private SilloneurDesTrefonds silloneurDesTrefondsType;
    private Antechrist antechristType;

    public GestionnaireArmeeDemons(){
        super();

        this.nombreDieuDemon = 0;
        this.nombreSilloneurDesTrefonds = 0;
        this.nombreAntechrist = 0;

        this.dieuDemonType = new DieuDemon();
        this.silloneurDesTrefondsType = new SilloneurDesTrefonds();
        this.antechristType = new Antechrist();
    }

    public GestionnaireArmeeDemons setArmee(Personnage personnage){
        if(personnage instanceof SilloneurDesTrefonds){
            super.updateNombreArchers(15);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(5);

            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);
        }
        else if(personnage instanceof Antechrist){
            super.updateNombreArchers(15);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(5);

            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);
        }
        else if(personnage instanceof DieuDemon){
            super.updateNombreArchers(5);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(15);

            super.setCaractéristiquesArchers(5, 5, 5);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(10, 10, 10);
        }
        else if(personnage instanceof NemesisDuChaos){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreDieuDemon(20);
            this.updateNombreSilloneurDesTrefonds(20);
            this.updateNombreAntechrist(20);
            this.setCaractéristiquesDieuDemon(80, 160, 80);
            this.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
            this.setCaractéristiquesAntechrist(90, 120, 70);
        }
        else if(personnage instanceof Necromancien){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreDieuDemon(20);
            this.updateNombreSilloneurDesTrefonds(20);
            this.updateNombreAntechrist(20);
            this.setCaractéristiquesDieuDemon(80, 160, 80);
            this.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
            this.setCaractéristiquesAntechrist(90, 120, 70);
        }
        else if (personnage instanceof CavalierDuNeant){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreDieuDemon(20);
            this.updateNombreSilloneurDesTrefonds(20);
            this.updateNombreAntechrist(20);
            this.setCaractéristiquesDieuDemon(80, 160, 80);
            this.setCaractéristiquesSilloneurDesTrefonds(80, 160, 50);
            this.setCaractéristiquesAntechrist(90, 120, 70);
        }
        return this;
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
        this.dieuDemonType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesSilloneurDesTrefonds(int force, int pointDeVie, int mana){
        this.silloneurDesTrefondsType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesAntechrist(int force, int pointDeVie, int mana){
        this.antechristType.setStatistiques(force, pointDeVie, mana);
    }
}
