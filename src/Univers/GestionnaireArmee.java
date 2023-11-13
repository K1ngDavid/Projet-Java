package Univers;

import Univers.empereur.Epeiste;
import Univers.empereur.Silvios;
import Univers.empereur.Tank;

public abstract class GestionnaireArmee {

    private int nombreFantassins;
    private int nombreArchers;
    private int nombreCavaliers;

    private Fantassin trouoeFantassins;
    private Archer troupeArchers;
    private Cavalier troupeCavaliers;

    public GestionnaireArmee(){
        this.nombreFantassins = 0;
        this.nombreArchers = 0;
        this.nombreCavaliers = 0;

        this.trouoeFantassins = new Fantassin();
        this.troupeArchers = new Archer();
        this.troupeCavaliers = new Cavalier();
    }

    public void updateNombreFantassins(int nombreFantassins){
        this.nombreFantassins = nombreFantassins;
    }

    public void updateNombreArchers(int nombreArchers){
        this.nombreArchers = nombreArchers;
    }

    public void updateNombreCavaliers(int nombreCavaliers){
        this.nombreCavaliers = nombreCavaliers;
    }

    public void perteFantassin(int perte){
        this.trouoeFantassins.perdrePV(perte);
    }

    public void perteArcher(int perte){
        this.troupeArchers.perdrePV(perte);
    }

    public void perteCavalier(int perte){
        this.troupeCavaliers.perdrePV(perte);
    }

    public void setCaractéristiquesFantassins(int force, int pointDeVie, int mana){
        this.trouoeFantassins.setStatistiques(force*this.nombreFantassins, pointDeVie*this.nombreFantassins, mana*this.nombreFantassins);
    }
    public void setCaractéristiquesArchers(int force, int pointDeVie, int mana){
        this.troupeArchers.setStatistiques(force*this.nombreArchers, pointDeVie*this.nombreArchers, mana*this.nombreArchers);
    }
    public void setCaractéristiquesCavaliers(int force, int pointDeVie, int mana){
        this.troupeCavaliers.setStatistiques(force*this.nombreCavaliers, pointDeVie*this.nombreCavaliers, mana*this.nombreCavaliers);
    }

    public Fantassin getTroupeFantassins(){
        return this.trouoeFantassins;
    }

    public Cavalier getTroupeCavaliers(){
        return this.troupeCavaliers;
    }

    public Archer getTroupeArchers(){
        return this.troupeArchers;
    }

    public String toString(){
        return "[Fantassins]" + this.trouoeFantassins + "\n" + "[Cavaliers]" + this.troupeCavaliers + "\n" +
                "[Archers]" + this.troupeArchers;
    }
}
