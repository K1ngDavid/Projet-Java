package Univers.demon;

import Univers.GestionnaireArmee;

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
