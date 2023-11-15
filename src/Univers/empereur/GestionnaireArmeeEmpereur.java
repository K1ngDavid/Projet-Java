package Univers.empereur;

import Univers.GestionnaireArmee;
import Univers.Personnage;

public class GestionnaireArmeeEmpereur extends GestionnaireArmee {
    private int nombreSilvios;
    private int nomrbreTank;
    private int nombreEpeiste;

    private Silvios troupeSilvios;
    private Tank troupeTanks;
    private Epeiste troupeEpeistes;
    public GestionnaireArmeeEmpereur(){
        super();

        this.nombreSilvios = 0;
        this.nomrbreTank = 0;
        this.nombreEpeiste = 0;

        this.troupeSilvios = new Silvios();
        this.troupeTanks = new Tank();
        this.troupeEpeistes = new Epeiste();
    }

    public GestionnaireArmeeEmpereur setArmee(Personnage personnage){
        if(personnage instanceof Silvios){
            super.updateNombreArchers(15);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(5);

            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);
        }
        else if(personnage instanceof Tank){
            super.updateNombreArchers(15);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(5);

            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);
        }
        else if(personnage instanceof Epeiste){
            super.updateNombreArchers(5);
            super.updateNombreCavaliers(5);
            super.updateNombreFantassins(15);

            super.setCaractéristiquesArchers(5, 5, 5);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(10, 10, 10);
        }
        else if(personnage instanceof BerserkerDeLApocalyspse){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreSilvios(20);
            this.updateNomrbreTank(20);
            this.updateNombreEpeiste(20);
            this.setCaractéristiquesSilvios(80, 160, 80);
            this.setCaractéristiquesTank(80, 160, 50);
            this.setCaractéristiquesEpeiste(90, 120, 70);
        }
        else if(personnage instanceof MageSaint){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreSilvios(20);
            this.updateNomrbreTank(20);
            this.updateNombreEpeiste(20);
            this.setCaractéristiquesSilvios(80, 160, 80);
            this.setCaractéristiquesTank(80, 160, 50);
            this.setCaractéristiquesEpeiste(90, 120, 70);
        }
        else if (personnage instanceof SaintPaladin){
            super.updateNombreArchers(1000);
            super.updateNombreCavaliers(1000);
            super.updateNombreFantassins(1000);
            super.setCaractéristiquesArchers(10, 10, 10);
            super.setCaractéristiquesCavaliers(5, 5, 5);
            super.setCaractéristiquesFantassins(5, 5, 5);

            this.updateNombreSilvios(20);
            this.updateNomrbreTank(20);
            this.updateNombreEpeiste(20);
            this.setCaractéristiquesSilvios(80, 160, 80);
            this.setCaractéristiquesTank(80, 160, 50);
            this.setCaractéristiquesEpeiste(90, 120, 70);
        }
        return this;
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
        this.troupeSilvios.perdrePV(perte);
    }

    public void perteTank(int perte){
        this.troupeTanks.perdrePV(perte);
    }

    public void perteEpeiste(int perte){
        this.troupeEpeistes.perdrePV(perte);
    }


    public void setCaractéristiquesSilvios(int force, int pointDeVie, int mana){
        this.troupeSilvios.setStatistiques(force*this.nombreSilvios, pointDeVie*this.nombreSilvios, mana*this.nombreSilvios);
    }
    public void setCaractéristiquesTank(int force, int pointDeVie, int mana){
        this.troupeTanks.setStatistiques(force*this.nomrbreTank, pointDeVie*this.nomrbreTank, mana*this.nomrbreTank);
    }
    public void setCaractéristiquesEpeiste(int force, int pointDeVie, int mana){
        this.troupeEpeistes.setStatistiques(force*this.nombreEpeiste, pointDeVie*this.nombreEpeiste, mana*this.nombreEpeiste);
    }

    public Silvios getTroupeSilvios(){
        return this.troupeSilvios;
    }

    public Epeiste getTroupeEpeistes(){
        return this.troupeEpeistes;
    }

    public Tank getTroupeTanks(){
        return this.troupeTanks;
    }
}
