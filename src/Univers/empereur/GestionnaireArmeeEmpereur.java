package Univers.empereur;

import Univers.GestionnaireArmee;

public class GestionnaireArmeeEmpereur extends GestionnaireArmee {
    private int nombreSilvios;
    private int nomrbreTank;
    private int nombreEpeiste;

    private Silvios silviosType;
    private Tank tankType;
    private Epeiste epeisteType;
    public GestionnaireArmeeEmpereur(){
        super();

        this.nombreSilvios = 0;
        this.nomrbreTank = 0;
        this.nombreEpeiste = 0;

        this.silviosType = new Silvios();
        this.tankType = new Tank();
        this.epeisteType = new Epeiste();
    }

    public void updateNombreSilvios(int nombreSilvios){
        this.nombreSilvios = nombreSilvios;
    }

    public void updateNomrbreTank(int nomrbreTank){
        this.nomrbreTank = nomrbreTank;
    }

    public void updateNombreEpeiste(int nombreEpeiste){
        this.nombreEpeiste = nombreEpeiste;
    }

    public void perteSilvios(int perte){
        this.nombreSilvios-=perte;
    }

    public void perteTank(int perte){
        this.nomrbreTank-=perte;
    }

    public void perteEpeiste(int perte){
        this.nombreEpeiste-=perte;
    }


    public void setCaractéristiquesSilvios(int force, int pointDeVie, int mana){
        this.silviosType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesTank(int force, int pointDeVie, int mana){
        this.tankType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesEpeiste(int force, int pointDeVie, int mana){
        this.epeisteType.setStatistiques(force, pointDeVie, mana);
    }
}
