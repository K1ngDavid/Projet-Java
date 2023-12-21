package Univers;

import java.io.Serializable;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 */
public class GestionnaireArmee implements Serializable {

    private int nombreFantassins;
    private int nombreArchers;
    private int nombreCavaliers;

    /**
     * Cet attribut représente l'intégralité des fantassins de l'armée en un seul personnage
     */
    private Fantassin trouoeFantassins;
    /**
     * Cet attribut représente l'intégralité des archers de l'armée en un seul personnage
     */
    private Archer troupeArchers;
    /**
     * Cet attribut représente l'intégralité des cavaliers de l'armée en un seul personnage
     */
    private Cavalier troupeCavaliers;

    public GestionnaireArmee(){
        this.nombreFantassins = 0;
        this.nombreArchers = 0;
        this.nombreCavaliers = 0;
    }

    /**
     * Définit les caractéristiques des troupes en fonction de leur espèce
     * @param espece
     */
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

    /**
     * Met à jour le nombre de Fantassins
     * @param nombreFantassins
     */
    public void updateNombreFantassins(int nombreFantassins){
        this.nombreFantassins = nombreFantassins;
    }

    /**
     * Met à jour le nombre d'Archers
     * @param nombreArchers
     */
    public void updateNombreArchers(int nombreArchers){
        this.nombreArchers = nombreArchers;
    }

    /**
     * Met à jour le nombre de Cavaliers
     * @param nombreCavaliers
     */
    public void updateNombreCavaliers(int nombreCavaliers){
        this.nombreCavaliers = nombreCavaliers;
    }

    /**
     * Réduit les points de vie de l'attribut représentant l'intégralité des fantassins
     * @param perte
     */
    public void perteFantassin(int perte){
        this.trouoeFantassins.perdrePV(perte);
    }

    /**
     * Réduit les points de vie de l'attribut représentant l'intégralité des archers
     * @param perte
     */
    public void perteArcher(int perte){
        this.troupeArchers.perdrePV(perte);
    }

    /**
     * Réduit les points de vie de l'attribut représentant l'intégralité des cavaliers
     * @param perte
     */
    public void perteCavalier(int perte){
        this.troupeCavaliers.perdrePV(perte);
    }

    /**
     * Met à jour les statistiques de l'armée de fantassins
     * @param force
     * @param pointDeVie
     * @param mana
     */
    public void setCaractéristiquesTroupesFantassins(int force, int pointDeVie, int mana){
        this.trouoeFantassins.setStatistiques(force*this.nombreFantassins, pointDeVie*this.nombreFantassins, mana*this.nombreFantassins);
    }

    /**
     * Met à jour les statistiques de l'armée d'archers
     * @param force
     * @param pointDeVie
     * @param mana
     */
    public void setCaractéristiquesTroupesArchers(int force, int pointDeVie, int mana){
        this.troupeArchers.setStatistiques(force*this.nombreArchers, pointDeVie*this.nombreArchers, mana*this.nombreArchers);
    }

    /**
     * Met à jour les statistiques de l'armée de cavaliers
     * @param force
     * @param pointDeVie
     * @param mana
     */
    public void setCaractéristiquesTroupesCavaliers(int force, int pointDeVie, int mana){
        this.troupeCavaliers.setStatistiques(force*this.nombreCavaliers, pointDeVie*this.nombreCavaliers, mana*this.nombreCavaliers);
    }

    /**
     * Renvoie les troupes de fantassins
     * @return
     */
    public Fantassin getTroupeFantassins(){
        return this.trouoeFantassins;
    }

    /**
     * Renvoie les troupes de cavaliers
     * @return
     */
    public Cavalier getTroupeCavaliers(){
        return this.troupeCavaliers;
    }

    /**
     * Renvoie les troupes d'archers
     * @return
     */
    public Archer getTroupeArchers(){
        return this.troupeArchers;
    }

    /**
     * Renvoie une description textuelle du gestionnaire d'armée
     * @return
     */
    public String toString(){
        return "[Fantassins]\n" + "Nombre : " + this.nombreFantassins + "\t" + this.trouoeFantassins + "\n" + "[Cavaliers]\n" + "Nombre : " + "\t" +this.nombreCavaliers + "\t" +
                this.troupeCavaliers +"\n" + "[Archers]\n" + "Nombre : " + this.nombreArchers + "\t" + this.troupeArchers;
    }
}
