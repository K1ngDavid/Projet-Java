package Univers;

import Game.GamePanel;

import java.io.Serializable;

/**
 * @author Victorien GBAGUIDI
 * @version version 1
 */
public class Personnage implements ActionsPersonnage, Serializable {
    private String pseudo;
    public String image;
    private int force;
    private boolean aEvolue;
    private int pointDeVie;
    private int mana;
    /**
     * Indique si le personnage est vivant ou non
     */
    private boolean statutVivant = true;
    /**
     * Objet permettant de gérer les troupes du personnage
     */
    private GestionnaireArmee gestionnaireArmee;
    /**
     * Indique l'espèce du personnage : Empereur ou Démon
     */
    private Espece espece;

    private static String imageFile;

    public Personnage(){
        this.pseudo="Perso generique";
        this.image="";
        this.espece = null;
        //this.gestionnaireArmee = new GestionnaireArmee();
    }

    public Personnage(Espece espece){
        this.pseudo="Perso generique";
        this.image="";
        this.espece = espece;
        //this.gestionnaireArmee = new GestionnaireArmee();
    }

    public Personnage(String pseudo, String image, Espece espece){
        this.pseudo=pseudo;
        this.image=image;
        this.espece= espece;
    }

    public Personnage(Espece espece, String image){
        this.image=image;
        this.espece= espece;
    }

    /**
     * Permet à un personnage d'en attaquer un autre
     * @param personnage
     */
    public void attaquer(Personnage personnage) {
//        if(!this.statutVivant)
//            throw new DeadCharacterException("Un personnage mort ne peut pas attaquer");
        try {
            if(!this.statutVivant)
                throw new DeadCharacterException("Un personnage mort ne peut pas attaquer");
            personnage.perdrePV(this.force);
        }catch (DeadCharacterException e){
            e.printStackTrace();
        }
    }

    /**
     * Est censé permettre une attaque avec de la mana
     * @param personnage
     */
    public void attaquerMana(Personnage personnage){
        if(this.mana > 10){
            personnage.perdrePV(this.force+(this.force/2));
            this.mana-=10;
        }
        else
            this.attaquer(personnage);
    }

    /**
     * Permet de faire perdre des points de vie au personnage
     * @param pertePV
     */
    public void perdrePV(int pertePV){
        this.pointDeVie-=pertePV;
        if(this.pointDeVie <= 0)
            this.mourir();
    }

    @Override
    @Deprecated
    public Personnage evoluerGrade() {
        return null;
    }

    /**
     * Fait évoluer le personnage vers un type de Capitaine ou de Général selon sa classe
     * @param p
     * @return
     */
    public static Personnage evoluerGradePerso(Personnage p){
        if (p instanceof Capitaine) {
            p = Capitaine.evoluerGrade(p);
        }else if(p instanceof Soldat){
            p = Soldat.evoluerGrade(p);
        }
        return p;
    }

    /**
     * Fait mourir le personnage
     */
    public void mourir() {
        this.statutVivant= false;
    }

    /**
     * Indique si le personnage est vivant ou non
     * @return
     */
    public boolean estVivant(){
        return this.statutVivant;
    }

    /**
     * Permet de mette à jour les statistiques du personnage
     * @param force
     * @param pointDeVie
     * @param mana
     */
    public void setStatistiques(int force, int pointDeVie, int mana){
        this.force = force;
        this.pointDeVie = pointDeVie;
        this.mana = mana;
    }

    @Deprecated
    public void setPersonnage(Personnage p){

    }

    /**
     * Permet de mettre à jour le gestionnaire d'armée du personnage
     * @param gestionnaireArmee
     */
    public void setGestionnaireArmee(GestionnaireArmee gestionnaireArmee){
        this.gestionnaireArmee = gestionnaireArmee;
    }

    /**
     * Indique les points de vie du personnage
     * @return
     */
    public int getPointDeVie(){
        return this.pointDeVie;
    }

    /**
     * Indique la force du personnage
     * @return
     */
    public int getForce(){
        return this.force;
    }

    /**
     * Indique la mana du personnage
     * @return
     */
    public int getMana(){
        return this.mana;
    }

    /**
     * Indique le gestionnaire d'armée du personnage
     * @return
     */
    public GestionnaireArmee getGestionnaireArmee(){
        return this.gestionnaireArmee;
    }

    /**
     * Indique si le personnage est un empereur ou non
     * @return
     */
    public boolean isEmpereur(){
        return this.espece == Espece.EMPEREUR;
    }

    /**
     * Permet de modifier l'espèce du personnage
     * @param espece
     */
    public void setEspece(Espece espece){
        this.espece = espece;
    }

    /**
     * Indique si le personnage est un démon ou non
     * @return
     */
    public boolean isDemon(){
        return this.espece == Espece.DEMON;
    }

    /**
     * Renvoie l'espèce du personnage
     * @return
     */
    public Espece getEspece(){
        return this.espece;
    }

    /**
     * Renvoie une description textuelle du personnage
     * @return
     */
    @Override
    public String toString(){
        String classe = this.getClass().getName();
        classe = classe.substring(classe.lastIndexOf('.')+1);
        return classe + " : " + " Force " + this.force + " PV : " + this.pointDeVie + " Mana : " + this.mana;
    }

    /**
     * Permet de définir le chemin vers l'image du personnage
     * @param image
     */
    public static void setImageFile(String image){
        imageFile = image;
    }

    /**
     * Permet de définir le chemin vers l'image du personnage
     * @param image
     */
    public void setImageFilePersonnage(String image){
        imageFile = image;
        this.image = image;
    }

    /**
     * Renvoie le chemin vers l'image du personnage
     * @return
     */
    public static String getImage(){
        return imageFile;
    }
    public String getImagePersonnage(){
        return image;
    }

    /**
     * Permet de définir l'espèce du personnage à partir d'un String
     * @param especeString
     */
    public void setEspeceFromString(String especeString) {
        // Utilisez une méthode ou une logique pour convertir la chaîne en valeur d'Espece
        Espece espece = convertStringToEspece(especeString);

        // Définissez l'espèce du personnage
        setEspece(espece);
    }

    /**
     * Donne l'espèce à partir d'un String
     * @param especeString
     * @return
     */
    private Espece convertStringToEspece(String especeString) {
        // Logique pour convertir la chaîne en valeur d'Espece
        if (especeString.contains("Empereur")) {
            return Espece.EMPEREUR;
        } else if (especeString.contains("Démon")) {
            return Espece.DEMON;
        } else {
            // Gérez le cas où la chaîne ne correspond à aucune espèce connue
            throw new IllegalArgumentException("Espèce inconnue : " + especeString);
        }
    }

    public void setaEvolue(boolean aEvolue) {
        this.aEvolue = aEvolue;
    }

    public boolean aEvolue() {
        return aEvolue;
    }
}
