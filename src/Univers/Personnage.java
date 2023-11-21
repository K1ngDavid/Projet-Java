package Univers;

//abstract ?
public class Personnage implements ActionsPersonnage {
    private String pseudo;
    private String image;
    private int force;
    private int pointDeVie;
    private int mana;
    private boolean statutVivant = true;
    private GestionnaireArmee gestionnaireArmee;
    private Espece espece;

    public Personnage(){
        this.pseudo="Perso generique";
        this.image="";
        this.espece = Espece.EMPEREUR;
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

    public boolean isDemon(){
        return this.espece == Espece.DEMON;
    }

    public Espece getEspece(){
        return this.espece;
    }

    public String toString(){
        String classe = this.getClass().getName();
        classe = classe.substring(classe.lastIndexOf('.')+1);
        return classe + " : " + " Force " + this.force + " PV : " + this.pointDeVie + " Mana : " + this.mana;
    }
}
