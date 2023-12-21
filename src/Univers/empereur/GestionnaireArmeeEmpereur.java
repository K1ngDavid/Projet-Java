package Univers.empereur;

import Univers.*;

public class GestionnaireArmeeEmpereur extends GestionnaireArmee {

    private int nombreSilvios;
    private int nomrbreTank;
    private int nombreEpeiste;

    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    private Silvios troupeSilvios;
    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    private Tank troupeTanks;
    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    private Epeiste troupeEpeistes;

    public GestionnaireArmeeEmpereur(){
        super();

        this.nombreSilvios = 0;
        this.nomrbreTank = 0;
        this.nombreEpeiste = 0;
    }

    /**
     * initialise les troupes à l'aide de la classe mère qui prend en entrée l'espèce, ici, Empereur
     */
    public void initTroupes(){
        super.initTroupes(Espece.EMPEREUR);
        //this.troupeSilvios= new Silvios();
        //this.troupeTanks = new Tank();
        //this.troupeEpeistes= new Epeiste();
    }

    /**
     * Définit les caractéristiques de l'armée en fonction de la classe du personnage donné en paramètre
     * et renvoie la dite armée
     * @param personnage
     * @return
     */
    public static GestionnaireArmeeEmpereur setArmee(Personnage personnage){
        GestionnaireArmeeEmpereur gestionnaireArmeeEmpereur = new GestionnaireArmeeEmpereur();
        gestionnaireArmeeEmpereur.initTroupes();

        if(personnage.isEmpereur()){
            //gestionnaireArmeeEmpereur.troupeSilvios = new Silvios();
            //gestionnaireArmeeEmpereur.troupeTanks = new Tank();
            //gestionnaireArmeeEmpereur.troupeEpeistes = new Epeiste();

            if(personnage instanceof Silvios){
                gestionnaireArmeeEmpereur.updateNombreArchers(15);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(5);
                gestionnaireArmeeEmpereur.updateNombreFantassins(5);

                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(5, 5, 5);
            }
            else if(personnage instanceof Tank){
                gestionnaireArmeeEmpereur.updateNombreArchers(5);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(15);
                gestionnaireArmeeEmpereur.updateNombreFantassins(5);

                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(5, 5, 5);
            }
            else if(personnage instanceof Epeiste){
                gestionnaireArmeeEmpereur.updateNombreArchers(5);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(5);
                gestionnaireArmeeEmpereur.updateNombreFantassins(15);

                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(10, 10, 10);
            }
            else if(personnage instanceof BerserkerDeLApocalyspse){
                gestionnaireArmeeEmpereur.updateNombreArchers(1000);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(1000);
                gestionnaireArmeeEmpereur.updateNombreFantassins(1000);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(5, 5, 5);
                /*
                gestionnaireArmeeEmpereur.updateNombreSilvios(20);
                gestionnaireArmeeEmpereur.updateNomrbreTank(20);
                gestionnaireArmeeEmpereur.updateNombreEpeiste(20);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesSilvios(80, 160, 80);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesTank(80, 160, 50);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesEpeiste(90, 120, 70);

                 */
            }
            else if(personnage instanceof MageSaint){
                gestionnaireArmeeEmpereur.updateNombreArchers(1000);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(1000);
                gestionnaireArmeeEmpereur.updateNombreFantassins(1000);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(5, 5, 5);

                /*
                gestionnaireArmeeEmpereur.updateNombreSilvios(20);
                gestionnaireArmeeEmpereur.updateNomrbreTank(20);
                gestionnaireArmeeEmpereur.updateNombreEpeiste(20);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesSilvios(80, 160, 80);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesTank(80, 160, 50);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesEpeiste(90, 120, 70);

                 */
            }
            else if (personnage instanceof SaintPaladin){
                gestionnaireArmeeEmpereur.updateNombreArchers(1000);
                gestionnaireArmeeEmpereur.updateNombreCavaliers(1000);
                gestionnaireArmeeEmpereur.updateNombreFantassins(1000);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesArchers(10, 10, 10);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesCavaliers(5, 5, 5);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesFantassins(5, 5, 5);
                /*
                gestionnaireArmeeEmpereur.updateNombreSilvios(20);
                gestionnaireArmeeEmpereur.updateNomrbreTank(20);
                gestionnaireArmeeEmpereur.updateNombreEpeiste(20);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesSilvios(80, 160, 80);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesTank(80, 160, 50);
                gestionnaireArmeeEmpereur.setCaractéristiquesTroupesEpeiste(90, 120, 70);

                 */
            }
        }
        return gestionnaireArmeeEmpereur;
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


    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    public void setCaractéristiquesTroupesSilvios(int force, int pointDeVie, int mana){
        this.troupeSilvios.setStatistiques(force*this.nombreSilvios, pointDeVie*this.nombreSilvios, mana*this.nombreSilvios);
    }
    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    public void setCaractéristiquesTroupesTank(int force, int pointDeVie, int mana){
        this.troupeTanks.setStatistiques(force*this.nomrbreTank, pointDeVie*this.nomrbreTank, mana*this.nomrbreTank);
    }
    /**
     * @deprecated Non utilisé car crée une StackOverflow error
     */
    public void setCaractéristiquesTroupesEpeiste(int force, int pointDeVie, int mana){
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

    /*
    @Override
    public String toString(){
        return super.toString() + "\n[Silvios] : " + this.nombreSilvios + " [Epeistes] : " + this.nombreEpeiste +
                " [Tanks] : " + this.nomrbreTank;
    }
     */
}
