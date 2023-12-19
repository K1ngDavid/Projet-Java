package Univers;

import java.io.Serializable;

//abstract ?
public class GestionnaireArmee implements Serializable {

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
    }

    public void initTroupes(Espece espece){

        this.trouoeFantassins = new Fantassin(espece);
        this.troupeArchers = new Archer(espece);
        this.troupeCavaliers = new Cavalier(espece);

        /*
        this.trouoeFantassins = new Fantassin();
        this.troupeArchers = new Archer();
        this.troupeCavaliers = new Cavalier();

         */
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

    public void setCaractéristiquesTroupesFantassins(int force, int pointDeVie, int mana){
        this.trouoeFantassins.setStatistiques(force*this.nombreFantassins, pointDeVie*this.nombreFantassins, mana*this.nombreFantassins);
    }
    public void setCaractéristiquesTroupesArchers(int force, int pointDeVie, int mana){
        this.troupeArchers.setStatistiques(force*this.nombreArchers, pointDeVie*this.nombreArchers, mana*this.nombreArchers);
    }
    public void setCaractéristiquesTroupesCavaliers(int force, int pointDeVie, int mana){
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
        return "[Fantassins]\n" + "Nombre : " + this.nombreFantassins + "\t" + this.trouoeFantassins + "\n" + "[Cavaliers]\n" + "Nombre : " + "\t" +this.nombreCavaliers + "\t" +
                this.troupeCavaliers +"\n" + "[Archers]\n" + "Nombre : " + this.nombreArchers + "\t" + this.troupeArchers;
    }
}
