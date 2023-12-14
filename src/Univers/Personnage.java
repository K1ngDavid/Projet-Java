package Univers;

import java.io.Serializable;

//abstract ?
public class Personnage implements ActionsPersonnage, Serializable {
    private String pseudo;
    private String image;
    private int force;
    private int pointDeVie;
    private int mana;
    private boolean statutVivant = true;
    private GestionnaireArmee gestionnaireArmee;
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

    public Personnage(String pseudo, String image, GestionnaireArmee gestionnaireArmee, Espece espece){
        this.pseudo=pseudo;
        this.image=image;
        this.espece= espece;
        //this.gestionnaireArmee = gestionnaireArmee;
    }

    public void attaquer(Personnage personnage) {
        personnage.perdrePV(this.force);
    }

    public void attaquerMana(Personnage personnage){
        if(this.mana > 10){
            personnage.perdrePV(this.force+(this.force/2));
            this.mana-=10;
        }
        else
            this.attaquer(personnage);
    }
    public void perdrePV(int pertePV){
        this.pointDeVie-=pertePV;
        if(this.pointDeVie <= 0)
            this.mourir();
    }

    @Override
    public Personnage evoluerGrade() {
        return null;
    }

    private void mourir() {
        this.statutVivant= false;
    }

    public void setStatistiques(int force, int pointDeVie, int mana){
        this.force = force;
        this.pointDeVie = pointDeVie;
        this.mana = mana;
    }

    public Personnage setPersonnage(Personnage p){
         return null;
    }

    public void setGestionnaireArmee(GestionnaireArmee gestionnaireArmee){
        this.gestionnaireArmee = gestionnaireArmee;
    }

    public int getPointDeVie(){
        return this.pointDeVie;
    }
    public int getForce(){
        return this.force;
    }
    public int getMana(){
        return this.mana;
    }

    public GestionnaireArmee getGestionnaireArmee(){
        return this.gestionnaireArmee;
    }

    public boolean isEmpereur(){
        return this.espece == Espece.EMPEREUR;
    }

    public void setEspece(Espece espece){
        this.espece = espece;
    }

    public boolean isDemon(){
        return this.espece == Espece.DEMON;
    }

    public Espece getEspece(){
        return this.espece;
    }

    @Override
    public String toString(){
        String classe = this.getClass().getName();
        classe = classe.substring(classe.lastIndexOf('.')+1);
        return classe + " : " + " Force " + this.force + " PV : " + this.pointDeVie + " Mana : " + this.mana;
    }

    public static void setImageFile(String image){
        imageFile = image;
    }
    public void setImageFilePersonnage(String image){
        imageFile = image;
        this.image = image;
    }

    public static String getImage(){
        return imageFile;
    }
    public String getImagePersonnage(){
        return image;
    }

    public void setEspeceFromString(String especeString) {
        // Utilisez une méthode ou une logique pour convertir la chaîne en valeur d'Espece
        Espece espece = convertStringToEspece(especeString);

        // Définissez l'espèce du personnage
        setEspece(espece);
    }

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
}
