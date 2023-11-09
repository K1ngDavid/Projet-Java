package Univers;

public abstract class Personnage implements ActionsPersonnage{
    private String pseudo;
    private String image;
    private int force;
    private int pointDeVie;
    private int mana;
    private boolean statutVivant = true;
    private GestionnaireArmee gestionnaireArmee;

    public Personnage(){
        this.pseudo="Perso generique";
        this.image="";
    }

    public Personnage(String pseudo, String image, GestionnaireArmee gestionnaireArmee){
        this.pseudo=pseudo;
        this.image=image;
        this.gestionnaireArmee = gestionnaireArmee;
    }

    public void attaquer(Personnage personnage) {
        personnage.perdrePV(this.force);
    }

    private void perdrePV(int pertePV){
        this.pointDeVie-=pertePV;
        if(this.pointDeVie <= 0)
            this.mourir();
    }

    private void mourir() {
        this.statutVivant= false;
    }

    public void setStatistiques(int force, int pointDeVie, int mana){
        this.force = force;
        this.pointDeVie = pointDeVie;
        this.mana = mana;
    }

    public GestionnaireArmee getGestionnaireArmee(){
        return this.gestionnaireArmee;
    }

    public String toString(){
        return pseudo + "PV : " + this.pointDeVie;
    }
}
