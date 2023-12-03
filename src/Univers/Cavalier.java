package Univers;

public class Cavalier extends Soldat{


    public Cavalier(Espece espece){
        super(espece);
    }



    public static Cavalier setCavalier(Personnage personnage){
        personnage = new Cavalier(personnage.getEspece());
        //personnage = new Cavalier();
        if(personnage.isEmpereur()){
            personnage.setStatistiques(10, 10, 5);
        }
        else if(personnage.isDemon()){
            personnage.setStatistiques(10, 15, 5);
        }
        return (Cavalier) personnage;
    }
}
