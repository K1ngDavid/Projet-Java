package Univers;

public class Cavalier extends Soldat{

    public Cavalier(Espece espece){
        super(espece);
        if(this.isEmpereur()){
            image = "src/Images/cavalier_empereur.png";
        }else{
            image = "src/Images/cavalier_demon.png";
        }
    }
    public Cavalier(Espece espece,String image){
        super(espece,image);
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
